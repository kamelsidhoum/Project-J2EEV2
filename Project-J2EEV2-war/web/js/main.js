$(document).ready(function() {

	//Barre de recherche du header :
	$('nav > input').focus(function(e) {
		$('#search-mask').fadeIn(50);
	}).blur(function(e) {
		$('#search-mask').fadeOut(50);
	}).keyup(function(e) {
		if ($(this).val().length == 0) {
			$('#search-mask ul').eq(0).slideUp(50);
		}
		else {
			$('#search-mask ul').eq(0).slideDown(50);
		}
		$('#search-mask i').text('pour « ' + $(this).val() + ' »'); //temporaire
	})/*.keyup()*/;

	//On masque les suggestions de recherche lorsque le focus était sur la barre de recherche alors qu'on a scrollé :
	$(window).scroll(function(e) {
		$('nav > input').blur();
	});

	$('#show-connexion-box').click(function(e) {
		e.preventDefault();
		$('#connexion-box').show();
		$('#box-mask').fadeIn(500);
		$('body').addClass('no-scroll');
	});

	$('#box-mask').click(function(e) {
		$(this).fadeOut(500);
		$('.box-content:visible').fadeOut(200);
		$('body').removeClass('no-scroll');
	});

});
