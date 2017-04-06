<%@ page
	import="model.Client, dao.DaoClient, model.Account, dao.DaoAccount, java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Modern Business - Start Bootstrap Template</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/modern-business.css" rel="stylesheet">
<link href="css/carousel.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<%
		Client clt = (Client) session.getAttribute("client");
	%>

	<%@ include file="./includes/nav.inc.jsp"%>

	<!-- Page Content -->
	<div class="container">



		<fieldset>
			<legend> Modifier vos informations : </legend>
			<!-- Titre du fieldset -->





			<form id="form" class="form-horizontal" action="./ModifyInfo"
				method="post">
				<table>

					<tr>

						<td><label>Identifiant </label> :</td>
						<td><%=clt.getClt_login()%></td>

					</tr>


					<tr>
						<td><label>Mot de passe </label> :</td>
						<td><input type="password" name="password" id="password" /></td>
					</tr>

					<tr>
						<td><label>Confirmer le mot de passe </label> :</td>
						<td><input type="password" name="clt_password"
							id="clt_password" /></td>
					</tr>

					<tr>
						<td><label>Nom</label> :</td>
						<td><input type="text" name="nom" id="nom"
							value="<%=clt.getClt_lname()%>" /></td>
					</tr>

					<tr>
						<td><label>Prenom</label> :</td>
						<td><input type="text" name="prenom" id="prenom"
							value="<%=clt.getClt_fname()%>" /></td>
					</tr>

					<tr>
						<td><label>Date de naissance</label> :</td>
						<td><input type="number" name="jour" min="1" max="31"
							style="width: 3em;" value="" required> <input
							type="number" name="mois" min="1" max="12" style="width: 3em;"
							value="" required> <input type="number" name="annee"
							min="1900" max="2000" style="width: 6em;" value="" required></td>
					</tr>

					<tr>
						<td><label>Nationalite</label> :</td>
						<td><select id="nationalite" name="nationalite" required>
								<option>Afghan</option>
								<option>Albanais</option>
								<option>Algerien</option>
								<option>Allemand</option>
								<option>Americain</option>
								<option>Angolais</option>
								<option>Argentin</option>
								<option>Armenien</option>
								<option>Australien</option>
								<option>Autrichien</option>
								<option>Bangladais</option>
								<option>Belge</option>
								<option>Beninois</option>
								<option>Bosniaque</option>
								<option>Botswanais</option>
								<option>Bhoutan</option>
								<option>Bresilien</option>
								<option>Britannique</option>
								<option>Bulgare</option>
								<option>Burkinabe</option>
								<option>Cambodgien</option>
								<option>Camerounais</option>
								<option>Canadien</option>
								<option>Chilien</option>
								<option>Chinois</option>
								<option>Colombien</option>
								<option>Congolais</option>
								<option>Cubain</option>
								<option>Danois</option>
								<option>Ecossais</option>
								<option>Egyptien</option>
								<option>Espagnol</option>
								<option>Estonien</option>
								<option>Europeen</option>
								<option>Finlandais</option>
								<option>Fran�ais</option>
								<option>Gabonais</option>
								<option>Georgien</option>
								<option>Grec</option>
								<option>Guineen</option>
								<option>Ha�tien</option>
								<option>Hollandais</option>
								<option>Hong-Kong</option>
								<option>Hongrois</option>
								<option>Indien</option>
								<option>Indonesien</option>
								<option>Irakien</option>
								<option>Iranien</option>
								<option>Irlandais</option>
								<option>Islandais</option>
								<option>Israelien</option>
								<option>Italien</option>
								<option>Ivoirien</option>
								<option>Jama�cain</option>
								<option>Japonais</option>
								<option>Kazakh</option>
								<option>Kirghiz</option>
								<option>Kurde</option>
								<option>Letton</option>
								<option>Libanais</option>
								<option>Liechtenstein</option>
								<option>Lituanien</option>
								<option>Luxembourgeois</option>
								<option>Macedonien</option>
								<option>Madagascar</option>
								<option>Malaisien</option>
								<option>Malien</option>
								<option>Maltais</option>
								<option>Marocain</option>
								<option>Mauritanien</option>
								<option>Mauricien</option>
								<option>Mexicain</option>
								<option>Monegasque</option>
								<option>Mongol</option>
								<option>Neo-Zelandais</option>
								<option>Nigerien</option>
								<option>Nord Coreen</option>
								<option>Norvegien</option>
								<option>Pakistanais</option>
								<option>Palestinien</option>
								<option>Peruvien</option>
								<option>Philippins</option>
								<option>Polonais</option>
								<option>Portoricain</option>
								<option>Portugais</option>
								<option>Roumain</option>
								<option>Russe</option>
								<option>Senegalais</option>
								<option>Serbe</option>
								<option>Serbo-croate</option>
								<option>Singapour</option>
								<option>Slovaque</option>
								<option>Sovietique</option>
								<option>Sri-lankais</option>
								<option>Sud-Africain</option>
								<option>Sud-Coreen</option>
								<option>Suedois</option>
								<option>Suisse</option>
								<option>Syrien</option>
								<option>Tadjik</option>
								<option>Ta�wanais</option>
								<option>Tchadien</option>
								<option>Tcheque</option>
								<option>Thailandais</option>
								<option>Tunisien</option>
								<option>Turc</option>
								<option>Ukrainien</option>
								<option>Uruguayen</option>
								<option>Venezuelien</option>
								<option>Vietnamien</option>
						</select></td>
					</tr>

					<tr>
						<td><label>Sexe</label> :</td>
						<td><select name="sexe">
								<option value="F">Une femme</option>
								<option value="M">Un homme</option>
						</select></td>
					</tr>

					<tr>
						<td><label>Adresse</label> :</td>
						<td><input type="text" name="adresse" id="adresse"
							value="<%=clt.getClt_address()%>" /></td>
					</tr>

					<tr>
						<td><label>Code postal</label> :</td>
						<td><input type="number" onkeypress="return isNumberKey(evt)"
							name="codepostal" id="codepostal"
							value="<%=clt.getClt_postalcode()%>" /></td>
					</tr>

					<tr>
						<td><label>Ville</label> :</td>
						<td><input type="text" name="ville" id="ville"
							value="<%=clt.getClt_city()%>" /></td>
					</tr>

					<tr>
						<td><label>Numero de telephone</label> :</td>
						<td><input type="number" onkeypress="return isNumberKey(evt)"
							name="tel" id="tel" value="<%=clt.getClt_telephonenumber()%>" /></td>
					</tr>

					<tr>
						<td><label>E-mail</label> :</td>
						<td><input type="email" name="email" id="email"
							value="<%=clt.getClt_email()%>" /></td>
					</tr>

					<tr>
						<td><label>Statut</label> :</td>
						<td><select name="statut" required>
								<option>Un(e) etudiant(e)</option>
								<option>Un professionnel</option>
								<option>En recherche d'emploi</option>
						</select></td>
					</tr>

				</table>



				<p>
					<input type="submit" value="Enregistrer les modifications" /> <input
						type="button" value="Annuler"
						OnClick="location.href='zoneclient.html'" /> <input type="reset"
						value="Recommencer" />
				</p>

			</form>

		</fieldset>
		<!-- end of #content -->


		<hr>

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Banque en ligne 2017</p>
				</div>
			</div>
		</footer>

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Script to Activate the Carousel -->
	<script>
		$('.carousel').carousel({
			interval : 5000
		//changes the speed
		})
	</script>

</body>

</html>