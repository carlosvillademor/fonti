$(document).ready(function(){
    //Load components for the family selected
    $("#families").change(function(){
        $("#families option:selected"){
            $("#componentsSelection").load("loadComponents.htm?familyCode=$(this).val()");
        }
    });
});