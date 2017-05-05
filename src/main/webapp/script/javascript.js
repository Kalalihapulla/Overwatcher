/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    
 $.ajax({
        url: "https://owapi.net/api/v3/u/cocco-2188/stats"
       

    }).then(function(data) {
       alert("success");
       console.log("asdasd");
       alert(data);
    var test = data.us.stats.competitive.overall_stats.wins;
     
        $("#harakkatesti").append(test);
       
    });



    var Stage = 0;
    setInterval(function () {
        var bg = "url(contents/owbg" + (Stage + 1) + ".png) no-repeat center center fixed";
        document.body.style.background = bg;
        Stage = ++Stage % 9;
        $("body").css({"-webkit-background-size": "cover", "-moz-background-size:": "cover", 
        "-o-background-size": "cover", "background-size": "cover"});
       
    }, 10000);



    $("#searchboxtext2").hide();
    $("#searchboxtext1").on('input', function () {
        $("#searchboxtext2").show();
    });


    $("#searchbutton").click(function () {
        alert("monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS monkaS ");
    });


});

