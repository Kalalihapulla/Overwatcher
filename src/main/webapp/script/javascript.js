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
           

            $.ajax({
                url: "/allPlayers",
                async: false,
                error: function () {
                    alert('User not found, try again');
                }


            }).then(function (data) {
                

                sessionStorage.ladderdata = JSON.stringify(data);


            });
        }



        function loadPlayer() {

          

            $.ajax({
                url: sessionStorage.searchurl,
                error: function () {
                    alert('User not found, try again');
                    window.location = "/usersearch";

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

                    }

                }


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

                var comp = userdata.stats.competitive;

                var cGames = comp.overall_stats.games;
                var cWins = comp.overall_stats.wins;
                var cLosses = comp.overall_stats.losses;
                var cTies = comp.overall_stats.ties;
                var cWinrate = comp.overall_stats.win_rate;
                var cRank = comp.overall_stats.comprank;

                var cOakills = comp.average_stats.objective_kills_avg;
                var cAdeaths = comp.average_stats.deaths_avg;
                var cAhealing = comp.average_stats.healing_done_avg;
                var cAotime = comp.average_stats.objective_time_avg;
                cAotime = cAotime.toFixed(5);
                var cAdamage = comp.average_stats.damage_done_avg;
                var cAelims = comp.average_stats.eliminations_avg;

                var cMdamage = comp.game_stats.damage_done_most_in_game;
                var cMelims = comp.game_stats.eliminations_most_in_game;
                var cMhealing = comp.game_stats.healing_done_most_in_game;
                var cTelims = comp.game_stats.eliminations;
                var cTdeaths = comp.game_stats.deaths;
                var cTplayed = comp.game_stats.time_played;



                var qPlay = userdata.stats.quickplay;

                var qGames = qPlay.overall_stats.games;
                var qWins = qPlay.overall_stats.wins;
                var qLosses = qPlay.overall_stats.losses;
                var qTies = qPlay.overall_stats.ties;
                var qWinrate = qPlay.overall_stats.win_rate;
                var qRank = "Unavailable";

                var qOakills = qPlay.average_stats.objective_kills_avg;
                var qAdeaths = qPlay.average_stats.deaths_avg;
                var qAhealing = qPlay.average_stats.healing_done_avg;
                var qAotime = qPlay.average_stats.objective_time_avg;
                qAotime = qAotime.toFixed(5);
                var qAdamage = qPlay.average_stats.damage_done_avg;
                var qAelims = qPlay.average_stats.eliminations_avg;

                var qMdamage = comp.game_stats.damage_done_most_in_game;
                var qMelims = comp.game_stats.eliminations_most_in_game;
                var qMhealing = comp.game_stats.healing_done_most_in_game;
                var qTelims = comp.game_stats.eliminations;
                var qTdeaths = comp.game_stats.deaths;
                var qTplayed = comp.game_stats.time_played;



                $('#playerStats').append("<tr id='tableHead'><th>-</th><th>games</th><th>wins</th><th>Losses</th><th>Ties</th><th>Winrate</th><th>Ladder ranking</th></tr>");
                $('#playerStats').append("<tr id='tRow'><th scope='row'>Competitive<td> " + cGames + "</td><td> " + cWins + "</td><td> " + cLosses + "</td><td> " + cTies + "</td><td> " + cWinrate + "</td><td> " + cRank + "</td></th></tr>");
                $('#playerStats').append("<tr id='tRow'><th scope='row'>Quickplay<td> " + qGames + "</td><td> " + qWins + "</td><td> " + qLosses + "</td><td> " + qTies + "</td><td> " + qWinrate + "</td><td> " + qRank + "</td></th></tr>");

                $('#playerStats').append("<tr id='tableHead'><th>-</th><th>Avg. Kills</th><th>Avg. Deaths</th><th>Avg. Healing</th><th>Avg. Objective time</th><th>Avg. Damage</th><th>Avg. Eliminations</th></tr>");
                $('#playerStats').append("<tr id='tRow'><th scope='row'>Competitive<td> " + cOakills + "</td><td> " + cAdeaths + "</td><td> " + cAhealing + "</td><td> " + cAotime + "</td><td> " + cAdamage + "</td><td> " + cAelims + "</td></th></tr>");
                $('#playerStats').append("<tr id='tRow'><th scope='row'>Quickplaye<td> " + qOakills + "</td><td> " + qAdeaths + "</td><td> " + qAhealing + "</td><td> " + qAotime + "</td><td> " + qAdamage + "</td><td> " + qAelims + "</td></th></tr>");

                $('#playerStats').append("<tr id='tableHead'><th>-</th><th>Most Dmg. done</th><th>Most eliminations</th><th>Most healing in a game</th><th>Total eliminations</th><th>Total deaths</th><th>Total time played</th></tr>");
                $('#playerStats').append("<tr id='tRow'><th scope='row'>Competitive<td> " + cMdamage + "</td><td> " + cMelims + "</td><td> " + cMhealing + "</td><td> " + cTelims + "</td><td> " + cTdeaths + "</td><td> " + cTplayed + "</td></th></tr>");
                $('#playerStats').append("<tr id='tRow'><th scope='row'>Quickplay<td> " + qMdamage + "</td><td> " + qMelims + "</td><td> " + qMhealing + "</td><td> " + qTelims + "</td><td> " + qTdeaths + "</td><td> " + qTplayed + "</td></th></tr>");

                getWinrateChart(compWinrate);
                getKdChart(cTelims, cTdeaths);
                getChart3(cMdamage, cAdamage, cMhealing, cAhealing);
            });

        }


    });


    function appendLadder() {

        var data = JSON.parse(sessionStorage.ladderdata);

        $("#playerList").empty();

        var playerCount = 0;

        var currentPlayer = 0;


        if (sessionStorage.statsId === "defStats") {
            //FIX table header...
            $('#playerList').append("<tr id='tableHead2'><th>#</th><th></th><th>Player name</th><th>Value rating</th><th>Ladder ranking</th><th>Team name</th></tr>");

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

            $('#playerList').append("<tr id='tableHead2'><th>#</th><th></th><th>Player name</th><th>Eliminations Avg.</th><th>Deaths Avg.</th><th>K/D ratio</th><th>Team name</th></tr>");
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

            $('#playerList').append("<tr id='tableHead2'><th>#</th><th></th><th>Player name</th><th>Winrate</th><th>Wins</th><th>Losses</th><th>Games</th><th>Team name</th></tr>");
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

//        var data1 = 'Win %';
//        var data2 = 'Loss %';

        var wrChart = c3.generate({

            bindto: '#graphBoard',
            data: {
                columns: [
                    ['Win %', winRate],
                    ['Loss %', counterRate]
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
            color: {
                pattern: ['#4fb70e', '#ff1414']
            },

            donut: {
                title: "Competitive winrate"
            }
        });

    }

    function getKdChart(eliminations, deaths) {

        var elims = eliminations;
        var deaths = deaths;
        var kda = elims / deaths;


//        var data1 = 'Win %';
//        var data2 = 'Loss %';

        var wrChar2t = c3.generate({

            bindto: '#graphBoard2',
            data: {
                columns: [
                    ['eliminations', elims],
                    ['deaths', deaths]
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
            color: {
                pattern: ['#1b68e5', '#f28d1a']
            },

            donut: {
                title: "Competitive KDR"
            }
        });

    }

    function getChart3(mDmg, aDmg, mHeal, aHeal) {
        
        var mDmg = mDmg;
        var aDmg = aDmg;
        var mHeal = mHeal;
        var aHeal = aHeal;

        var chart = c3.generate({
            bindto: '#graphBoard3',
            data: {
                columns: [
                  //  ['Most damage, Average damage, Most healing, Average healing', mDmg, aDmg, mHeal, aHeal]
                    ['Most Damage', mDmg],
                    ['Average damage', aDmg],
                    ['Most Healing', mHeal],
                    ['Average Healing', aHeal]
                ],
                type: 'bar'
            },
            bar: {
                title: {
                    text: 'Damage and healing comparison'
                },
                width: {

                    width: 2000
                }    

            },
            color: {
                pattern: ['#820000', '#ff1414', '#3b8202', '#53ff0a'] 
             
            },
            size: {
                height: 250
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
            $('#heroes').append("<tr id='tableHead2'><th>#</th><th></th><th>Hero</th><th>Winrate</th><th>Wins</th><th>Losses</th><th>Games</th><th>Damage avr</th><th>Eliminations avr</th><th>Total medals</th><th>Medals per/10</th></tr>");
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
