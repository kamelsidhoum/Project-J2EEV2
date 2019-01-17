<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%!
	String titre = "Connexion";
	boolean afficherHeader = true;
	boolean afficherFooter = true;
	String fichierCSS = "css/inscription.css"; //Mettre le CHEMIN du fichier + NOM du fichier + EXTENSION (.css)
	String fichierJS = "js/inscription.js"; //Mettre le CHEMIN du fichier + NOM du fichier + EXTENSION (.js)
%>

<%@ include file="include/header.jsp" %>

		<main>
			<h1>Se connecter à The Spoon</h1>

			<form method="post" action="">
				<input type="hidden" name="redirect" value="<%= request.getParameter("redirect") %>">

				<div style="font-size: 0; background: repeating-linear-gradient(-45deg, #ffebee 0, #ffebee 4px, transparent 4px, transparent 8px); /*background-color: #ffebee;*/ color: #f44336; border-left: 3px solid #f44336; padding: 10px; border-radius: 0 3px 3px 0; margin: 10px 0;">
					<i class="fas fa-exclamation-triangle" style="font-size: 15px; float: left; display: inline-block; padding: 5px 0;"></i>
					<p style="font-size: 15px; margin-left: 25px;">L'identifiant ou le mot de passe n'est pas valide. Essayez à nouveau.</p>
				</div>

				<div>
					<label for="identifiant">Identifiant</label>
					<input type="text" id="identifiant" name="email" placeholder="Email ou n° de téléphone" maxlength="200">
				</div>

				<div>
					<label for="mdp">Mot de passe</label>
					<input type="password" id="mdp" name="mdp" placeholder="Mot de passe" maxlength="200">
					<p style="text-align: right; font-size: 13px; padding: 5px 0 0;"><a href="">Mot de passe oublié&nbsp;?</a></p>
				</div>

				<div style="text-align: center; background-color: inherit;">
					<button type="submit">Se connecter</button>
					<hr text="ou" style="margin: 20px 0;">
					<p style="font-size: 15px;">
						Vous n'avez pas de compte&nbsp;? <a href="inscription.jsp">Inscrivez-vous, c'est gratuit&nbsp;!</a>
					</p>
				</div>
			</form>

		</main>

<%@ include file="include/footer.jsp" %>
