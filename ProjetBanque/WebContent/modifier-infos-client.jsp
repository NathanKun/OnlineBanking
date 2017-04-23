<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import="model.Client, dao.DaoClient, model.Account, dao.DaoAccount, java.util.ArrayList"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="./includes/sessionCheck.inc.jsp"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
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
	<link rel="stylesheet" href="./css/subscribe.css" type="text/css">


</head>

<body>

	<%
		Client clt = (Client) session.getAttribute("client");
	%>

	<%@ include file="./includes/nav.inc.jsp"%>

	<!-- Page Content -->
	<div class="container">


		<div class="row">
			<div class="col-md-8">
				<form id="form" class="form-horizontal" action="./ModifyInfo"
					method="post" onsubmit="return checkInputs()" accept-charset="UTF-8">
					<fieldset>

						<!-- Form Name -->
						<legend>Modifier vos informations :</legend>


						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="selectbasic">Identifiant</label>
							<div class="col-md-4">
								<input id="login" name="login" value="<%=clt.getClt_login()%>"
									placeholder="Login" class="form-control input-md" required
									type="text" disabled>
							</div>
						</div>

						<!-- Select Basic -->
						<div class="form-group">
							<label class="col-md-4 control-label" for="selectbasic">Titre</label>
							<div class="col-md-4">
								<select id="selectbasic" name="sexe" class="form-control">
									<c:if test="${client.getClt_gender() == 'F' }">
										<option value="F" selected>Madame</option>
										<option value="M">Monsieur</option>
									</c:if>
									<c:if test="${client.getClt_gender() == 'M' }">
										<option value="F">Madame</option>
										<option value="M" selected>Monsieur</option>
									</c:if>
								</select>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="Nom22">Nom</label>
							<div class="col-md-4">
								<input id="nom" name="nom" placeholder="Nom"
									class="form-control input-md" required type="text"
									value="${fn:escapeXml(client.getClt_lname())}">

							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="Prénom">Prénom</label>
							<div class="col-md-4">
								<input id="prenom" name="prenom" placeholder="Prénom"
									class="form-control input-md" required type="text"
									value="${fn:escapeXml(client.getClt_fname())}">

							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="Ddn">Date de
								Naissance</label>
							<div class="col-md-4">
								<input type="number" name="jour" min="1" max="31"
									style="width: 3em;"
									value="<%=clt.getClt_birthday().getDayOfMonth()%>" required>
								<input type="number" name="mois" min="1" max="12"
									style="width: 3em;"
									value="<%=clt.getClt_birthday().getMonthOfYear()%>" required>
								<input type="number" name="annee" min="1900" max="2000"
									style="width: 6em;"
									value="<%=clt.getClt_birthday().getYear()%>" required>
							</div>
						</div>

						<!-- Select Basic -->
						<div class="form-group">
							<label class="col-md-4 control-label" for="EtatC">Etat
								Civil</label>
							<div class="col-md-4">
								<select id="EtatC" name="statut" class="form-control">
									<c:if test="${client.getClt_status() == 'Marié(e)' }">
										<option value="Marié(e)" selected>Marié(e)</option>
										<option value="Divorcé(e)">Divorcé(e)</option>
										<option value="Séparé(e)">Séparé(e)</option>
										<option value="Célibataire">Célibataire</option>
										<option value="Veuf(ve)">Veuf(ve)</option>
									</c:if>
									<c:if test="${client.getClt_status() == 'Divorcé(e)' }">
										<option value="Marié(e)">Marié(e)</option>
										<option value="Divorcé(e)" selected>Divorcé(e)</option>
										<option value="Séparé(e)">Séparé(e)</option>
										<option value="Célibataire">Célibataire</option>
										<option value="Veuf(ve)">Veuf(ve)</option>
									</c:if>
									<c:if test="${client.getClt_status() == 'Séparé(e)' }">
										<option value="Marié(e)">Marié(e)</option>
										<option value="Divorcé(e)">Divorcé(e)</option>
										<option value="Séparé(e)" selected>Séparé(e)</option>
										<option value="Célibataire">Célibataire</option>
										<option value="Veuf(ve)">Veuf(ve)</option>
									</c:if>
									<c:if test="${client.getClt_status() == 'Célibataire' }">
										<option value="Marié(e)">Marié(e)</option>
										<option value="Divorcé(e)">Divorcé(e)</option>
										<option value="Séparé(e)">Séparé(e)</option>
										<option value="Célibataire" selected>Célibataire</option>
										<option value="Veuf(ve)">Veuf(ve)</option>
									</c:if>
									<c:if test="${client.getClt_status() == 'Veuf(ve)' }">
										<option value="Marié(e)">Marié(e)</option>
										<option value="Divorcé(e)">Divorcé(e)</option>
										<option value="Séparé(e)">Séparé(e)</option>
										<option value="Célibataire">Célibataire</option>
										<option value="Veuf(ve)" selected>Veuf(ve)</option>
									</c:if>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label" for="nationalite">Nationalité</label>
							<div class="col-md-4">
								<select id="nationalite" name="nationalite"
									class="form-control input-md" required>
									<option>${fn:escapeXml(client.getClt_nationality())}</option>
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
									<option>Français</option>
									<option>Gabonais</option>
									<option>Georgien</option>
									<option>Grec</option>
									<option>Guineen</option>
									<option>Haïtien</option>
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
									<option>Jamaïcain</option>
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
									<option>Taïwanais</option>
									<option>Tchadien</option>
									<option>Tcheque</option>
									<option>Thailandais</option>
									<option>Tunisien</option>
									<option>Turc</option>
									<option>Ukrainien</option>
									<option>Uruguayen</option>
									<option>Venezuelien</option>
									<option>Vietnamien</option>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label" for="address-input">Votre
								Adresse</label>
							<div class="col-md-4">
								<input id="address-input" placeholder="Votre Adresse"
									class="form-control input-md"
									value="${fn:escapeXml(client.getClt_address())}, ${fn:escapeXml(client.getClt_postalcode())}, ${fn:escapeXml(client.getClt_city())}"
									required type="text">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="rue">Rue</label>
							<div class="col-md-4">
								<input id="adresse" name="adresse" readonly
									placeholder="Adresse" class="form-control input-md"
									value="${fn:escapeXml(client.getClt_address())}" required
									type="text">

							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="CP">Code
								Postal</label>
							<div class="col-md-2">
								<input id="codepostal" name="codepostal" readonly
									placeholder="Code Postal"
									value="${fn:escapeXml(client.getClt_postalcode())}"
									class="form-control input-md" required type="text">

							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="ville">Ville</label>
							<div class="col-md-4">
								<input id="ville" name="ville" readonly placeholder="ville"
									class="form-control input-md"
									value="${fn:escapeXml(client.getClt_city())}" type="text">

							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="mail">Adresse
								e-mail</label>
							<div class="col-md-4">
								<input id="email" name="email" placeholder="Adresse e-mail"
									class="form-control input-md" value="<%=clt.getClt_email()%>"
									required type="text">

							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="tel">Téléphone</label>
							<div class="col-md-4">
								<input id="tel" name="tel" placeholder="Ex:0123456789 "
									class="form-control input-md"
									value="${fn:escapeXml(client.getClt_telephonenumber())}"
									required type="text">

							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="revMensNet">Choisissez
								votre mot de passe </label>
							<div class="col-md-4">
								<input id="password" name="password" onchange="checkPw()"
									placeholder="password" class="form-control input-md"
									type="password">

							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="cpassword">Confirmez
								mot de passe</label>
							<div class="col-md-4">
								<input id="password2" name="password2" onchange="checkPw()"
									placeholder="Confirmation depassword"
									class="form-control input-md" type="password">

							</div>
						</div>



						<div class="form-group">
							<label class="col-md-4 control-label" for="send"></label>
							<div class="col-md-4">
								<label id="hint"></label> <br />
							</div>
						</div>

						<!-- Button -->
						<div class="form-group">
							<label class="col-md-4 control-label" for="send"></label>
							<div class="col-md-4">
								<input type="submit" value=" Modifier" id="submit" name="send"
									class="btn btn-primary">
							</div>
						</div>

					</fieldset>
				</form>

<<<<<<< HEAD
		<fieldset>
			<legend> Modifier vos informations : </legend>
			<!-- Titre du fieldset -->





			<form id="form" class="form-horizontal" action="./ModifyInfo"
				method="post" onsubmit="return checkInputs()">
				<table>

					<tr>

						<td><label>Identifiant </label> :</td>
						<td><%=clt.getClt_login()%></td>

					</tr>


					<tr>
						<td><label>Mot de passe </label> :</td>
						<td><input type="password" name="password" id="password" onchange="checkPw()" /></td>
					</tr>

					<tr>
						<td><label>Confirmer le mot de passe </label> :</td>
						<td><input type="password" name="password2"
							id="password2" onchange="checkPw()" /></td>
					</tr>

					<tr>
						<td><label>Nom</label> :</td>
						<td><input type="text" name="nom" id="nom"
							value="${fn:escapeXml(client.getClt_lname())}" /></td>
					</tr>

					<tr>
						<td><label>Prenom</label> :</td>
						<td><input type="text" name="prenom" id="prenom"
							value="${fn:escapeXml(client.getClt_fname())}" /></td>
					</tr>

					<tr>
						<td><label>Date de naissance</label> :</td>
						<td><input type="number" name="jour" min="1" max="31" style="width: 3em;" value="<%=clt.getClt_birthday().getDayOfMonth() %>" required />
							<input type="number" name="mois" min="1" max="12" style="width: 3em;" value="<%=clt.getClt_birthday().getMonthOfYear() %>" required />
							<input type="number" name="annee" min="1900" max="2000" style="width: 6em;" value="<%=clt.getClt_birthday().getYear() %>" required />
						</td>
					</tr>

					<tr>
						<td><label>Nationalite</label> :</td>
						<td><select id="nationalite" name="nationalite" required>
								<option> <%=clt.getClt_nationality()%>  </option>
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
							value="${fn:escapeXml(client.getClt_address())}" /></td>
					</tr>

					<tr>
						<td><label>Code postal</label> :</td>
						<td><input type="txex" name="codepostal" id="codepostal"
							value="<%=clt.getClt_postalcode()%>" onchange="getCity()"/></td>
					</tr>

					<tr>
						<td><label>Ville</label> :</td>
						<td><input type="text" name="ville" id="ville"
							value="${fn:escapeXml(client.getClt_city())}" /></td>
					</tr>

					<tr>
						<td><label>Numero de telephone</label> :</td>
						<td><input type="number" onkeypress="return isNumberKey(evt)"
							name="tel" id="tel" value="<%=clt.getClt_telephonenumber()%>" /></td>
					</tr>

					<tr>
						<td><label>E-mail</label> :</td>
						<td><input type="email" name="email" id="email"
							value="${fn:escapeXml(client.getClt_email())}" /></td>
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
					<input type="submit" id="submit" value="Enregistrer les modifications" /> 
					<input type="button" value="Annuler"
						OnClick="location.href='zoneclient.jsp'" /> <input type="reset"
						value="Recommencer" />
				</p>
				<label id="hint"></label>
			</form>

		</fieldset>
		<!-- end of #content -->
=======


			</div>

		</div>
>>>>>>> a169af14191bc239927da566be204b670a5fcb1d


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


	<!-- algolia/places api -->
	<script src="https://cdn.jsdelivr.net/places.js/1/places.min.js"></script>
	
	<!-- XSS checker -->
    <script src="https://rawgit.com/leizongmin/js-xss/master/dist/xss.js"></script>

	<script src="./js/subscribe.js"></script>

</body>

</html>