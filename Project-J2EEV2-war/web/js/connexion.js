$(document).ready(function() {

	$('#validate-btn').click(function(e) {
		$.get(
			'/ConnexionVerificationServlet',
			{ email: $('#email').val() },
			function(data) {
				if (data.verification) { //l'email existe dans la bdd
					$('#validate-btn').text('Valider').attr('type', 'submit');
					$('#email-hidden').val($('#email').val());
					$('#email-field').slideUp(300);
					$('#mdp-field').slideDown(300);
				}
				else { //l'email n'existe PAS dans la bdd
					alert('L\'email renseigné n\'est pas valide.');
					$('#email').val('').focus();
				}
			}
		);
	});

});
