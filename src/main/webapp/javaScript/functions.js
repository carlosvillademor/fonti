$(document).ready(function(){

    //Load components for the family selected
    $("#families").change(function(){
        $("#componentsSelection").load("loadComponents.htm?familyCode=" + $("#families").val() + "&documentId=" + $("#documentId").val());
    });
    
});