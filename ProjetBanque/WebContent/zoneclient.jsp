<<<<<<< HEAD

$('.nav-tabs-dropdown').each(function(i, elm) {

    
    $(elm).text($(elm).next('ul').find('li.active a').text());
    
});
  
$('.nav-tabs-dropdown').on('click', function(e) {

    e.preventDefault();
    
    $(e.target).toggleClass('open').next('ul').slideToggle();
    
});

$('#nav-tabs-wrapper a[data-toggle="tab"]').on('click', function(e) {

    e.preventDefault();
    
    $(e.target).closest('ul').hide().prev('a').removeClass('open').text($(this).text());
      
});
=======
<%@ page
	import="model.Client, dao.DaoClient, model.Account, dao.DaoAccount, java.util.ArrayList"%>
<%@ include file="./includes/sessionCheck.inc.jsp"%>
<%
	Client clt = (Client)session.getAttribute("client");
%>
<!DOCTYPE html>
<html lang="en">

<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>Modern Business - Start Bootstrap Template</title>
	
	<link href="css/accountsInfo.css" rel="stylesheet">
	
	<!-- Bootstrap Core CSS -->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Custom CSS -->
	<link href="css/modern-business.css" rel="stylesheet">
	
	<!-- Custom Fonts -->
	<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
		type="text/css">
</head>

<body>

	<%@ include file="./includes/nav.inc.jsp"%>

	<!-- Page Content -->
	<div class="container">


		<!-- Service Tabs -->
		<div class="row">
			<div class="col-lg-12">
				<h2 class="page-header">${ client.getClt_lname() }, Bienvenue dans votre espace client</h2>
			</div>
		</div>
		
		<div class="row">
			<div class="col-lg-12">

				<ul id="myTab" class="nav nav-tabs nav-justified">
					<li class="active"><a href="#generalites" data-toggle="tab"><i
							class="fa fa-tree"></i> Généralités du compte</a></li>
					<li class=""><a href="#comptes" data-toggle="tab"><i
							class="fa fa-car"></i> Historique des transactions</a></li>
					<li class=""><a href="#virement" data-toggle="tab"><i
							class="fa fa-car"></i> Transferts et virement</a></li>
					<li class=""><a href="#creditercompte" data-toggle="tab"><i
							class="fa fa-support"></i> Créditer mon compte</a></li>
					<li class=""><a href="#infosperso" data-toggle="tab"><i
							class="fa fa-database"></i> Mes informations personnelles</a></li>
				</ul>
			</div>
		</div>
		
		<div class="row">
			<div class="col-lg-12">
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade active in" id="generalites">
						<h3>Mes comptes</h3>
						<table id="accountsInfo">
							<tr><th>Type</th><th>Numéro</th><th>intêret</th><th>Solde</th></tr>
							<tr>
								<td>Compte courant:</td>
								<td>${ client.getCurrentAccount().getAcc_number() }</td>
								<td>${ client.getCurrentAccount().getAcc_interest() }</td>
								<td id="currentBalance"><button onclick="showBalance('currentBalance');">Show</button></td>
							</tr><tr>
							<%if(clt.getSavingAccount() != null){ %>
							<tr>
								<td>Compte d'épargne:</td>
								<td>${ client.getSavingAccount().getAcc_number() }</td>
								<td>${ client.getSavingAccount().getAcc_interest() }</td>
								<td id="savingBalance"><button onclick="showBalance('savingBalance');">Show</button></td>
							</tr><tr>
							<%} if(clt.getSecuritiesAccount() != null){ %>
							<tr>
								<td>Compte de titre:</td>
								<td>${ client.getSecuritiesAccount().getAcc_number() }</td>
								<td>${ client.getSecuritiesAccount().getAcc_interest() }</td>
								<td id="securitiesBalance"><button onclick="showBalance('securitiesBalance');">Show</button></td>
							</tr>
							<%} %>
						</table>
					</div>
					<!-- Généralités comptes -->

					<div class="tab-pane fade" id="comptes">
							<h3>Historique des transactions</h3>
							<p>Compte courant: ${ client.getCurrentAccount().getAcc_number() }</p>
							<button onclick="showTsh('currentHistory')";>show</button>
							<table id="currentHistory">
							</table>
						<%if(clt.getSavingAccount() != null){ %>
							<p>Compte d'épargne: ${ client.getSavingAccount().getAcc_number() }</p>
							<button onclick="showTsh('savingHistory')";>show</button>
							<table id="savingHistory">
							</table>
						<%} if(clt.getSecuritiesAccount() != null){ %>
							<p>Compte de titre: ${ client.getSecuritiesAccount().getAcc_number() }</p>
							<button onclick="showTsh('securitiesHistory')";>show</button>
							<table id="securitiesHistory">
							</table>
						<%} %>
					</div>
					<!-- Transaction history -->


					<div class="tab-pane fade" id="virement">
						<h3>Effectuer un virement :</h3>
						<div class="form-group">
							<p>
								<label class="col-md-4 control-label" for="compte">Compte
									émetteur: </label> <label for="courant"> <input type="checkbox"
									id="courant" value="courant"> Compte courant
								</label> <label for="epargne"> <input type="checkbox"
									id="epargne" value="epargne"> Compte épargne
								</label> <input type="checkbox" id="titre" value="checkbox1"> <label
									for="titre"> Compte titre. </label>
							</p>

						</div>

						<div class="form-group">
							<p>
								<label class="col-md-4 control-label" for="compte">Compte
									bénéficiaire: </label> <label for="courant"> <input
									type="checkbox" id="courant" value="courant"> Compte
									courant
								</label> <label for="epargne"> <input type="checkbox"
									id="epargne" value="epargne"> Compte épargne
								</label> <input type="checkbox" id="titre" value="checkbox1"> <label
									for="titre"> Compte titre. </label>
							</p>

						</div>
					</div>
					<!-- virement -->


					<div class="tab-pane fade" id="creditercompte">
						<h3>Alimenter mon compte</h3>

					</div>
					<!-- creditercompte -->


					<div class="tab-pane fade" id="infosperso">

						<fieldset>
							<legend> Afficher vos informations : </legend>

							<form method="post" action=".php">
								<table>

									<tr>

										<td><label for="identifiant">Identifiant </label> :</td>
										<td></td>

									</tr>

									<tr>
										<td><label for="nom">Nom</label> :</td>
										<td></td>
									</tr>

									<tr>
										<td><label for="prenom">Prénom</label> :</td>
										<td></td>
									</tr>

									<tr>
										<td><label for="date">Date de naissance</label> :</td>
										<td></td>
									</tr>

									<tr>
										<td><label for="nationalite">Nationalité</label> :</td>
										<td></td>
									</tr>

									<tr>
										<td><label for="sexe">Sexe</label> :</td>
										<td></td>
									</tr>

									<tr>
										<td><label for="adresse">Adresse</label> :</td>
										<td></td>
									</tr>

									<tr>
										<td><label for="codepostal">Code postal</label> :</td>
										<td></td>
									</tr>

									<tr>
										<td><label for="ville">Ville</label> :</td>
										<td></td>
									</tr>

									<tr>
										<td><label for="tel">Numéro de téléphone</label> :</td>
										<td></td>
									</tr>

									<tr>
										<td><label for="mail">E-mail</label> :</td>
										<td>
										<td>
									</tr>

									<tr>
										<td><label>Statut</label> :</td>
										<td></td>
									</tr>

								</table>



								<p>
									<input type="button" value="Modifier les informations"
										OnClick="location.href='modifier-info-client.jsp'" />
								</p>
							</form>

						</fieldset>


					</div>
					<!-- info perso -->
				</div>
				<!-- myTabContent -->
			</div>
			<!-- col-lg-12 -->
		</div>
		<!-- row -->
		
		<!-- Footer -->
		<%@ include file="./includes/footer.inc.jsp"%>
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

	<script>
		window.onload = function() {
			document.getElementById("customerarea").className = "dropdown active";
		}
		
		// show balance
		// TODO: use Ajax to be more security
		function showBalance(type){
			switch(type){
				case "currentBalance":
					document.getElementById("currentBalance").innerHTML = <%= clt.getCurrentAccount().getAcc_balance() %>;
					break;
				<% if(clt.getSavingAccount() != null){ %>
				case "savingBalance":
					document.getElementById("savingBalance").innerHTML = <%= clt.getSavingAccount().getAcc_balance() %>;
					break;
				<%} if(clt.getSecuritiesAccount() != null){ %>
				case "securitiesBalance":
					document.getElementById("securitiesBalance").innerHTML = <%= clt.getSecuritiesAccount().getAcc_balance() %>;
					break;
				<% } %>
			}
		}
		
		// Ajax show transaction history
		
		
		
		function showTsh(type) {
			switch(type){
			case "currentHistory":
				$.get("./GetTransactionHistories", { type: 'currentHistory' }, function(responseText) {
                    document.getElementById("currentHistory").innerHTML = 
                    	"<tr><th>Date</th><th>Description</th><th>Montant</th></tr>" 
                    	+ responseText;
                });
				break;
			case "savingHistory":
				$.get("./GetTransactionHistories", { type: 'savingHistory' }, function(responseText) {
                    document.getElementById("savingHistory").innerHTML = 
                    	"<tr><th>Date</th><th>Description</th><th>Montant</th></tr>" 
                    	+ responseText;
                });
				break;
			case "securitiesHistory":
				$.get("./GetTransactionHistories", { type: 'securitiesHistory' }, function(responseText) {
                    document.getElementById("securitiesHistory").innerHTML = 
                    	"<tr><th>Date</th><th>Description</th><th>Montant</th></tr>" 
                    	+ responseText;
                });
				break;
			}
		}
	</script>
</body>

</html>
>>>>>>> 7d27c1c4db7b1fbc0ae7a8304db6d49e0a2f681a
