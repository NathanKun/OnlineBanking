/**
 * js file to handle subscribe events
 */
String.prototype.removeAccents = function() {
	return this.replace(/[áàãâä]/gi, "a")
			.replace(/[éè¨ê]/gi, "e")
			.replace(/[íìïî]/gi, "i")
			.replace(/[óòöôõ]/gi, "o")
			.replace(/[úùüû]/gi, "u")
			.replace(/[ç]/gi, "c")
			.replace(/[ñ]/gi, "n")
			.replace(/[^a-zA-Z0-9]/g, " ");
}

function addressChange() {
	var inputText = $('#inputAddress').val();
	var addList = $('#addressList');

	// Ajax get options
	$.get("./SearchAddress", {
		q : inputText
	}, function(responseText) {
		addList.empty();
		addList.append(responseText);
	});

	// if input text match option(User selected a option)
	if ($('#addressList').find('option').filter(
			function() {
				return this.value.removeAccents().toUpperCase() === inputText
						.removeAccents().toUpperCase();
			}).length) {
		var array = inputText.split(', ');
		$('#adresse').val(array[0]);
		$('#codepostal').val(array[1]);
		$('#ville').val(array[2]);
	}
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
	if (checkXSS(fname)) {
		if (checkXSS(lname)) {
			if (checkXSS(address)) {
				if (checkXSS(postalcode)) {
					if (checkXSS(city)) {
						if (checkXSS(email)) {
							if (checkXSS(tel)) {
								if (tel.startsWith("0") && tel.length == 10) {
									return true;
								} else if (tel.startsWith("+33")
										&& tel.length == 12) {
									return true;
								} else if (tel.startsWith("0033")
										&& tel.length == 13) {
									return true;
								} else {
									alert("Votre numéro de téléphone est incorrect");
									return false;
								}
							} else {
								alert("Les caractères spécials sont interdits dans le numéro de téléphone");
								return false;
							}
						} else {
							alert("Les caractères spécials sont interdits dans le mail");
							return false;
						}
					} else {
						alert("Les caractères spécials sont interdits dans le nom de la ville");
						return false;
					}
				} else {
					alert("Les caractères spécials sont interdits dans le code postal");
					return false;
				}
			} else {
				alert("Les caractères spécials sont interdits dans l'adresse");
				return false;
			}
		} else {
			alert("Les caractères spécials sont interdits dans le nom");
			return false;
		}
	} else {
		alert("Les caractères spécials sont interdits dans le prénom");
		return false;
	}
	return false;
}

// check if 2 passwords are the same
function checkPw() {
	var pw1 = document.getElementById("password").value;
	var pw2 = document.getElementById("password2").value;

	if (pw1.length < 6) {
		document.getElementById('submit').disabled = true;
		document.getElementById("hint").innerHTML = "Le mot de passe est trop court";
	} else {
		if (pw1 == pw2) {
			document.getElementById('submit').disabled = false;
			document.getElementById("hint").innerHTML = "";
		} else {
			document.getElementById('submit').disabled = true;
			document.getElementById("hint").innerHTML = "Deux mots de passe sont différents";
		}
	}
}

function jsoncallback(data) {
	// il y a une erreur retournée
	if (typeof data.erreur != "undefined") {
		// mettre en place un affichage
		alert('Erreur ramenée par le serveur\n Libellé : ' + data.erreur);
		// $("#cpoucommune").hide();
		return;
	}
	// Rien trouvé
	if (data.count == 0) {
		$("#bc_dpt").hide();
		$("#pasglop").show().delay(2000).fadeOut();
		return;
	}

	document.getElementById("ville").value = data[1].ville; // start by 1
};

function getCity() {
	// set nationality list
	if ($("#codepostal").val().length == 5) {
		$.getJSON("http://www.cp-ville.com/cpcom.php?jsoncallback=?", {
			cpcommune : document.getElementById("codepostal").value
		});
	}
}