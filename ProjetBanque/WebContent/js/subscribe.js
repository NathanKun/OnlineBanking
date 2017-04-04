/**
 * js file to handle subscribe events
 */
window.onload = function() {
    // set max date
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1; //January is 0!
    var yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd
    }
    if (mm < 10) {
        mm = '0' + mm
    }

    today = yyyy + '-' + mm + '-' + dd;

    document.getElementById("naissance").setAttribute("max", today);

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
    var password = document.getElementById("password").value;

    if (checkXSS(fname)) {
        if (checkXSS(lname)) {
            if (checkXSS(address)) {
                if (checkXSS(postalcode)) {
                    if (checkXSS(city)) {
                        if (checkXSS(email)) {
                            if (checkXSS(password)) {
                                return true;
                            } else {
                                alert("Les caractères spécials sont interdits dans le mot de pass");
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
}

// check if 2 passwords are the same
function checkPw() {
    var pw1 = document.getElementById("password").value;
    var pw2 = document.getElementById("password2").value;

    if (pw1.length < 6) {
        document.getElementById('submit').disabled = true;
        document.getElementById("hint").innerHTML = "Le mot de passe est trop court"
    } else {
        if (pw1 == pw2) {
            document.getElementById('submit').disabled = false;
            document.getElementById("hint").innerHTML = "";
        } else {
            document.getElementById('submit').disabled = true;
            document.getElementById("hint").innerHTML = "Deux mots de passe sont différents"
        }
    }
}

function jsoncallback(data) {
    // il y a une erreur retournée
    if (typeof data.erreur != "undefined") {
        // mettre en place un affichage
        alert('Erreur ramenée par le serveur\n Libellé : ' + data.erreur);
        //$("#cpoucommune").hide();
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
            cpcommune: document.getElementById("codepostal").value
        });
    }
}