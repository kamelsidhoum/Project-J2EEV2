<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%!
	String titre = "";
	boolean afficherHeader = true;
	boolean afficherFooter = true;
	String fichierCSS = "css/restaurant.css"; //Mettre le CHEMIN du fichier + NOM du fichier + EXTENSION (.css)
	String fichierJS = "js/restaurant.js"; //Mettre le CHEMIN du fichier + NOM du fichier + EXTENSION (.js)
%>

<%
	/* TEMPORAIRE, à remplacer par des données de la bdd */
	int restoId = 1;
	int restoUsproId = 1;
	String restoNom = "Le CROUS de Dauphine";
	String restoDesc = "Le CROUS de l'Université Paris Dauphine vous accueille tous les midis (et même le samedi, eh oui on chôme pas nous!) afin de déguster des plats savoureux préparés par nos chefs en cuisine.";
	String restoNumSiret = "4893478583";
	int restoNbCouvert = 10;
	String restoAdresse = "Place du Maréchal de Lattre de Tassigny";
	int restoCodePostal = 75016;
	String restoVille = "Paris";
	String restoNumTel = "+33 1 01 01 01 01";
	String restoEmail = "crous@dauphine.fr";
	String restoDateInscription = "13/01/2019";

	int restoNbImg = 5; // Aller checker dans le dossier des uploads si on trouve des images des restos, et si oui combien

	ArrayList restoListeCategorie = new ArrayList();
	restoListeCategorie.add("Haute gastronomie de qualité");
	restoListeCategorie.add("Produits du terroir");
	restoListeCategorie.add("Fait maison");
	restoListeCategorie.add("Végétarien");

	titre = restoNom;
%>
<%@ include file="include/header.jsp" %>

		<main>
			<input type="hidden" id="restoId" value="<%= restoId %>">
			<input type="hidden" id="restoNbImg" value="<%= restoNbImg %>">
			<h1><%= restoNom %></h1>
			<aside class="aside-img">
				<% for (int i = 1; i <= (restoNbImg > 3 ? 3 : restoNbImg); i++) { %>
				<img class="img-openable" src="upload/resto-<%= restoId %>-<%= i %>.jpg">
				<% if (restoNbImg > 3 && i == 2) { %>
					<i class="fas fa-arrow-circle-down" title="Voir plus de photos"></i>
				<% } %>
				<% } %>
			</aside>
			<article>
				<p style="margin: 0; text-align: right; font-size: 0; float: right; margin-left: 50px;">
					<span class="star-rate">
						<i class="fas fa-star"></i>
						<i class="fas fa-star-half-alt"></i>
						<i class="far fa-star"></i>
						<i class="far fa-star"></i>
						<i class="far fa-star"></i>
					</span>
					<span style="display: inline-block; vertical-align: middle; font-size: 15px; margin-left: 10px;">
						<b style="font-size: 30px; font-weight: 600; color: #000;">1,5</b>/5
					</span>
					<span style="display: block; font-size: 14px; color: #aaa;">4 avis</span>
				</p>
				<p class="categories-list">
					<% for (int i = 0; i < restoListeCategorie.size(); i++) { %>
					<span><%= restoListeCategorie.get(i) %></span>
					<% } %>
				</p>
				<p>
					<%= restoAdresse %><br>
					<%= restoCodePostal %> <%= restoVille %>
				</p>
				<div class="resto-contact">
					<p>
						<a href="tel:<%= restoNumTel %>">
							<i class="fas fa-phone fa-flip-horizontal"></i>
							<span><%= restoNumTel %></span>
						</a>
					</p>
					<p>
						<a href="mailto:<%= restoEmail %>">
							<i class="fas fa-comment-alt"></i>
							<span><%= restoEmail %></span>
						</a>
					</p>
				</div>
				<div class="resto-desc">
					<h2>Quelques mots sur le restaurant</h2>
					<p>
						<%= restoDesc %>
					</p>
				</div>
				<div style="background-color: #fff; border: 1px solid #e4e4e4; border-top: 0; border-radius: 0 0 3px 3px; padding: 10px; margin: 20px 0 10px;">
					<ul class="tab-nav">
						<li show="menu" class="active">Menu</li>
						<li show="avis">Avis</li>
					</ul>
					<div id="menu-tab">
						<p>Menu du restaurant............</p>
						<p style="border-top: 1px solid #ddd; padding-top: 10px; margin-top: 10px; text-align: center; color: #aaa;">Les prix et les plats sont susceptibles de changer. Les prix affichés tiennent compte de la TVA.</p>
					</div>
					<div id="avis-tab"  style="display: none;">
						<p style="margin: 10px 0; font-size: 0; border-bottom: 1px solid #e4e4e4; text-align: center; padding-bottom: 10px;">
							<i class="fas fa-users" style="font-size: 50px; margin-right: 10px; display: inline-block; vertical-align: middle; width: 70px;"></i>
							<span style="display: inline-block; vertical-align: middle; width: calc(350px - 80px); font-size: 15px; text-align: left;">Retrouvez ici les avis des clients ayant été dans ce restaurant après avoir réservé une table via The Spoon.</span>
						</p>
						<label for="avis-input">Vous avez été au restaurant <%= restoNom %> ?</label>
						<textarea id="avis-input" placeholder="Écrivez votre avis..." style="resize: none; width: 100%; padding: 0; border: 0; background-color: #fff; font-family: inherit; font-size: 17px; color: #000; margin: 10px 0;"></textarea>
						<!--<label>Quelle note mettriez-vous à ce restaurant ?</label>
						<i class="fas fa-minus-circle" title="Diminuer la note"></i>
						<span class="star-rate">
							<i class="fas fa-star"></i>
							<i class="fas fa-star-half-alt"></i>
							<i class="far fa-star"></i>
							<i class="far fa-star"></i>
							<i class="far fa-star"></i>
						</span>
						<i class="fas fa-plus-circle" title="Augmenter la note"></i>
						<button>Envoyer</button>-->
					</div>
				</div>
			</article>
		</main>

<%@ include file="include/footer.jsp" %>
