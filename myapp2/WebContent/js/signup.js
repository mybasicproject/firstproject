$(function(){
	showAllEmployee();
	loadCountryInDropdown();
});	
//$('#signupform').validate();

function showAllEmployee()
{
	$('#user_info').DataTable({
		/*paging: true,
		order: [[ 0, "desc" ]],
	    searching: true,
	    destroy:true,*/
		ajax : {
			url : "UserController?method=showAll",
		},
		/*columnDefs : 
		[ 
		   {
			targets : 0,visible : true
		   },
		   {
			targets : [1,2,3,4,5],visible : true
		   }
		],*/
		"sServerMethod" : "POST"
	});
}

function loadCountryInDropdown()
{
	console.log("loadCountryInDropdown() function executed...");
	$.ajax({
		url: 'UserController?method=loadCountry',
		type: 'post',
		dataType:'json',
		success: function(data){
			console.log("Data Log: "+ JSON.stringify(data));
			var value = data.countryList;
			console.log(value+"..........")
			for(var i=0;i<value.length;i++)
            {
                var opt = new Option(value[i]);
                $("#country").append(opt);
            }
			/*$('#countryList').change(function () {
	            // $('#msg').text('Selected Item: ' + this.options[this.selectedIndex].text);
				var country_name = this.options[this.selectedIndex].text;
				console.log(country_name);
	        });*/
			loadStateInDropdown();
		} 
	});
}

function loadStateInDropdown()
{
	$('#country').change(function () {
        var country_name = $(this).find('option:selected').text();
		console.log("Country Name: "+country_name);
		$.ajax({
			url: 'UserController?method=loadState&country_name='+country_name,
			type: 'post',
			dataType:'json',
			success: function(data){			
				console.log("Data = "+JSON.stringify(data));
				var value = data.stateList;
				console.log(value+"..........");
				$("#state").empty();
				for(var i=0;i<value.length;i++)
	            {
	                var opt = new Option(value[i]);
	                $("#state").append(opt);
	            }
				loadCityInDropdown();
			} 
		});
     });
}

function loadCityInDropdown()
{
	$('#state').change(function () {
		var state_name = $(this).find('option:selected').text();
		console.log("State Name: "+state_name);
		$.ajax({
			url: 'UserController?method=loadCity&state_name='+state_name,
			type: 'post',
			dataType:'json',
			success: function(data){			
				console.log("Data = "+JSON.stringify(data));
				var value = data.cityList;
				console.log(value+"..........");
				$("#city").empty();
				for(var i=0;i<value.length;i++)
	            {
	                var opt = new Option(value[i]);
	                $("#city").append(opt);
	            }
			} 
		});
     });
	
	
}
