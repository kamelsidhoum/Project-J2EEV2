$(document).ready(function() {

	//Barre d'onglets Annonces/Menu/Avis :
	$('.tab-nav li').click(function(e) {
		$('#' + $(this).parent().children('li.active').attr('show') + '-tab').slideUp(100);
		$('#' + $(this).attr('show') + '-tab').slideDown(100);
		$(this).parent().find('li.active').removeClass('active');
		$(this).addClass('active');
	});

	//Chargement des images supplémentaires :
	$('.aside-img > i').click(function(e) {
		for (var i = 4; i <= parseInt($('#restoNbImg').val()); i++) {
			var $img = $('<img class="img-openable" src="upload/resto-' + $('#restoId').val() + '-' + i + '.jpg" style="display: none;">');
			$(this).parent().append($img);
		}
		var thisItem = $(this);
		setTimeout(function() {
			thisItem.parent().children('img').not(':visible').each(function(e) {
				$(this).slideDown(100);
			});
			thisItem.remove();
		}, 500);

	});

});
