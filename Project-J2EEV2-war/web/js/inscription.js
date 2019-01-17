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

        //Regex pour empecher à l'utilisateur de saisir autre que des chiffres
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

        var contraintes = {
            'prenom': {
                'minlength': 2,
								'msg': "Le prénom doit être composé au minimum de 2 caractères."
            },

            'nom': {
                'minlength': 2,
								'msg': "Le nom doit être composé au minimum de 2 caractères."
            },

            'email': {
                'regex': /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
								'msg': "Cette adresse mail n'est pas valide."
            },

            'mdp':{
                'minlength': 8,
                'maxlength': 40,
								'msg': "Le mot de passe doit être compris entre 8 et 40 caractères."
            },

            'tel':{
                'regex': /^(0[0-9]{0,9})+$/,
								'msg': "Le numéro de téléphone doit être au format français (exemple: 0605040302)."
            },

            'adresse':{
                'minlength': 6,
								'msg': "Votre adresse n'est pas valide."

            },

            'cp':{
                'minlength': 5,
								'msg': "Le format du code postal n'est pas valide."
            },

						'siret':{
							'minlength': 14,
							'msg': "Le numéro SIRET n'est pas valide."
						}

        };

        $('main form input').keyup(function(e) {
           var c = contraintes[$(this).attr('id')];
           for (var type in c){

               if(type=="minlength"){
                   if($(this).val().length > 0 && $(this).val().length < c[type]){
                       $(this).addClass('error');
                   }
                   else{
                       $(this).removeClass('error');
                   }
               }

               if(type=="regex"){
                   if($(this).val().length > 0 && (new RegExp(c[type])).test($(this).val())) {
                       $(this).removeClass('error');
                   }
                   else if ($(this).val().length > 0) {
                       $(this).addClass('error');
                   }
               }

							 if(type=="msg" && $(this).hasClass('error') && $(this).parent().children('p:eq(-1)').length == 0){
								 var $msgError = $('<p class="err-msg" style="display:none;">' + c[type] +  '</p>');
								 $(this).parent().append($msgError);
								 $msgError.slideDown(300);
							 }
							 else if (!($(this).hasClass('error'))) {
								 var thisItem = $(this);
								 $(this).parent().children('p:eq(-1)').slideUp(300);
								 setTimeout(function(){
									 thisItem.parent().children('p:eq(-1)').remove();
								 }, 300);
							}
           }
        });


});
