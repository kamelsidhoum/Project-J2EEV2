$(document).ready(function() {

	$('#select-profil li').click(function(e) {
		$(this).parent().children('.selected').removeClass('selected');
		$(this).addClass('selected');
		$('#profil').val($(this).attr('value'));
		if ($(this).attr('value') == 'pro') {
			$('.affiche-pro').slideDown(200);
			$('#siret').focus();
		}
		else {
			$('.affiche-pro').slideUp(200);
		}
	});

	$('input').focus(function() {
		$('label[for=' + (($(this).attr('id') == 'nom' || $(this).attr('id') == 'ville') ? $(this).prev().attr('id') : $(this).attr('id')) + ']').addClass('active');
	}).blur(function() {
		$('label[for=' + (($(this).attr('id') == 'nom' || $(this).attr('id') == 'ville') ? $(this).prev().attr('id') : $(this).attr('id')) + ']').removeClass('active');
	});

	/*var tel = '';
	$('#tel').keyup(function(e) {
		var regexTel = new RegExp('^(0[0-9]{0,9})+$');
		if (regexTel.test($(this).val())) {
			tel = $(this).val();
		}
		else {
			$(this).val(tel);
		}
	});*/

	$('#prenom').keyup(function(e) {
		if ($(this).val().length < 3) {
			$(this).addClass('error');
		}
		else {
			$(this).removeClass('error');
		}
	});

});
