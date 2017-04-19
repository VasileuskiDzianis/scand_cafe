$(function() {
	$("#buyer").validate({

		rules : {

			firstName : "required",
			lastName : "required",
			address : {
				required : true,
				minlength : 10
			}

		},
		// Error messages
		messages : {
			firstName : "Пожалуйста, введите имя",
			lastName : "Пожалуйста, введите фамилию",
			address : {
				required : "Пожалуйста, введите адрес",
				minlength : "Адрес не может быть меньше 10 символов",
			}
		},
		submitHandler : function(form) {
			form.submit();
		}
	});

});
$.validator.messages.digits = "только цифры";
jQuery.validator.addClassRules("amountfield", {
	  digits: true,
	});
$(function() {
	$("#catalogform").validate({
			submitHandler : function(form) {
			form.submit();
		}
	});

});

