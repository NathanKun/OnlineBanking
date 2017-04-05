﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Index</title>
    	<link rel="stylesheet" href="./css/global.css" type="text/css">
    	<link rel="stylesheet" href="./css/subscribe.css" type="text/css">
	</head>
	
	<body>
		<div id="wrapper"><!-- #wrapper -->
			<%@ include file="../includes/header.inc.jsp"%>
		
			<section id="main"><!-- #main content and sidebar area -->
				<section id="content"><!-- #content -->
			
			        <form id="form" action="./Subscribe" onsubmit="return checkInputs()" method="post">
			            <fieldset>
			
			                <legend>Vos coordonnees :</legend>
			
			                <p>Vous etes :</p>
			
			                <select name="sexe">
								<option value="F">Une femme</option>
								<option value="M">Un homme</option>
							</select>
			
			                <label for="nom"> Nom :</label>
			                <input type="text" name="nom" id="nom" size="20" maxlength="30" required />
			
			                <label for="prenom"> Prenom :</label>
			                <input type="text" id="prenom" name="prenom" size="20" maxlength="30" required />
			
			                <label for="naissance">Date de naissance :</label>
			                     <input type="number" name="jour" min="1" max="31" style="width: 3em;" required >
				                 <input type="number"  name="mois" min="1" max="12" style="width: 3em;"  required >
				                 <input type="number"  name="annee" min="1900" max="2000" style="width: 6em;" required >
                <label for="nationalite"> Nationalite :</label>

			                <select id="nationalite" name="nationalite" required>
								<option>	Afghan	</option>
								<option>	Albanais	</option>
								<option>	Algerien	</option>
								<option>	Allemand	</option>
								<option>	Americain	</option>
								<option>	Angolais	</option>
								<option>	Argentin	</option>
								<option>	Armenien	</option>
								<option>	Australien	</option>
								<option>	Autrichien	</option>
								<option>	Bangladais	</option>
								<option>	Belge	</option>
								<option>	Beninois	</option>
								<option>	Bosniaque	</option>
								<option>	Botswanais	</option>
								<option>	Bhoutan	</option>
								<option>	Bresilien	</option>
								<option>	Britannique	</option>
								<option>	Bulgare	</option>
								<option>	Burkinabe	</option>
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
								<option>	Europeen	</option>
								<option>	Finlandais	</option>
								<option>	Français	</option>
								<option>	Gabonais	</option>
								<option>	Georgien	</option>
								<option>	Grec	</option>
								<option>	Guineen	</option>
								<option>	Haïtien	</option>
								<option>	Hollandais	</option>
								<option>	Hong-Kong	</option>
								<option>	Hongrois	</option>
								<option>	Indien	</option>
								<option>	Indonesien	</option>
								<option>	Irakien	</option>
								<option>	Iranien	</option>
								<option>	Irlandais	</option>
								<option>	Islandais	</option>
								<option>	Israelien	</option>
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
								<option>	Macedonien	</option>
								<option>	Madagascar	</option>
								<option>	Malaisien	</option>
								<option>	Malien	</option>
								<option>	Maltais	</option>
								<option>	Marocain	</option>
								<option>	Mauritanien	</option>
								<option>	Mauricien	</option>
								<option>	Mexicain	</option>
								<option>	Monegasque	</option>
								<option>	Mongol	</option>
								<option>	Neo-Zelandais	</option>
								<option>	Nigerien	</option>
								<option>	Nord Coreen	</option>
								<option>	Norvegien	</option>
								<option>	Pakistanais	</option>
								<option>	Palestinien	</option>
								<option>	Peruvien	</option>
								<option>	Philippins	</option>
								<option>	Polonais	</option>
								<option>	Portoricain	</option>
								<option>	Portugais	</option>
								<option>	Roumain	</option>
								<option>	Russe	</option>
								<option>	Senegalais	</option>
								<option>	Serbe	</option>
								<option>	Serbo-croate	</option>
								<option>	Singapour	</option>
								<option>	Slovaque	</option>
								<option>	Sovietique	</option>
								<option>	Sri-lankais	</option>
								<option>	Sud-Africain	</option>
								<option>	Sud-Coreen	</option>
								<option>	Suedois	</option>
								<option>	Suisse	</option>
								<option>	Syrien	</option>
								<option>	Tadjik	</option>
								<option>	Taïwanais	</option>
								<option>	Tchadien	</option>
								<option>	Tcheque	</option>
								<option>	Thailandais	</option>
								<option>	Tunisien	</option>
								<option>	Turc	</option>
								<option>	Ukrainien	</option>
								<option>	Uruguayen	</option>
								<option>	Venezuelien	</option>
								<option>	Vietnamien	</option>
			                </select>
			                
			                <label for="adresse">Adresse :</label>
			                <input type="text" id="adresse" name="adresse" size="20" maxlength="255" required />
			
			                <label for="codepostal">Code postal :</label>
			                <input type="text" id="codepostal" name="codepostal" size="20" maxlength="10" onchange="getCity()" required />
			
			                <label for="ville"> Ville :</label>
			                <input type="text" id="ville" name="ville" size="20" maxlength="30" required />
			
			                <label for="tel">Numero de telephone :</label>
			                <input type="tel" id="tel" name="tel" pattern="[0-9]{10}" placeholder = "10 chiffres" size="20" maxlength="14" required />
			
			                <label for="email">Email:</label>
			                <input type="email" id="email" name="email" size="20" maxlength="20" required />
			
			                <label for="password">Choisissez un mot de passe :</label>
			                <input type="password" id="password" name="password" size="20" maxlength="20" onchange="checkPw()" required />
			
			                <label for="cmdp">Confirmez votre mot de passe :</label>
			                <input type="password" id="password2" name="password2" size="20" maxlength="20" onchange="checkPw()" required />
			
			                <label id="hint"></label> <br /> 
			                Vous etes :<br />
			                <select name="statut" required>
								<option>Un(e) etudiant(e)</option>
								<option>Un professionnel</option>
								<option>En recherche d'emploi</option>
							</select>
			
			
			            </fieldset>
			
			
			            <fieldset>
			
			                <legend> Compte supplementaire </legend>
			
			                <p>Voulez- vous creer un second compte ? Si oui choississez le(s) type(s) de compte :</p>
			                <table>
				                <tr>
					                <td><input class="checkBoxes" type="checkbox" name="epargneCheckBox" id="epargneCheckBox" /></td>
					                <td><label class="lbForCheckBox" for="epargneCheckBox">Compte epargne</label></td>
				                </tr>
				                <tr>
					                <td><input class="checkBoxes" type="checkbox" name="titreCheckBox" id="titreCheckBox" /></td>
					                <td><label class="lbForCheckBox" for="titreCheckBox"> Compte titre </label> </td>
								</tr>
							</table>
			            </fieldset>
			
			            <p>
			                <input type="submit" id="submit" />
			                <input type="reset" />
			            </p>
			
			        </form>
				
				
				
				</section><!-- end of #content -->
				<%@ include file="../includes/loginFormInIndex.inc.jsp"%>
			</section>
			
	</div><!-- #wrapper -->
	
	

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://rawgit.com/leizongmin/js-xss/master/dist/xss.js"></script>
	<script src="./js/subscribe.js"></script>
	
	
	</body>
</html>

