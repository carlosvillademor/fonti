$(document).ready(function(){
    //Load components for the family selected
    $("#families").change(function(){
        $("#componentsSelection").load("loadComponents.htm?familyCode=" + $("#families").val());
    });

    //Select the components to add to the document
    $("#selectComponents").click(function(){
        $("#selectedComponents").post("selectComponents.htm?familyName=" + $("#families").text(),
            $("#addComponentes").serialize());
    });
});