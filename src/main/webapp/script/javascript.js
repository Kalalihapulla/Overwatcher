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
        sessionStorage.searchurl = searchurl;
        sessionStorage.serverid = serverid;
        window.location = "/userstats";
        
        alert("data saved");

    });



$(window).load(function () {
    alert("Window loaded");

if (location.pathname === "/userstats") {
    
    alert("loaded userstats");
    
    loadPlayer();
    
}

else if (location.pathname === "/ladderstats") {
    
    alert("loaded ladderstats");
    
    loadLadder();
    
}
    
 function loadLadder() {   

    $.ajax({
        url: "/allPlayers",
        async: false,
        error: function () {
            alert('User not found, try again');
        }


    }).then(function (data) {
        alert("ladder data success");

        var playerCount = 0;

        while (currentPlayer !== null) {


            var currentPlayer = data[playerCount];

            var playerName = currentPlayer.playerName;
            var valueRating = currentPlayer.valueRating;
            var ladderRanking = currentPlayer.rating.us.stats.competitive.overall_stats.comprank;
            var teamName = currentPlayer.teamName;
            var rowId = 1;
            var playerAvatar = currentPlayer.rating.us.stats.competitive.overall_stats.avatar;
            var avatarUrl = document.createElement("img");
            var oImage = new Image();

            avatarUrl.setAttribute("src", playerAvatar);
            var playerNumber = playerCount + 1;

            $('#playerList').append("<tr><th scope='row'>" + playerNumber + " <td>" + playerName + "</td><td> " + valueRating + "</td><td>" + ladderRanking + "</td><td>" + teamName + "</td><td><img id='avatarResize' src=" + playerAvatar + "></td></th></tr>");

            playerCount++;
        }
    });
 }


function loadPlayer() {

    $.ajax({
      
      
        url: sessionStorage.searchurl,
        error: function () {
            alert('User not found, try again');
            window.location = "/usersearch";
//            FIXXXXXXXXXXXXXXX!!!!
        }
        

    }).then(function (data) {
        alert("Player data success");
        var serverid = sessionStorage.serverid;

        if (serverid === "eu") {
            userdata = data.eu;
            if (userdata === null) {
                alert("No data found on this server");
                 window.location = "/usersearch";
            }
            
                
            
        } else if (serverid === "na") {
            userdata = data.us;

            if (userdata === null) {
                alert("No data found on this server");
                 window.location = "/usersearch";
            }
          

        } else if (serverid === "kr") {
            userdata = data.kr;

          
            if (userdata === null) {
                alert("No data found on this server");
                window.location = "/usersearch";
//                FIXXXXXXXXXXXXXXXXXXXXXXXXXX!!!!!!!!!!
            }
           
        }
        
         
                alert("server selected" + serverid);
                alert("current server id: " + sessionStorage.searchurl);
                      
                
              var playerAvatar = userdata.stats.competitive.overall_stats.avatar;
              
               $('#playerinfo').append(userdata.stats.competitive.overall_stats.tier);
               
               $("#playerinfo").append("<img id='avatarResize' src=" + playerAvatar + ">");
                //  document.location.href = "Userstats.jsp";  

   });
     }
     


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
