<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title><%= titre %> | The Spoon</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
		<!-- Utilisation de Google fonts -->
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Comfortaa:300,400,700|Roboto:200,300,400,600,700,900">
		<!-- Librairie d'icônes FontAwesome -->
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
		<link rel="stylesheet" href="css/main.css">
		<% if (!fichierCSS.equals("")) { %>
		<link rel="stylesheet" href="<%= fichierCSS %>">
		<% } %>
	</head>
	<body>
		<div id="box-mask" style="display: none;"></div>
		<% if (afficherHeader) { %>
		<header>
			<nav>
				<h1>The <span>Spoon</span></h1>
				<input type="text" placeholder="Rechercher un restaurant, une ville, une catégorie...">
				<a href="">Bonjour <span>Berra</span></a>
				<a href="" id="notif" new><i class="fas fa-bell"></i></a>
				<!--
				<a href="" id="show-connexion-box">Connexion</a>
				<a href="inscription.jsp">Inscription</a>
				-->
			</nav>
			<div id="search-mask">
				<ul>
					<li>Un resto</li>
					<li>Un autre resto</li>
					<li>Le crous de Dauphine</li>
					<li>Encore un autre resto</li>
					<li>Voir tous les résultats <i style="font-style: normal; text-transform: none;"></i></li>
				</ul>
				<span>Restaurants populaires</span>
				<ul>
					<li>Un resto</li>
					<li>Un autre resto</li>
				</ul>
			</div>
		</header>
		<div class="box-content" id="connexion-box" style="display: none;">
			<a href="connexion.jsp?type=pro">
				<h3>Connexion restaurateur</h3>
				<p>Publier des annonces et gérez-les via votre espace dédié.</p>
			</a>
			<hr text="ou">
			<a href="connexion.jsp?type=client">
				<h3>Connexion client</h3>
				<p>Réservez en ligne dans un restaurant, évaluez les établissements que vous avez pu vister, et bien plus encore.</p>
			</a>
		</div>
		<div class="box-content" id="inscription-box" style="display: none;">

		</div>
		<% } %>
