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


        if (location.pathname === "/userstats") {

            loadPlayer();

        } else if (location.pathname === "/ladderstats") {

            sessionStorage.statsId = "defStats";

            loadLadder();

            appendLadder();



        }

        function loadLadder() {
            alert("Loading player statistics. Please wait...");

            $.ajax({
                url: "/allPlayers",
                async: false,
                error: function () {
                    alert('User not found, try again');
                }


            }).then(function (data) {
                alert("Player statistics loaded!");

                sessionStorage.ladderdata = JSON.stringify(data);


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

                alert("server selected " + serverid);

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


    function appendLadder() {

        var data = JSON.parse(sessionStorage.ladderdata);

        $("#playerList").empty();

        var playerCount = 0;

        var currentPlayer = 0;


        if (sessionStorage.statsId === "defStats") {
            //FIX table header...
            $('#playerList').append("<tr id='tableHead'><th>#</th><th></th><th>Player name</th><th>Value rating</th><th>Ladder ranking</th><th>Team name</th></tr>");

            while (currentPlayer !== null) {

                currentPlayer = data[playerCount];
                var playerName = currentPlayer.playerName;
                var teamName = currentPlayer.teamName;
                var playerAvatar = currentPlayer.rating.us.stats.competitive.overall_stats.avatar;
                var avatarUrl = document.createElement("img");
                avatarUrl.setAttribute("src", playerAvatar);
                var playerNumber = playerCount + 1;
                var ladderRanking = currentPlayer.rating.us.stats.competitive.overall_stats.comprank;
                var valueRating = currentPlayer.valueRating;


                $("#playerList").append("<tr><th scope='row'>" + playerNumber + " <td><img id='avatarResize' src=" + playerAvatar + "></td><td>" + playerName + "</td><td> " + valueRating + "</td><td>" + ladderRanking + "</td><td>" + teamName + "</td></th></tr>");
                playerCount++;

            }


        } else if (sessionStorage.statsId === "offStats") {

            $('#playerList').append("<tr id='tableHead'><th>#</th><th></th><th>Player name</th><th>Eliminations Avg.</th><th>Deaths Avg.</th><th>K/D ratio</th><th>Team name</th></tr>");
            while (currentPlayer !== null) {


                var currentPlayer = data[playerCount];
                var playerName = currentPlayer.playerName;
                var teamName = currentPlayer.teamName;
                var playerAvatar = currentPlayer.rating.us.stats.competitive.overall_stats.avatar;
                var avatarUrl = document.createElement("img");
                avatarUrl.setAttribute("src", playerAvatar);
                var playerNumber = playerCount + 1;
                var elimsAvg = currentPlayer.rating.us.stats.competitive.average_stats.eliminations_avg;
                var deathsAvg = currentPlayer.rating.us.stats.competitive.average_stats.deaths_avg;
                var kDa = elimsAvg / deathsAvg;
                kDa = kDa.toFixed(3);


                $('#playerList').append("<tr><th scope='row'>" + playerNumber + " <td><img id='avatarResize' src=" + playerAvatar + "></td><td>" + playerName + "</td><td> " + elimsAvg + "</td><td>" + deathsAvg + "</td><td>" + kDa + "</td><td>" + teamName + "</td></th></tr>");

                playerCount++;

            }


        } else if (sessionStorage.statsId === "matStats") {

            $('#playerList').append("<tr id='tableHead'><th>#</th><th></th><th>Player name</th><th>Winrate</th><th>Wins</th><th>Losses</th><th>Games</th><th>Team name</th></tr>");
            while (currentPlayer !== null) {


                var currentPlayer = data[playerCount];
                var playerName = currentPlayer.playerName;
                var teamName = currentPlayer.teamName;
                var playerAvatar = currentPlayer.rating.us.stats.competitive.overall_stats.avatar;
                var avatarUrl = document.createElement("img");
                avatarUrl.setAttribute("src", playerAvatar);
                var playerNumber = playerCount + 1;
                var winrate = currentPlayer.rating.us.stats.competitive.overall_stats.winrate;
                var wins = currentPlayer.rating.us.stats.competitive.overall_stats.wins;
                var losses = currentPlayer.rating.us.stats.competitive.overall_stats.losses;
                var games = currentPlayer.rating.us.stats.competitive.overall_stats.games;

                $('#playerList').append("<tr><th scope='row'>" + playerNumber + " <td><img id='avatarResize' src=" + playerAvatar + "></td><td>" + playerName + "</td><td> " + winrate + "</td><td>" + wins + "</td><td>" + losses + "</td><td>" + games + "</td><td>" + teamName + "</td></th></tr>");

                playerCount++;

            }


        }

    }


    $("#statsId").change(function () {


        sessionStorage.statsId = $("#statsId option:selected").val();
        appendLadder();


    });

});
