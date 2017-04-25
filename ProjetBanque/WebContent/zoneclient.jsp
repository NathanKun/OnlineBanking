<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
   import="model.Client, dao.DaoClient, model.Account, dao.DaoAccount, java.util.ArrayList, org.joda.time.format.DateTimeFormat"%>
<%@ include file="./includes/sessionCheck.inc.jsp"%>
<%
   Client clt = (Client)session.getAttribute("client");
%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="">
      <meta name="author" content="">
      <title>BankRading - Mon espace</title>
      <link href="css/accountsInfo.css" rel="stylesheet">
      <link href="css/zoneclient.css" rel="stylesheet">
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
               <h4>Votre login : ${ client.getClt_login() }</h4>
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
                     class="fa fa-database"></i> Mes informations</a></li>
               </ul>
            </div>
         </div>
         <div class="row">
            <div class="col-lg-12">
               <div id="myTabContent" class="tab-content">
                  <div class="tab-pane fade active in" id="generalites">
                     <h3>Mes comptes</h3>
                     <table id="accountsInfo">
                        <tr>
                           <th>Type</th>
                           <th>Numéro</th>
                           <th>intéret</th>
                           <th>Solde (€)</th>
                        </tr>
                        <tr>
                           <td>Compte courant:</td>
                           <td>${ client.getCurrentAccount().getAcc_number() }</td>
                           <td>${ client.getCurrentAccount().getAcc_interest() }</td>
                           <td id="currentBalance"><button class="btn btn-primary" onclick="showBalance('currentBalance');">Show</button></td>
                        </tr>
                        <tr>
                           <%if(clt.getSavingAccount() != null){ %>
                        <tr>
                           <td>Compte d'épargne:</td>
                           <td>${ client.getSavingAccount().getAcc_number() }</td>
                           <td>${ client.getSavingAccount().getAcc_interest() }</td>
                           <td id="savingBalance"><button class="btn btn-primary" onclick="showBalance('savingBalance');">Show</button></td>
                        </tr>
                        <tr>
                           <%} if(clt.getSecuritiesAccount() != null){ %>
                        <tr>
                           <td>Compte de titre:</td>
                           <td>${ client.getSecuritiesAccount().getAcc_number() }</td>
                           <td>${ client.getSecuritiesAccount().getAcc_interest() }</td>
                           <td id="securitiesBalance"><button class="btn btn-primary" onclick="showBalance('securitiesBalance');">Show</button></td>
                        </tr>
                        <% }if(clt.getSavingAccount() == null){ %>
                        <tr>
                           <td>Créer un compte d'épargne</td>
                           <td><button class="btn btn-primary" onclick="createAccount('savingAccount');">Créer</button></td>
                        </tr>
                        <% } if(clt.getSecuritiesAccount() == null){ %>
                        <tr>
                           <td>Créer un compte de titre:</td>
                           <td><button class="btn btn-primary" onclick="createAccount('securitiesAccount');">Créer</button></td>
                        </tr>
                        <% } %>
                     </table>
                  </div>
                  <!-- Généralités comptes -->
                  
                  
                  <div class="tab-pane fade" id="comptes">
                     <h3>Historique des transactions</h3>
                     <p>Compte courant: ${ client.getCurrentAccount().getAcc_number() }</p>
                     <button class="btn btn-primary" onclick="showTsh('currentHistory')">show</button>
                     <button class="btn btn-primary" onclick="location.href='./SaveCsv?type=currentHistory'">CSV</button>
                     <table id="currentHistory">
                     </table>
                     <%if(clt.getSavingAccount() != null){ %>
                     <p>Compte d'épargne: ${ client.getSavingAccount().getAcc_number() }</p>
                     <button class="btn btn-primary" onclick="showTsh('savingHistory')">show</button>
                     <button class="btn btn-primary" onclick="location.href='./SaveCsv?type=savingHistory'">CSV</button>
                     <table id="savingHistory">
                     </table>
                     <%} if(clt.getSecuritiesAccount() != null){ %>
                     <p>Compte de titre: ${ client.getSecuritiesAccount().getAcc_number() }</p>
                     <button class="btn btn-primary" onclick="showTsh('securitiesHistory')">show</button>
                     <button class="btn btn-primary" onclick="location.href='./SaveCsv?type=securitiesHistory'">CSV</button>
                     <table id="securitiesHistory">
                     </table>
                     <%} %>
                  </div>
                  <!-- Transaction history -->
                  
                  
                  <div class="tab-pane fade" id="virement">
                     <h3>Effectuer un virement :</h3>
                     <form class="form-horizontal" id="transferForm" action="./TransferMoney" method="post" onsubmit="return checkInputs()" accept-charset="UTF-8">
                        <div class="form-group">
                           <label class="col-md-4 control-label">Compte à débiter :</label>
                           <div class="col-md-6">
                              <input id="radioCourant1" type="radio" name="emetteur" value="courant"> 
                              <label for="radioCourant1"> Compte courant</label>
                              <% if(clt.getSavingAccount() != null) { %>
                              <input id="radioEpargne1" type="radio" name="emetteur" value="epargne"> 
                              <label for="radioEpargne1"> Compte d'epargne</label>
                              <% } if(clt.getSecuritiesAccount() != null) { %>
                              <input id="radioTitre1" type="radio" name="emetteur" value="titre"> 
                              <label for="radioTitre1"> Compte de titre</label>
                              <% } %>
                           </div>
                        </div>
                        <div class="form-group">
                           <label class="col-md-4 control-label">Compte à Créditer :</label>
                           <div class="col-md-6">
                              <input id="radioCourant2" type="radio" name="beneficiaire" value="courant">
                              <label for="radioCourant2"> Compte courant</label>
                              <% if(clt.getSavingAccount() != null) { %>
                              <input id="radioEpargne2" type="radio" name="beneficiaire" value="epargne">
                              <label for="radioEpargne2"> Compte d'epargne</label>
                              <% } if(clt.getSecuritiesAccount() != null) { %>
                              <input id="radioTitre2" type="radio" name="beneficiaire" value="titre">
                              <label for="radioTitre2"> Compte de titre</label>
                              <% } %>
                            <input id="radioExternal" type="radio" name="beneficiaire" value="external">
                              <label for="radioExternal">Virement externe</label>
                           </div>
                        </div>
                        <div class="form-group">
	                        <div id="transferIbanDiv">
	                           <label class="col-md-4 control-label" for="transferIban">IBAN : </label>  
	                           <div class="col-md-6">
	                              <input id="transferIban" name="iban" placeholder="IBAN" class="form-control input-md"
	                                 maxlength="34" type="text" onchange="transferCheck()">
	                           </div>
                           </div>
                        </div>
                        <div class="form-group">
                           <label class="col-md-4 control-label" for="transferAmount">Montant : </label>
                           <div class="col-md-6">
                              <input id="transferAmount" class="form-control input-md" name="montant" type="number" min="0" 
                                 onchange="transferCheck();"/>
                           </div>
                        </div>
                        <div class="form-group">
                           <label class="col-md-4 control-label" for="transferAmount">Motif : </label>
                           <div class="col-md-6">
	                              <input name="motif" placeholder="motif" class="form-control input-md"
	                                  type="text" onchange="transferCheck()">
	                       </div>
                        </div>
                        <div class="form-group">
                           <label class="col-md-6 control-label" id="transferHint"></label>
                        </div>
                        <!-- Button -->
                        <div class="form-group">
                           <label class="col-md-4 control-label" for="send">                                   </label>
                           <div class="col-md-4">
                              <input type="submit" value=" Valider" id="submit" name="send"
									class="btn btn-primary">
                           </div>
                        </div>
                     </form>
                  </div>
                  <!-- virement -->
                  
                  
                 <div class="tab-pane fade" id="creditercompte">
                     <h4>Alimenter mon compte</h4>
                     
                     <form id="form" class="form-horizontal" action="./AddMoneyToMyAccount"
					method="post" onsubmit="return checkInputs()" accept-charset="UTF-8">
                        <div class="form-group">
                           <label class="col-md-4 control-label">Compte à créditer: </label>
                           <div class="col-md-8">
                              <input type="radio"  name="recepteur" value="courant" required>
                              <label for="recepteur">Compte courant</label>
                              <input type="radio"  name="recepteur" value="epargne">
                              <label for="recepteur">Compte épargne</label>
                              <input type="radio" name="recepteur" value="titre"> 
                              <label for="recepteur">Compte titre</label>
                           </div>
                        </div>
                        <div class="form-group">
                           <label class="col-md-4 control-label" for="montant">Montant:</label>
                           <div class="col-md-4">
                              <input type="text" class="form-control" name="montant" required 
                                 onkeypress='return event.charCode >= 48 && event.charCode <= 57'>
                           </div>
                        </div>
                        <div class="form-group">
                           <div class="col-md-8">
                              <h4>Saisir votre carte de paiement :</h4>
                           </div>
                        </div>
                        <!-- Select Basic -->
                        <div class="form-group">
                           <label class="col-md-4 control-label" for="selectbasic">Selectionnez votre carte</label>
                           <div class="col-md-4">
                              <select id="alimenterCardType" name="type" class="form-control" required>
                                 <option value="Visa">Visa</option>
                                 <option value="MasterCard">MasterCard</option>
                                 <option value="MasterPass">MasterPass</option>
                              </select>
                           </div>
                        </div>
                        <!-- Text input-->
                        <div class="form-group">
                           <label class="col-md-4 control-label" for="titulaire">Titulaire de la carte :</label>  
                           <div class="col-md-4">
                              <input  name="titulaire" placeholder="Nom" class="form-control input-md" required type="text">
                           </div>
                        </div>
                        <!-- Text input-->
                        <div class="form-group">
                           <label class="col-md-4 control-label" for="numcarte">N° de carte : </label>  
                           <div class="col-md-4">
                              <input name="numcarte" placeholder="" class="form-control input-md"
                                 onkeypress='return event.charCode >= 48 && event.charCode <= 57' maxlength="16" required type="text"
                                 title="16 chiffres" pattern=".{16,16}">
                           </div>
                        </div>
                        <!-- Text input-->
                        <div class="form-group">
                           <label class="col-md-4 control-label" for="nom">Date d'expiration: </label>  
                           <div class="col-md-2">
                              <input id="creditMonth" name="mois" class="form-control input-md" 
                                 placeholder="MM" onkeypress='return event.charCode >= 48 && event.charCode <= 57' maxlength="2" 
                                 required min="1" max="12" type="number">
                           </div>
                           <div class="col-md-2">
                              <input id="alimenterYear" name="annee" class="form-control input-md" 
                                 placeholder="YYYY" onkeypress='return event.charCode >= 48 && event.charCode <= 57' maxlength="4" required min="2017" max="2099" type="number">
                           </div>
                        </div>
                        <!-- Text input-->
                        <div class="form-group">
                           <label class="col-md-4 control-label" for="crypto">Cryptogramme visuel :</label>  
                           <div class="col-md-4">
                              <input name="crypto" placeholder="" class="form-control input-md" required type="text"
                                 onkeypress='return event.charCode >= 48 && event.charCode <= 57' maxlength="3" 
                                 title="3 chiffres" pattern=".{3,3}">
                              <span class="help-block">Veuillez saisir votre cryptogramme visuel,les trois derniers chiffres apparaissant sur le panneau signature au verso de votre carte bancaire </span>  
                           </div>
                        </div>
                        <!-- Button -->
                        <div class="form-group">
                           <label class="col-md-4 control-label" for="send">                                   </label>
                           <div class="col-md-4">
                              <input type="submit" value=" Valider" id="submit" name="send"
									class="btn btn-primary">
                           </div>
                        </div>
                     </form>
                  </div>
                  <!-- creditercompte -->
                  
                  
                  <div class="tab-pane fade" id="infosperso">
                     <div class="row">
	                     <div class="col-md-2">
	                     </div>
	                     <div class="col-md-8">
	                     	<h4>Mes informations personelles</h4>
	                     </div>
	                 </div>
                     <div class="row">
	                     <div class="col-md-2">
	                     </div>
	                     <div class="col-md-8">
	                        <%
	                           ArrayList<Account> accList = DaoAccount.findAccountByClientId(clt.getClt_id());
	                           request.setAttribute("accList", accList);
	                        %>
	                        <table>
	                           <tr>
	                              <td><label>Identifiant : </label></td>
	                              <td><%=clt.getClt_login()%> </td>
	                           </tr>
	                           <tr>
	                              <td><label>Nom : </label></td>
	                              <td>
	                                 <c:out value="${client.getClt_lname()}" />
	                              </td>
	                           </tr>
	                           <tr>
	                              <td><label>Prénom</label></td>
	                              <td>
	                                 <c:out value="${client.getClt_fname()}" />
	                              </td>
	                           </tr>
	                           <tr>
	                              <td><label>Date de naissance : </label></td>
	                              <td>
	                                 <c:out value='<%=clt.getClt_birthday().toString(DateTimeFormat.forPattern("yyyy/MM/dd")) %>' />
	                              </td>
	                           </tr>
	                           <tr>
	                              <td><label>Nationalité : </label></td>
	                              <td>
	                                 <c:out value="${client.getClt_nationality()}" />
	                              </td>
	                           </tr>
	                           <tr>
	                              <td><label>Sexe : </label></td>
	                              <td>
	                                 <c:out value="${client.getClt_gender()}" />
	                              </td>
	                           </tr>
	                           <tr>
	                              <td><label>Adresse : </label></td>
	                              <td>
	                                 <c:out value="${client.getClt_address()}" />
	                              </td>
	                           </tr>
	                           <tr>
	                              <td><label>Code postal : </label></td>
	                              <td>
	                                 <c:out value="${client.getClt_postalcode()}" />
	                              </td>
	                           </tr>
	                           <tr>
	                              <td><label>Ville : </label></td>
	                              <td>
	                                 <c:out value="${client.getClt_city()}" />
	                              </td>
	                           </tr>
	                           <tr>
	                              <td><label>Numéro de téléphone : </label></td>
	                              <td>
	                                 <c:out value="${client.getClt_telephonenumber()}" />
	                              </td>
	                           </tr>
	                           <tr>
	                              <td><label>E-mail : </label></td>
	                              <td>
	                                 <c:out value="${client.getClt_email()}" />
	                              <td>
	                           </tr>
	                           <tr>
	                              <td><label>Statut : </label></td>
	                              <td>
	                                 <c:out value="${client.getClt_status()}" />
	                              </td>
	                           </tr>
	                        </table>
	                        <br>
	                        <p>
	                           <input class="btn btn-primary" type="button" value="Modifier les informations" OnClick="location.href='modifier-infos-client.jsp'"/>          
	                        </p>
	                     </div>
	                 </div>
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
      <script src="js/iban.js"></script>
      <script>
         window.onload = function() {
         	document.getElementById("customerarea").className = "dropdown active";
         	if((new Date).getMonth() <= 10){
         		document.getElementById("creditMonth").min = (new Date).getMonth() + 1;
         	} else {
         		document.getElementById("creditMonth").min = 12;
         	}
         	
         };
         
         // show balance
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
         
         // create account and refresh page
         function createAccount(type) {
         	switch(type){
         	case "savingAccount":
         		if(confirm("Vous voulez créer un compte d'épargne ?")){
         			$.get("./CreateAccount", { type: 'SavingAccount' }, function(responseText){
         				if(responseText == "Done"){
         					window.location.reload();
         				} else {
         					alert("Error");
         				}
         			});
         		}
         		break;
         	case "securitiesAccount":
         		if(confirm("Vous voulez créer un compte de titre ?")){
         			$.get("./CreateAccount", { type: 'SecuritiesAccount' }, function(responseText){
         				if(responseText == "Done"){
         					window.location.reload();
         				} else {
         					alert("Error");
         				}
         			});
         		}
         		break;
         	}
         }
         
         // Ajax show transaction history
         function showTsh(type) {
         	switch(type){
         	case "currentHistory":
         		$.get("./GetTransactionHistories", { type: 'currentHistory' }, function(responseText) {
                           document.getElementById("currentHistory").innerHTML = 
                           	"<tr><th>Date</th><th>Description</th><th>Montant(€)</th></tr>" 
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
         
         // Transfer money's inputs control
         function transferCheck() {
             var emetteur=$('[name="emetteur"]:checked').val();
             var beneficiaire=$('[name="beneficiaire"]:checked').val();
             
             
         
             if(emetteur == "courant"){
             	$("#radioCourant2").prop('disabled', true);
             } else {
             	$("#radioCourant2").prop('disabled', false);
             }
             if(emetteur == "epargne"){
             	$("#radioEpargne2").prop('disabled', true);
             } else {
             	$("#radioEpargne2").prop('disabled', false);
             }
             if(emetteur == "titre"){
             	$("#radioTitre2").prop('disabled', true);
             } else {
             	$("#radioTitre2").prop('disabled', false);
             }
             
             if(emetteur != "courant" && emetteur != "epargne" && emetteur != "titre" && 
             		beneficiaire != "courant" && beneficiaire != "epargne" && beneficiaire != "titre") {
             	$("#transferSubmit").prop('disabled', true); // initial stat
            } else if(emetteur != "courant" && emetteur != "epargne" && emetteur != "titre") {
             	$("#transferSubmit").prop('disabled', true);
             	$("#transferHint").text("Veuillez choisir un compte a debiter.");
            } else if(beneficiaire != "courant" && beneficiaire != "epargne" && beneficiaire != "titre" && beneficiaire != "external") {
             	$("#transferSubmit").prop('disabled', true);
             	$("#transferHint").text("Veuillez choisir un bénéficiaire.");
            } else if(beneficiaire == "external" && !(IBAN.isValid($("#transferIban").val())) ) {
             	$("#transferSubmit").prop('disabled', true);
             	$("#transferHint").text("IBAN incorrect");
            } else if(emetteur == beneficiaire){
             	$("#transferSubmit").prop('disabled', true);
             	$("#transferHint").text("Le compte a debiter et le beneficiaire est le même.");
            } else if(!$("#transferAmount").val()){
             	$("#transferSubmit").prop('disabled', true);
             	$("#transferHint").text("Veuillez entrer une somme de virement.");
			} else {
         	    $("#transferSubmit").prop('disabled', false);
         	    $("#transferHint").text("");
            }
             
             if(beneficiaire == "external"){
            	 $('#transferIbanDiv').show();
             } else {
            	 $('#transferIbanDiv').hide();
             }
        }
         
         
         // transfer radio button on change event
         $(document).on("change", "input[type=radio]", transferCheck);
         
         
         // Ajax transfer money and get result
         $(document).on("submit", "#transferForm", function() {
                   var $form = $(this);
                   $.post($form.attr("action"), $form.serialize(), function(responseText) {
                   	//alert(responseText);
                   	if(responseText == "No enough money")
                       	$("#hint").text("L'argent insuffisant dans le compte a debiter");
                   	else{
                   		alert("Virement effectue.");
                   		window.location.reload();
                   	}
                   });
                   event.preventDefault(); // Important! Prevents submitting the form.
               });
      </script>
   </body>
</html>