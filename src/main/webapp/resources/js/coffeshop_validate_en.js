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
			firstName : "Please enter your firstname",
			lastName : "Please enter your lastname",
			address : {
				required : "Please enter address",
				minlength : "Address can't be shorter than 10 symbols",
			}
		},
		submitHandler : function(form) {
			form.submit();
		}
	});

});
$.validator.messages.digits = "digits only";
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

