$(document).ready(function(){
    //Load components for the family selected
    $('#families').change(function(){
        $('#families option:selected'){
        	alert(familyCode);
        	var familyCode = $(this).text();
        	$('#componentsSelection').load('loadComponents.htm?familyCode=' + familyCode);
        }
    });
});