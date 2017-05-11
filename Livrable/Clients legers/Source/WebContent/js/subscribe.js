/**
 * js file to handle subscribe events
 */

var isEmailChecked = false;

// accent folding for typeahead
var charMap = {
	"à" : "a",
	"á" : "a",
	"â" : "a",
	"ç" : "c",
	"é" : "e",
	"è" : "e",
	"ê" : "e",
	"ë" : "e",
	"É" : "e",
	"ï" : "i",
	"î" : "i",
	"ô" : "o",
	"ö" : "o",
	"û" : "u",
	"ù" : "u",
	"ü" : "u",
	"ñ" : "n"
};

var normalize = function(input) {
	$.each(charMap, function(unnormalizedChar, normalizedChar) {
		var regex = new RegExp(unnormalizedChar, 'gi');
		input = input.replace(regex, normalizedChar);
	});
	return input;
};

var queryTokenizer = function(q) {
	var normalized = normalize(q);
	return Bloodhound.tokenizers.whitespace(normalized);
};

// autocomplete suggestion
var bloodHound = new Bloodhound({
	datumTokenizer : Bloodhound.tokenizers.obj.whitespace('value'),
	queryTokenizer : queryTokenizer,
	local : []
});

bloodHound.initialize();

$('#inputAddress').typeahead({
	minLength : 1,
	hint : false,
	highlight : true
}, {
	displayKey : 'displayValue',
	source : bloodHound.ttAdapter()
});

// user select suggestion or tab on tab key
function onSelect(data){
	array = $('#inputAddress').val().split(', ');
	$('#adresse').val(array[0]);
	$('#codepostal').val(array[1]);
	$('#ville').val(array[2]);
}
$('#inputAddress').on('typeahead:selected', function (e, data) {
	onSelect(data);
}).on('typeahead:autocompleted', function (e, data) {
	onSelect(data);
});

String.prototype.removeAccents = function() {
	return this.replace(/[áàãâä]/gi, "a").replace(/[éè¨ê]/gi, "e").replace(
			/[íìïî]/gi, "i").replace(/[óòöôõ]/gi, "o").replace(/[úùüû]/gi, "u")
			.replace(/[ç]/gi, "c").replace(/[ñ]/gi, "n").replace(
					/[^a-zA-Z0-9]/g, " ");
}

var addressList = [];

function addressChange() {
	var inputText = $('#inputAddress').val();

	// Ajax get options
	$.get("./SearchAddress", {
		q : inputText
	}, function(responseText) {
		addressList = responseText.split(';');
		var bloodHountData = $.map(addressList, function(addressList) {
			// Normalize the name - use this for searching
			var normalized = normalize(addressList);
			return {
				value : normalized,
				// Include the original addressList - use this for display
				// purposes
				displayValue : addressList
			};
		});
		bloodHound.clear();
		bloodHound.add(bloodHountData);
	});
}

// XSS special characters check
function checkXSS(input) {
	var filteredInput = filterXSS(input);
	if (input != filteredInput) {
		return false;
	}
	return true;
}

// Check all inputs
function checkInputs() {
	var fname = document.getElementById("prenom").value;
	var lname = document.getElementById("nom").value;
	var address = document.getElementById("adresse").value;
	var postalcode = document.getElementById("codepostal").value;
	var city = document.getElementById("ville").value;
	var email = document.getElementById("email").value;
	var tel = document.getElementById("tel").value;
	
	var isOK = false;
	var rt = false;
	
	if (checkXSS(fname)) {
		if (checkXSS(lname)) {
			if (checkXSS(address)) {
				if (checkXSS(postalcode)) {
					if (checkXSS(city)) {
						if (checkXSS(email)) {
							if (checkXSS(tel)) {
								if (tel.startsWith("0") && tel.length == 10) {
									isOK = true;
								} else if (tel.startsWith("+33")
										&& tel.length == 12) {
									isOK = true;
								} else if (tel.startsWith("0033")
										&& tel.length == 13) {
									isOK = true;
								} else {
									$('#hint').text("Votre numéro de téléphone est incorrect");
								}
							} else {
								$('#hint').text("Les caractères spécials sont interdits dans le numéro de téléphone");
							}
						} else {
							$('#hint').text("Les caractères spécials sont interdits dans le mail");
						}
					} else {
						$('#hint').text("Les caractères spécials sont interdits dans le nom de la ville");
					}
				} else {
					$('#hint').text("Les caractères spécials sont interdits dans le code postal");
				}
			} else {
				$('#hint').text("Les caractères spécials sont interdits dans l'adresse");
			}
		} else {
			$('#hint').text("Les caractères spécials sont interdits dans le nom");
		}
	} else {
		$('#hint').text("Les caractères spécials sont interdits dans le prénom");
	}

	if(isOK && !isEmailChecked){
		$.post( "./EmailCheck", { action: "send", email: $('#email').val() })
		  .done(function(res) {
			    if(res == "ok"){
					$('#subscribeFormDiv').hide();
					$('#submitBtn').prop('disabled', true);
					$('#emailCheckDiv').show();
					$('#hint').text("");
			    } else {
					$('#hint').text("ERREUR");
			    }
		});
	} else if(isOK && isEmailChecked){
		rt = true;
	}
	
	return rt;
	
}

// check if 2 passwords are the same
function checkPw() {
	var pw1 = document.getElementById("password").value;
	var pw2 = document.getElementById("password2").value;

	if (pw1.length < 6) {
		document.getElementById('submitBtn').disabled = true;
		document.getElementById("hint").innerHTML = "Le mot de passe est trop court";
	} else {
		if (pw1 == pw2) {
			document.getElementById('submitBtn').disabled = false;
			document.getElementById("hint").innerHTML = "";
		} else {
			document.getElementById('submitBtn').disabled = true;
			document.getElementById("hint").innerHTML = "Deux mots de passe sont différents";
		}
	}
}


$(document).on("click", "#emailCheckSubmit", function() {
	$.post( "./EmailCheck", { action: "check", code: $('#code').val() })
	  .done(function(res) {
    	if(res == "incorrect"){
            $("#hint2").text("Code incorrect");
    	} else if(res == "ok"){
    		isEmailChecked = true;
    		$('#subscribeForm').submit();
    	}
    });
});