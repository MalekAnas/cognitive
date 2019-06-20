var request =new XMLHttpRequest();


$(document).onload(function () {
    generateJsonFile();

});

function generateJsonFile(){
   $.getJSON('json/generated.json', function (data) {

       console.log("it works");
   })
};

$(document).ready(function(){






    $("#finish").click(function () {

        $("#test").hide();

    });

});