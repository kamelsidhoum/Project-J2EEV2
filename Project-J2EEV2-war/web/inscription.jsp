<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%!
	String titre = "Inscription";
	boolean afficherHeader = true;
	boolean afficherFooter = true;
	String fichierCSS = "css/inscription.css"; //Mettre le CHEMIN du fichier + NOM du fichier + EXTENSION (.css)
	String fichierJS = "js/inscription.js"; //Mettre le CHEMIN du fichier + NOM du fichier + EXTENSION (.js)
%>

<%@ include file="include/header.jsp" %>

		<main>
			<h1>S'inscrire sur The Spoon</h1>

			<form method="post" action="AjoutUtilisateurParticulierServlet">
				<div>
					<label for="select-profil">Je suis un...</label>
					<ul id="select-profil">
						<li value="client" class="selected">client</li>
						<li value="pro">restaurateur</li>
					</ul>
					<input type="hidden" id="profil" name="profil" value="client">
				</div>

				<div class="affiche-pro" style="display: none;">
					<label for="siret">Numéro SIRET</label>
					<input type="text" id="siret" name="siret" placeholder="N° SIRET" maxlength="50">
				</div>

				<div>
					<label for="prenom">Nom complet</label>
					<input type="text" id="prenom" name="prenom" placeholder="Prénom" maxlength="50">
					<input type="text" id="nom" name="nom" placeholder="Nom" maxlength="50">
				</div>

				<div>
					<label for="email">Email</label>
					<input type="text" id="email" name="email" placeholder="Adresse email" maxlength="200">
				</div>

				<div>
					<label for="mdp">Mot de passe</label>
					<input type="password" id="mdp" name="mdp" placeholder="Au moins 8 caractères" maxlength="200">
				</div>

				<div>
					<label for="tel">Numéro de téléphone</label>
					<input type="phone" id="tel" name="tel" placeholder="N° mobile ou fixe" maxlength="10">
				</div>

				<div>
					<label for="adresse">Adresse</label>
					<input type="text" id="adresse" name="adresse" placeholder="Adresse" maxlength="100">
				</div>

				<div>
					<label for="cp">Ville</label>
					<input type="text" id="cp" name="cp" placeholder="Code Postal" maxlength="5">
					<input type="text" id="ville" name="ville" placeholder="Ville" maxlength="50">
				</div>

				<div>
					<label for="pays">Pays</label>
					<input type="text" id="pays" name="cp" placeholder="Pays" value="France" maxlength="50" disabled>
				</div>
				<hr text="avant de continuer...">
				<p style="margin: 10px 0; color: #aaa; font-size: 13px;">
					En cliquant sur "Créer le compte", vous acceptez les <a href="">conditions générales d'utilisation</a> et la <a href="">politique de confidentialité</a> de The Spoon.
				</p>

				<div style="text-align: center;">
					<button type="submit">Créer le compte</button>
				</div>
			</form>

		</main>

<%@ include file="include/footer.jsp" %>
