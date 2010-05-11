$(document).ready(function(){
    //Load components for the family selected and change the selected attribute to the family selected
    $("#families").change(function(){
        //$("#families option").removeAttr("selected");
        $("#families option:selected").attr("selected", "selected");
    });
});