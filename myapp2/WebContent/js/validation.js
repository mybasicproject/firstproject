jQuery.validator.addMethod("email", function(value, element) {
	  return this.optional( element ) || value == value.match(/^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@(?:\S{1,63})$/);
}, 'Please enter a valid email address.');

jQuery.validator.addMethod("alphaNumeric", function(value, element) {
	  return this.optional( element ) || value == value.match(/^[a-zA-Z ]+$/);
}, 'Only alphabets allowed');

jQuery.validator.addMethod("numericOnly", function(value, element) {
	  return this.optional( element ) || value == value.match(/^[0-9]\d*(\d+)?$/g);
}, 'Only Numerics allowed');


$('#signupform').validate({
		rules:{
			firstname: "required",
			lastname: "required",		
		
			pincode:{
				required:true,
				numericOnly: true,
				minlength:6,
				maxlength:6
			},
			areaname:{
				required:true,
				alphanumeric:true,
				minlength:3
			},
			contact:{
				required:true,
				numericOnly: true,
				minlength:10,
				maxlength:10
			},
			email:{
				required: true,
				email: true
			},
			pass:{
				required: true,
				minlength: 3
			},
			cnfpass:{
				required: true,
				minlength: 3,
				equalTo: "#pass"
			},
			messages:{
				firstname:"please enter firstname",
				lastname:"please enter lastname",

				pincode:{
					required:"please provide pincode number",
					minlength:"pincode must be at least 6 digits"
				},
				areaname:{
					required:"please enter area name",
					minlength:"area muset be atleast 6 characters long"
					},
				contact:{
					required:"please provide contact number",
					minlength:"contact number must be 10 digits",
				},
				pass:{
					required:"please provide password",
					minlength:"password must be at least 6 characters long",
				},
				cnfpass:{
					required:"please provide confirm password",
					minlength:"confirm password must be at least 6 characters long",
					equalTo:"please enter the same password as above",
				},
			},
			
		},
		
	});


$("#loginform").validate({
	rules:{
		username: {
			required: true,
			
		},
		pwd:{
			required:true,
			maxlength:10
		},	
	},
	messages:{
		username:"Username required",
	
		pwd:{
			required:'password required',
			maxlength:'max 10 character allowed'
		}
	},
	
});