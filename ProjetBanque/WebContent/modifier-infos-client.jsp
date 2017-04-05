<%@ page import="model.Client, dao.DaoClient, model.Account, dao.DaoAccount, java.util.ArrayList"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>Modifier vos informations</title>
	<link rel="stylesheet" href="offres.css" type="text/css" media="screen" />
	

</head>
<body>
<div id="wrapper"><!-- #wrapper -->
<%
								Client clt = (Client) session.getAttribute("client");
								ArrayList<Account> accList = DaoAccount.findAccountByClientId(clt.getClt_id());
								request.setAttribute("accList", accList);
							%>
	<header><!-- header -->
	<h1><img src="bank.png" alt="image"><a href="#">BankRading </a></h1><!-- header image -->
		
		
	</header><!-- end of header -->
	<nav><!-- top nav -->
		<div class="menu">
			<ul>
				<li><a href="#">Acceuil</a></li>
  			</li>
				<li><a href="#">Services</a>
					
				</li>
				<li><a href="#">About us</a>
					
				</li>
				<li><a href="#">Bourse</a></li>
				<li><a href="contact.html">Nous Contacter</a></li>
				<li><a href="#">Espace Client</a>
			    <ul>
   					<li><a href="Se connecter.html">Se connecter</a></li>
   					<li><a href="Créer un compte.php">Créer un compte</a></li>
   				</ul>
			</ul>
		</div>
	</nav><!-- end of top nav -->
	
	<section id="main"><!-- #main content and sidebar area -->
			<section id="content"><!-- #content -->
			
				     <h1><legend>Modifier vos informations :<legend></h1> <!-- Titre du fieldset --> 
	   
	   
	   
	   
	   
	   
	   
	    <form method="post" action=".php">
     <center>
	 <table>

   <tr>
        
	<td> <label>Identifiant   </label> : </td>
	<td><input type="text" name="clt_login" id ="clt_login"  value= "<%=clt.getClt_login()%>"/> </td>
		 
		 </tr>
		 
		 
	 <tr>
    <td><label>Mot de passe  </label> : </td>
	<td><input type="password" name="clt_password" id ="clt_password" /></td>
	 </tr>
	 
	  <tr>
    <td><label>Confirmer le mot de passe  </label> : </td>
	<td><input type="password" name="clt_password" id ="clt_password" /></td>
	 </tr>
	 
	 <tr>	
    <td><label>Nom</label> : </td>
	<td><input type="text" name="clt_lname" id ="clt_lname" /></td>
	</tr>
	 
	 <tr>	
    <td><label>Prénom</label> : </td>
	<td><input type="text" name="clt_fname" id ="clt_fname" /></td>
	</tr>
	 
	 <tr>
   <td> <label>Date de naissance</label> : </td>
	<td><input type="date" name="clt_birthday" id ="clt_birthday" /></td>
</tr>
	 
	 <tr>	 
    <td><label>Nationalité</label> : </td>
	<td><input type="text" name="clt_nationality" id ="clt_nationality" /></td>
	</tr>
	 
	 <tr>	
   <td> <label>Sexe</label> : </td>
	<td><input type="text" name="clt_gender" id ="clt_gender" /></td>
	</tr>
	
	<tr>	
    <td><label>Adresse</label> : </td>
	<td><input type="text" name="clt_address" id ="clt_address" /></td>
	</tr>
	
	<tr>	
   <td> <label>Code postal</label> : </td>
	<td><input type="number" onkeypress="return isNumberKey(evt)" name="clt_postalcode" id ="clt_postalcode" /></td>
	</tr>
	
	<tr>	
   <td> <label>Ville</label> : </td>
	<td><input type="text" name="clt_city" id ="clt_city" /></td>
	</tr>
	
	<tr>	
    <td><label>Numéro de téléphone</label> : </td>
	<td><input type="number" onkeypress="return isNumberKey(evt)" name="clt_telephonenumber" id ="clt_telephonenumber" /></td>
	</tr>
	
	<tr>
   <td> <label>E-mail</label> : </td>
	<td><input type="email" name="clt_email" id ="clt_email" /></td>
	 </tr>
	
	<tr>	
   <td> <label>Statut</label> : </td>
	<td><input type="text" name="clt_status" id ="clt_status" /></td>
	</tr>
	
	</table>
	
	
	
    <p>
	<input type="submit" value="Enregistrer les modifications" />       	<input type="button" value="Annuler" OnClick="location.href='afficher-infos-client.jsp'"/>           <input type="reset" value="Recommencer" />
	</p>
	
 </form>
 
   </fieldset>
	
	
	</center>
			
			
			</section><!-- end of #content -->

		<aside id="sidebar"><!-- sidebar -->
		
		  <form method="post" action="traitement.php">
                     <p>
                     <label for="pseudo"> Login : </label> 
                     <input type="text" name="pseudo" id="pseudo" placeholder="Ex : Amghar" size="20" maxlength="10" />

                     </br> </br>
                     <label for="pass">Password :</label>
                     <input type="password" name="pass" id="pass" />

                     </p>
                      </form>
					  <a href="" class="button">Connexion</a>
					 <a href="" class="button">S'inscrire </a></br></br>
<a href="Password.html">Forgot your Password?</a> </br>
                    
			</div>
			 

		
	
</div><!-- #wrapper -->

</body>
</html>
