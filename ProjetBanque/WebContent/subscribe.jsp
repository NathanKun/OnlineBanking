<!DOCTYPE html>
<html>

<head>
    <title>Page inscription</title>
    <link rel="stylesheet" type="text/css" href="./css/subscribe.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://rawgit.com/leizongmin/js-xss/master/dist/xss.js"></script>
    <meta charset="utf-8">
</head>

<body>

    <div id="bandeau">Ceci est le bandeau</div>
    <div id="menu">Ceci est le menu</div>

    <div id="contenu">
        <form action="./Subscribe" onsubmit="return checkInputs()" method="post">
            <fieldset>

                <legend>Vos coordonnées :</legend>

                <p>Vous êtes :</p>

                <select name="sexe">
					<option value="F">Une femme</option>
					<option value="M">Un homme</option>
				</select>

                <label for="nom"> Nom :</label>
                <input type="text" name="nom" id="nom" size="20" maxlength="30" required />

                <label for="prenom"> Prénom :</label>
                <input type="text" id="prenom" name="prenom" size="20" maxlength="30" required />

                <label for="naissance">Date de naissance :</label>
                <input type="date" id="naissance" name="naissance" size="20" min='1899-01-01' max='2000-13-13' required />

                <label for="nationalite"> Nationalité :</label>
                <select id="nationalite" name="nationalite" required>
                    <option>	Afghan	</option>
                    <option>	Albanais	</option>
                    <option>	Algérien	</option>
                    <option>	Allemand	</option>
                    <option>	Américain	</option>
                    <option>	Angolais	</option>
                    <option>	Argentin	</option>
                    <option>	Arménien	</option>
                    <option>	Australien	</option>
                    <option>	Autrichien	</option>
                    <option>	Bangladais	</option>
                    <option>	Belge	</option>
                    <option>	Béninois	</option>
                    <option>	Bosniaque	</option>
                    <option>	Botswanais	</option>
                    <option>	Bhoutan	</option>
                    <option>	Brésilien	</option>
                    <option>	Britannique	</option>
                    <option>	Bulgare	</option>
                    <option>	Burkinabè	</option>
                    <option>	Cambodgien	</option>
                    <option>	Camerounais	</option>
                    <option>	Canadien	</option>
                    <option>	Chilien	</option>
                    <option>	Chinois	</option>
                    <option>	Colombien	</option>
                    <option>	Congolais	</option>
                    <option>	Cubain	</option>
                    <option>	Danois	</option>
                    <option>	Ecossais	</option>
                    <option>	Egyptien	</option>
                    <option>	Espagnol	</option>
                    <option>	Estonien	</option>
                    <option>	Européen	</option>
                    <option>	Finlandais	</option>
                    <option>	Français	</option>
                    <option>	Gabonais	</option>
                    <option>	Georgien	</option>
                    <option>	Grec	</option>
                    <option>	Guinéen	</option>
                    <option>	Haïtien	</option>
                    <option>	Hollandais	</option>
                    <option>	Hong-Kong	</option>
                    <option>	Hongrois	</option>
                    <option>	Indien	</option>
                    <option>	Indonésien	</option>
                    <option>	Irakien	</option>
                    <option>	Iranien	</option>
                    <option>	Irlandais	</option>
                    <option>	Islandais	</option>
                    <option>	Israélien	</option>
                    <option>	Italien	</option>
                    <option>	Ivoirien	</option>
                    <option>	Jamaïcain	</option>
                    <option>	Japonais	</option>
                    <option>	Kazakh	</option>
                    <option>	Kirghiz	</option>
                    <option>	Kurde	</option>
                    <option>	Letton	</option>
                    <option>	Libanais	</option>
                    <option>	Liechtenstein	</option>
                    <option>	Lituanien	</option>
                    <option>	Luxembourgeois	</option>
                    <option>	Macédonien	</option>
                    <option>	Madagascar	</option>
                    <option>	Malaisien	</option>
                    <option>	Malien	</option>
                    <option>	Maltais	</option>
                    <option>	Marocain	</option>
                    <option>	Mauritanien	</option>
                    <option>	Mauricien	</option>
                    <option>	Mexicain	</option>
                    <option>	Monégasque	</option>
                    <option>	Mongol	</option>
                    <option>	Néo-Zélandais	</option>
                    <option>	Nigérien	</option>
                    <option>	Nord Coréen	</option>
                    <option>	Norvégien	</option>
                    <option>	Pakistanais	</option>
                    <option>	Palestinien	</option>
                    <option>	Péruvien	</option>
                    <option>	Philippins	</option>
                    <option>	Polonais	</option>
                    <option>	Portoricain	</option>
                    <option>	Portugais	</option>
                    <option>	Roumain	</option>
                    <option>	Russe	</option>
                    <option>	Sénégalais	</option>
                    <option>	Serbe	</option>
                    <option>	Serbo-croate	</option>
                    <option>	Singapour	</option>
                    <option>	Slovaque	</option>
                    <option>	Soviétique	</option>
                    <option>	Sri-lankais	</option>
                    <option>	Sud-Africain	</option>
                    <option>	Sud-Coréen	</option>
                    <option>	Suédois	</option>
                    <option>	Suisse	</option>
                    <option>	Syrien	</option>
                    <option>	Tadjik	</option>
                    <option>	Taïwanais	</option>
                    <option>	Tchadien	</option>
                    <option>	Tchèque	</option>
                    <option>	Thaïlandais	</option>
                    <option>	Tunisien	</option>
                    <option>	Turc	</option>
                    <option>	Ukrainien	</option>
                    <option>	Uruguayen	</option>
                    <option>	Vénézuélien	</option>
                    <option>	Vietnamien	</option>
                </select>
                
                <label for="adresse">Adresse :</label>
                <input type="text" id="adresse" name="adresse" size="20" maxlength="255" required />

                <label for="codepostal">Code postal :</label>
                <input type="text" id="codepostal" name="codepostal" size="20" maxlength="10" onchange="getCity()" required />

                <label for="ville"> Ville :</label>
                <input type="text" id="ville" name="ville" size="20" maxlength="30" required />

                <label for="tel">Numéro de téléphone :</label>
                <input type="tel" id="tel" name="tel" pattern="[0-9]{10}" placeholder = "10 chiffres" size="20" maxlength="14" required />

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" size="20" maxlength="20" required />

                <label for="password">Choisissez un mot de passe :</label>
                <input type="password" id="password" name="password" size="20" maxlength="20" onchange="checkPw()" required />

                <label for="cmdp">Confirmez votre mot de passe :</label>
                <input type="password" id="password2" name="password2" size="20" maxlength="20" onchange="checkPw()" required />

                <label id="hint"></label> <br /> Vous êtes :<br />
                <select name="statut" required>
					<option>Un(e) étudiant(e)</option>
					<option>Un professionnel</option>
					<option>En recherche d'emploi</option>
				</select>


            </fieldset>


            <fieldset>

                <legend> Compte supplémentaire </legend>

                <p>Voulez- vous créer un second compte ? Si oui choississez le(s) type(s) de compte :</p>
                <label for=" epargneCheckBox">Compte épargne</label> <input class="checkBoxes" type="checkbox" name="epargneCheckBox" id="epargneCheckBox" /> <label for="titreCheckBox"> Compte titre </label> <input class="checkBoxes" type="checkbox" name="titreCheckBox" id="titreCheckBox" />

            </fieldset>

            <p>
                <input type="submit" id="submit" />
                <input type="reset" />
            </p>

        </form>
    </div>

    <div id="piedpage">Ceci est le pied de page</div>


    <script>

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
     	if(input != filteredInput){
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
    	
    	if(checkXSS(fname)){
    		if(checkXSS(lname)){
    			if(checkXSS(address)){
    				if(checkXSS(postalcode)){
    					if(checkXSS(city)){
    						if(checkXSS(email)){
    							if(checkXSS(password)){
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
            
        if(pw1.length < 6){
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
	    if (typeof data.erreur != "undefined") 
	    {
	    	// mettre en place un affichage
        	alert('Erreur ramenée par le serveur\n Libellé : '+ data.erreur);
        	//$("#cpoucommune").hide();
        	return;
        }  
        // Rien trouvé
        if (data.count == 0) 
       	{
       		$("#bc_dpt").hide();
        	$("#pasglop").show().delay(2000).fadeOut();
      		return;
    	}  

        document.getElementById("ville").value = data[1].ville;	// start by 1
    };
        
    function getCity() {
        // set nationality list
        if($("#codepostal").val().length == 5){
        	$.getJSON("http://www.cp-ville.com/cpcom.php?jsoncallback=?", { cpcommune:document.getElementById("codepostal").value }); 
        }
    }
    </script>



</body>

</html>
