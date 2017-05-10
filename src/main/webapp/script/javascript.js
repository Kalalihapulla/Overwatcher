/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





/* global c3, d3 */

$(document).ready(function () {



    $("#searchbutton").click(function () {


        var bnetname = $('#searchboxtext1').val();
        var bnetid = $('#searchboxtext2').val();
        var searchurl = "https://owapi.net/api/v3/u/" + bnetname + "-" + bnetid + "/stats";
        var serverid = $("#serverid option:selected").val();
        sessionStorage.searchurl = searchurl;
        sessionStorage.serverid = serverid;
        sessionStorage.bnetName = bnetname + "#" + bnetid;

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
//      else if (location.pathname === "/teamstats") {
//            sessionStorage.statsId = "fnatic";
//
//            loadLadder();
//            loadTeams();
//            appendLadder();
//
//        }

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
//        function loadTeams() {
//            alert("Loading team statistics. Please wait...");
//
//            $.ajax({
//                url: "/allTeams",
//                async: false,
//                error: function () {
//                    alert('Team not found, try again');
//                }
//
//
//            }).then(function (teamData) {
//                alert("Team statistics loaded!");
//
//                sessionStorage.teamdata = JSON.stringify(teamData);
//
//
//            });
//        }


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
                var rankIcon;
                var playerAvatar = userdata.stats.competitive.overall_stats.avatar;
                var userName = sessionStorage.bnetName;
                var rankImg = userdata.stats.competitive.overall_stats.rank_image;
                var prestigeLvl = userdata.stats.competitive.overall_stats.prestige;
                var playerLvl = userdata.stats.competitive.overall_stats.level;
                var ladderRank = userdata.stats.competitive.overall_stats.comprank;
                var compWins = userdata.stats.competitive.overall_stats.wins;
                var compLosses = userdata.stats.competitive.overall_stats.losses;
                var compTies = userdata.stats.competitive.overall_stats.ties;
                var compGames = "Games: " + userdata.stats.competitive.overall_stats.games;
                var compWlt = "Wins: " + compWins + " - Losses: " + compLosses + " - Ties: " + compTies;
                var compWinrate = userdata.stats.competitive.overall_stats.win_rate;

                if (ladderRank >= 4000) {
                    rankIcon = "../contents/gmicon.png";
                } else if (ladderRank >= 3500 && ladderRank < 4000) {
                    rankIcon = "../contents/mastericon.png";
                } else if (ladderRank >= 3000 && ladderRank < 3500) {
                    rankIcon = "../contents/diamondicon.png";
                } else if (ladderRank >= 2500 && ladderRank < 3000) {
                    rankIcon = "../contents/platicon.png";
                } else if (ladderRank >= 2000 && ladderRank < 2500) {
                    rankIcon = "../contents/goldicon.png";
                } else if (ladderRank >= 1500 && ladderRank < 2000) {
                    rankIcon = "../contents/silvericon.png";
                } else if (ladderRank < 1500) {
                    rankIcon = "../contents/bronzeicon.png";
                }

                if (playerLvl === 100) {
                    playerLvl = "00";
                    prestigeLvl = prestigeLvl + 1;
                    $("#playerLevel").css("margin-left", "-4em");
                }


                $("#playerinfo").append("<img id='avatarResize2' src=" + playerAvatar + "><span id='playerName'> " + userName + "</span><img id='rankImgResize' src="
                        + rankImg + "><span id='playerLevel'> " + prestigeLvl + "" + playerLvl + "</span> \n\
                 <img id='rankIcon' src=" + rankIcon + "><span id='rankText'> " + ladderRank + "</span><span id='compGamesText'> " + compGames + " </span>\n\
                <span class='wltText'>Wins: &nbsp;</span><span id='compWinsText'> " + compWins + "</span><span class='wltText'> &nbsp;- &nbsp;Losses: &nbsp;</span><span id='compLossesText'> " + compLosses + " </span>\n\
                <span class='wltText'>&nbsp; - &nbsp;Ties: &nbsp;</span><span id='compTiesText'> " + compTies + "</span>");

                getWinrateChart(compWinrate);

                $('#playerStats').append("<tr id='tableHead'><th></th><th></th><th>Player name</th><th>Eliminations Avg.</th><th>Deaths Avg.</th><th>K/D ratio</th><th>Team name</th></tr>");
                $('#playerStats').append("<tr><th scope='row'>Competitive<td><img id='avatarResize' src=" + playerAvatar + "></td><td>" + playerName + "</td><td> " + winrate + "</td><td>" + wins + "</td><td>" + losses + "</td><td>" + games + "</td><td>" + teamName + "</td></th></tr>");
                $('#playerStats').append("<tr><th scope='row'>Quickplay<td><img id='avatarResize' src=" + playerAvatar + "></td><td>" + playerName + "</td><td> " + winrate + "</td><td>" + wins + "</td><td>" + losses + "</td><td>" + games + "</td><td>" + teamName + "</td></th></tr>");

            });
        }


    });
    function appendTeams(data1,value) {
        var data = data1;
        alert(data + value);
        $("#playerList").empty();

        var playerCount = 0;

        var currentPlayer = 0;

        if (value === "envyus") {
            $('#playerList').append("<tr id='tableHead'><th>#</th><th></th><th>Player name</th><th>Value rating</th><th>Ladder ranking</th><th>Team ranking</th></tr>");

            while (currentPlayer !== null) {

                currentPlayer = data[playerCount];
                alert("Current player: " + currentPlayer);
                var playerName = currentPlayer.playerName;
                alert("Player name: " + playerName);
                var teamName = currentPlayer.teamName;
                var playerAvatar = currentPlayer.rating.us.stats.competitive.overall_stats.avatar;
                var avatarUrl = document.createElement("img");
                avatarUrl.setAttribute("src", playerAvatar);
                var playerNumber = playerCount + 1;
                var ladderRanking = currentPlayer.rating.us.stats.competitive.overall_stats.comprank;
                var valueRating = currentPlayer.valueRating;

                if (currentPlayer.teamName === "Team_EnVyUs") {
                $("#playerList").append("<tr><th scope='row'>" + playerNumber + " <td><img id='avatarResize' src=" + playerAvatar + "></td><td>" + playerName + "</td><td> " + valueRating + "</td><td>" + ladderRanking + "</td><td>" + teamName + "</td></th></tr>");
                playerCount++;
                }

            }
        } else if (value === "nrg") {
            $('#playerList').append("<tr id='tableHead'><th>#</th><th></th><th>Player name</th><th>Value rating</th><th>Ladder ranking</th><th>Team ranking</th></tr>");

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

                if (currentPlayer.teamName === "NRG_Esports") {
                    $("#playerList").append("<tr><th scope='row'>" + playerNumber + " <td><img id='avatarResize' src=" + playerAvatar + "></td><td>" + playerName + "</td><td> " + valueRating + "</td><td>" + ladderRanking + "</td><td>" + teamName + "</td></th></tr>");
                    playerCount++;
                }

            }
        } else if (value === "c9") {
            $('#playerList').append("<tr id='tableHead'><th>#</th><th></th><th>Player name</th><th>Value rating</th><th>Ladder ranking</th><th>Team ranking</th></tr>");

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

                if (currentPlayer.teamName === "Cloud9") {
                    $("#playerList").append("<tr><th scope='row'>" + playerNumber + " <td><img id='avatarResize' src=" + playerAvatar + "></td><td>" + playerName + "</td><td> " + valueRating + "</td><td>" + ladderRanking + "</td><td>" + teamName + "</td></th></tr>");
                    playerCount++;
                }

            }
        } else if (value === "fnatic") {
            $('#playerList').append("<tr id='tableHead'><th>#</th><th></th><th>Player name</th><th>Value rating</th><th>Ladder ranking</th><th>Team ranking</th></tr>");

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

                if (currentPlayer.teamName === "Fnatic") {
                    $("#playerList").append("<tr><th scope='row'>" + playerNumber + " <td><img id='avatarResize' src=" + playerAvatar + "></td><td>" + playerName + "</td><td> " + valueRating + "</td><td>" + ladderRanking + "</td><td>" + teamName + "</td></th></tr>");
                    playerCount++;
                }

            }
        } else if (value === "misfits") {
            $('#playerList').append("<tr id='tableHead'><th>#</th><th></th><th>Player name</th><th>Value rating</th><th>Ladder ranking</th><th>Team ranking</th></tr>");

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

                if (currentPlayer.teamName === "Misfits") {
                    $("#playerList").append("<tr><th scope='row'>" + playerNumber + " <td><img id='avatarResize' src=" + playerAvatar + "></td><td>" + playerName + "</td><td> " + valueRating + "</td><td>" + ladderRanking + "</td><td>" + teamName + "</td></th></tr>");
                    playerCount++;
                }

            }
        } else if (value === "rogue") {
            $('#playerList').append("<tr id='tableHead'><th>#</th><th></th><th>Player name</th><th>Value rating</th><th>Ladder ranking</th><th>Team ranking</th></tr>");

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

                if (currentPlayer.teamName === "Rogue") {
                    $("#playerList").append("<tr><th scope='row'>" + playerNumber + " <td><img id='avatarResize' src=" + playerAvatar + "></td><td>" + playerName + "</td><td> " + valueRating + "</td><td>" + ladderRanking + "</td><td>" + teamName + "</td></th></tr>");
                    playerCount++;
                }

            }
        }
    }

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
                var winrate = currentPlayer.rating.us.stats.competitive.overall_stats.win_rate;
                var wins = currentPlayer.rating.us.stats.competitive.overall_stats.wins;
                var losses = currentPlayer.rating.us.stats.competitive.overall_stats.losses;
                var games = currentPlayer.rating.us.stats.competitive.overall_stats.games;

                $('#playerList').append("<tr><th scope='row'>" + playerNumber + " <td><img id='avatarResize' src=" + playerAvatar + "></td><td>" + playerName + "</td><td> " + winrate + "</td><td>" + wins + "</td><td>" + losses + "</td><td>" + games + "</td><td>" + teamName + "</td></th></tr>");

                playerCount++;

            }


        }

    }

    function getWinrateChart(winRate) {

        var winRate = winRate;
        var counterRate = 100 - winRate;
        alert(counterRate);
//        var data1 = 'Win %';
//        var data2 = 'Loss %';

        var wrChart = c3.generate({

            bindto: '#graphBoard',
            data: {
                columns: [
                    ['data1', winRate],
                    ['data2', counterRate]
                ],
                type: 'donut',
                onclick: function (d, i) {
                    console.log("onclick", d, i);
                },
                onmouseover: function (d, i) {
                    console.log("onmouseover", d, i);
                },
                onmouseout: function (d, i) {
                    console.log("onmouseout", d, i);
                }
            },
            colors: {
                data1: '#4fb70e',
                data2: '#b70e1f'

            },
            donut: {
                title: "Competitive winrate"
            }
        });

    }



    $("#statsId").change(function () {


        sessionStorage.statsId = $("#statsId option:selected").val();
        appendLadder();


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


    $(window).load(function () {
        appendHeroes("1");


    });

    $("#heroesId").change(function () {
        var value = $("#heroesId option:selected").val();

        appendHeroes(value);


    });
    $("#teamsid").change(function () {
        var value = $("#teamsid option:selected").val();
        
        $.ajax({
            url: "/allTeams",
            async: false,
            error: function () {
                alert('Failed to load');

            }


        }).then(function (data) {
              appendTeams(data,value);
            
            
        });

      


    });

    function appendHeroes(value) {
        $.ajax({
            url: "/allHeroes?id=" + value,
            error: function () {
                alert('Failed to load');

            }


        }).then(function (data) {


            var heroImage1 = new Array();
            heroImage1[0] = "https://blzgdapipro-a.akamaihd.net/hero/symmetra/icon-portrait.png";
            heroImage1[1] = "https://blzgdapipro-a.akamaihd.net/hero/pharah/icon-portrait.png";
            heroImage1[2] = "https://blzgdapipro-a.akamaihd.net/hero/mccree/icon-portrait.png";
            heroImage1[3] = "https://blzgdapipro-a.akamaihd.net/hero/sombra/icon-portrait.png";
            heroImage1[4] = "https://blzgdapipro-a.akamaihd.net/hero/tracer/icon-portrait.png";
            heroImage1[5] = "https://blzgdapipro-a.akamaihd.net/hero/ana/icon-portrait.png";
            heroImage1[6] = "https://blzgdapipro-a.akamaihd.net/hero/bastion/icon-portrait.png";
            heroImage1[7] = "https://blzgdapipro-a.akamaihd.net/hero/dva/icon-portrait.png";
            heroImage1[8] = "https://blzgdapipro-a.akamaihd.net/hero/genji/icon-portrait.png";
            heroImage1[9] = "https://blzgdapipro-a.akamaihd.net/hero/hanzo/icon-portrait.png";
            heroImage1[10] = "https://blzgdapipro-a.akamaihd.net/hero/junkrat/icon-portrait.png";
            heroImage1[11] = "https://blzgdapipro-a.akamaihd.net/hero/mei/icon-portrait.png";
            heroImage1[12] = "https://blzgdapipro-a.akamaihd.net/hero/lucio/icon-portrait.png";
            heroImage1[13] = "https://blzgdapipro-a.akamaihd.net/hero/mercy/icon-portrait.png";
            heroImage1[14] = "https://blzgdapipro-a.akamaihd.net/hero/reaper/icon-portrait.png";
            heroImage1[15] = "https://blzgdapipro-a.akamaihd.net/hero/reinhardt/icon-portrait.png";
            heroImage1[16] = "https://blzgdapipro-a.akamaihd.net/hero/roadhog/icon-portrait.png";
            heroImage1[17] = "https://blzgdapipro-a.akamaihd.net/hero/symmetra/icon-portrait.png";
            heroImage1[18] = "https://blzgdapipro-a.akamaihd.net/hero/soldier-76/icon-portrait.png";
            heroImage1[19] = "https://blzgdapipro-a.akamaihd.net/hero/torbjorn/icon-portrait.png";
            heroImage1[20] = "https://blzgdapipro-a.akamaihd.net/hero/widowmaker/icon-portrait.png";
            heroImage1[21] = "https://blzgdapipro-a.akamaihd.net/hero/winston/icon-portrait.png";
            heroImage1[22] = "https://blzgdapipro-a.akamaihd.net/hero/zarya/icon-portrait.png";
            heroImage1[23] = "https://blzgdapipro-a.akamaihd.net/hero/zenyatta/icon-portrait.png";


            var playerCount = 0;
            var currentPlayer = data[playerCount];
            $("#heroes").empty();
            $('#heroes').append("<tr id='tableHead'><th>#</th><th></th><th>Hero</th><th>Winrate</th><th>Wins</th><th>Losses</th><th>Games</th><th>Damage avr</th><th>Eliminations avr</th><th>Total medals</th><th>Medals per/10</th></tr>");
            while (currentPlayer !== null) {





                var currentPlayer = data[playerCount];
                var heroId = currentPlayer.id;
                var currentPic = heroImage1[heroId];
                var name = currentPlayer.name;
                var wr = currentPlayer.winRate;
                var gw = currentPlayer.games_won;
                var lw = currentPlayer.games_lost;
                var total = lw + gw;
                var dmga = currentPlayer.damage_done_average;
                var elia = currentPlayer.eliminations_average;
                var m10 = currentPlayer.medalsPerTen;
                var medals = currentPlayer.medals;
                var playerNumber = playerCount + 1;

                $('#heroes').append("<tr><th scope='row'>" + playerNumber + "<td><img id='avatarResize' src=" + currentPic + "></td><td>" + name + "</td><td>" + wr + "</td><td> "
                        + gw + "</td><td>" + lw + "</td><td>" + total + "</td><td>" + dmga + "</td><td>" + elia + "</td><td>" + medals + "</td><td>" + m10 + "</td></th></tr>");
                playerCount++;
                currentPlayer = data[playerCount];


            }






        });


    }

});
