/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {




//    $("#searchbutton").click(function () {
//
//
//        var bnetname = $('#searchboxtext1').val();
//        var bnetid = $('#searchboxtext2').val();
//        var searchurl = "https://owapi.net/api/v3/u/" + bnetname + "-" + bnetid + "/stats";
//        var serverid = $("#serverid option:selected").val();
//
//
//
//
//
//        $.ajax({
//            url: searchurl,
//            error: function () {
//                alert('User not found, try again');
//            }
//
//
//        }).then(function (data) {
//            alert("success");
//
//
//            if (serverid === "eu") {
//                userdata = data.eu;
//                if (userdata === null) {
//                    alert("No data found on this server");
//                }
//                if (userdata.stats !== null) {
//
//                    window.location = "Userstats.jsp";
//                    //  document.location.href = "Userstats.jsp";  
//
//
//
//
//
//                }
//            } else if (serverid === "na") {
//                userdata = data.us;
//
//                if (userdata === null) {
//                    alert("No data found on this server");
//                }
//                if (userdata !== null) {
//                    document.location.href = "Userstats.jsp";
//                }
//
//            } else if (serverid === "kr") {
//                userdata = data.kr;
//
//                alert(userdata);
//                if (userdata === null) {
//                    alert("No data found on this server");
//                }
//                if (userdata !== null) {
//                    document.location.href = "Userstats.jsp";
//                }
//
//            }
//
//            alert("hurdur");
//
//            //  var userpic = userdata.stats.competitive.overall_stats.tier;
//            //alert(userpic);     
//            var avatar = userdata.stats.competitive.overall_stats.avatar;
//
//            $("#test").append("<img src='" + avatar + "' alt='my image'>");
//
//
//
//        });
//
//
//    });
//    
//    $( "#statsbody" ).load(function() {
//         alert("Works");
//        var searchurl = "https://owapi.net/api/v3/u/Wormps-2555/stats";
//       
//
//        $.ajax({
//            url: searchurl,
//            error: function () {
//                alert('User not found, try again');
//            }
//
//
//        }).then(function (data) {
//            alert("success");
//
//            
//             
//            var avatar = data.eu.stats.competitive.overall_stats.tier;
//            alert(avatar);
//            
//            $("#test").append(avatar);
//           // $("#test").append("<img src='" + avatar + "' alt='my image'>");
//
//
//
//        });
//
//
//    });
//
//
//    $("#searchbutton").click(function () {
//
//        
//       
//    });
//    
        $(window).load(function () {
  
        alert("loaded");
        
        $.ajax({
            url: "/getPlayer?id=2",
            error: function () {
                alert('User not found, try again');
            }


        }).then(function (data) {
            alert("success");

            var playerName = data.playerName;
            var valueRating = data.valueRating;
            var ladderRanking = data.rating.us.stats.competitive.overall_stats.comprank;
            var teamName = data.teamName;
            var rowId = 1;


           //$('#playerList').append("<tr><th scope="row"> + rowId + "<td>" + playerName + "</td><td> " + valueRating + "</td><td>" + ladderRanking + "</td><td>" + teamName + "</td></th></tr>");
           $('#playerList').append('<tr><th scope="row">2<td>pname</td><td>vrating</td><td>ladrating</td><td>teamname</td><td><img src="https://pbs.twimg.com/profile_images/378800000822867536/3f5a00acf72df93528b6bb7cd0a4fd0c.jpeg%22%3E</td></th></tr>');
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
});

