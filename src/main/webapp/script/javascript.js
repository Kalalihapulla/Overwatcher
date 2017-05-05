/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {




    $("#searchbutton").click(function () {

        var bnetname = $('#searchboxtext1').val();
        var bnetid = $('#searchboxtext2').val();
        var searchurl = "https://owapi.net/api/v3/u/" + bnetname + "-" + bnetid + "/stats";
        var serverid = $("#serverid option:selected").val();

        $.ajax({
            url: searchurl,
            error: function () {
                alert('User not found, try again');
            }


        }).then(function (data) {
            alert("success");

            if (serverid === "eu") {
                userdata = data.eu;
                if (userdata === null) {
                    alert("No data found on this server");
                }
                if (userdata.stats !== null) {
                    document.location.href = "Userstats.jsp";
                }
            }
           else if (serverid === "na") {
                userdata = data.us;
                alert(userdata);
                if (userdata === null) {
                    alert("No data found on this server");
                }
                if (userdata !== null) {
                    document.location.href = "Userstats.jsp";
                }

            }

            else if (serverid === "kr") {
                userdata = data.kr;

                alert(userdata);
                if (userdata === null) {
                    alert("No data found on this server");
                }
                if (userdata !== null) {
                    document.location.href = "Userstats.jsp";
                }

            }
            
              


            alert(userdata.stats.competitive.overall_stats.wins);

            //var test = data.serverid.stats.competitive.overall_stats.wins;

            //  $("#harakkatesti").append(userdata.stats.competitive.overall_stats.wins);


        });

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




});

