<%@ page contentType="text/html" pageEncoding="UTF-8" %>
		<% if (afficherFooter) { %>
		<footer>
			<div>
				<ul>
					<li>Découvrir The Spoon</li>
					<li><a href="">Qui sommes-nous?</a></li>
					<li><a href="">On parle de nous</a></li>
					<li><a href="">Notre blog</a></li>
				</ul>
				<ul>
					<li>Besoin d'aide</li>
					<li><a href="">Contactez-nous</a></li>
					<li><a href="">FAQ</a></li>
					<li><a href="">Conditions générales d'utilisation</a></li>
					<li><a href="">Politique de confidentialité & cookies</a></li>
				</ul>
				<ul>
					<li>Espace pro</li>
					<li><a href="">Proposez votre restaurant</a></li>
					<li><a href="">Espace client professionnel</a></li>
				</ul>
			</div>
			<div>
				<span>&copy;2018 The Spoon — <a href="">Mentions légales</a></span>
			</div>
			<div>
				<a href="" title="Suivez-nous sur Facebook"><i class="fab fa-facebook-f"></i></a>
				<a href="" title=""><i class="fab fa-instagram"></i></a>
				<a href="" title><i class="fab fa-twitter"></i></a>
			</div>
		</footer>
		<% } %>

		<!-- Import de jQuery 3.3.1 -->
		<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
		<script src="js/main.js"></script>
		<% if (!fichierJS.equals("")) { %>
		<script src="<%= fichierJS %>"></script>
		<% } %>
	</body>
</html>
