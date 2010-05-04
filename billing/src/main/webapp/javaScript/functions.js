$(document).ready(function(){
    //Load components for the family selected and change the selected attribute to the family selected
    $("#families").change(function(){
        $("#families option:selected").removeAttr("selected");
//        $(this).attr("selected", "selected");
    });
});