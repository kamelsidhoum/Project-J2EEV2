<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%!
	String titre = "Connexion pro";
	boolean afficherHeader = true;
	boolean afficherFooter = true;
	String fichierCSS = ""; //Mettre le CHEMIN du fichier + NOM du fichier + EXTENSION (.css)
	String fichierJS = "js/connexion.js"; //Mettre le CHEMIN du fichier + NOM du fichier + EXTENSION (.js)

	String type = "client"; //(request.getParameter("type").equals("pro") ? "pro" : "client");
%>

<%@ include file="include/header.jsp" %>

		<main>

			<h1 style="color: #fff;">Connexion <%= type.equals("pro") ? "restaurateur" : "client" %></h1>

			<style>
			body {
				background: url(https://eurekarestaurantgroup.com/wp-content/uploads/2018/08/OriginalBurger_2875.jpg) center center; background-size: cover;
			}

			.field {
				display: flex;
				flex-flow: column-reverse;
				margin-bottom: 1em;
			}

			label, input {
				transition: all 0.2s;
				touch-action: manipulation;
			}

			input {
				font-size: 17px;
				border: 0;
				font-family: inherit;
				-webkit-appearance: none;
				border-radius: 0;
				padding: 5px 10px;
				cursor: text;
			}

			input:focus {

			}

			label {

			}

			input:placeholder-shown + label {
				cursor: text;
				max-width: 66.66%;
				white-space: nowrap;
				overflow: hidden;
				text-overflow: ellipsis;
				transform-origin: left bottom;
				transform: translate(0, 30px) scale(1.5);
				color: #888;
				padding: 5px 10px;
				font-size: 15px;
			}

			::-webkit-input-placeholder {
				opacity: 0;
				transition: inherit;
			}

			input:focus::-webkit-input-placeholder {
				opacity: 1;
			}

			input:not(:placeholder-shown) + label,
			input:focus + label {
				transform: translate(0, 0) scale(1);
				cursor: default;
				color: #00bfa5;
				text-transform: uppercase;
			}

			button {
				display: block;
				background-color: #1de9b6;
				border: 0;
				width: 100%;
				color: #fff;
				padding: 15px 10px;
				margin: 20px 0 0;
				font-family: Comfortaa;
				font-size: 16px;
				text-transform: uppercase;
				letter-spacing: 1px;
				cursor: pointer;
			}

			button:hover {
				background-color: #00bfa5;
			}
			</style>

			<form method="post" action="/ConnexionVerificationServlet" style="background-color: #fff; max-width: 400px; padding: 0; margin: 0 auto; border: 2px solid #fff; border-radius: 5px 30px 10px 15px; overflow: hidden;">
				<input type="hidden" name="type" value="<%= type %>">
				<input type="hidden" name="email" value="" id="email-hidden">
  			<div id="email-field" class="field">
    			<input type="text" name="email" id="email" placeholder="Adresse email">
    			<label for="email">Votre email</label>
  			</div>

				<div id="mdp-field" class="field" style="display: none;">
    			<input type="password" name="mdp" id="mdp" placeholder="Mot de passe">
    			<label for="mdp">Mot de passe pour <span ></span></label>
  			</div>

			  <button id="validate-btn" type="suivant">
					Suivant &gt;
				</button>
			</form>

		</main>

<%@ include file="include/footer.jsp" %>
