<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.5/d3.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/c3/0.4.10/c3.min.js"></script>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/c3/0.4.10/c3.min.css" rel="stylesheet"/>

        <!--Javascript-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="script/jquery.min.js"></script>
        <script src="script/javascript.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <!--CSS-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link rel="stylesheet" type="text/css" href="CSS/Style.css">


        <!--Fix scaling!!!-->

        <title>User search</title>
    </head>
    <body>

        <nav class="navbar navbar-default navbar-inverse" role="navigation">
            <div class="container-fluid">

                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/usersearch">OverWatcher</a>
                </div>


                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul id ="navFont" class="nav navbar-nav">
                        <li id="aboutTextScale"><a href="/about">About</a></li>
                        <li><a href="/usersearch">User statistics</a></li>
                        <li id="test"><a href="/ladderstats">Ladder statistics</a></li>
                        <li><a href="/heroes">Hero statistics</a></li>
                        <li><a href="/teamstats">Team statistics</a></li>



                    </ul>
                    <p id="toRight">TeamLUL. tm</p>


                </div>
            </div>
        </nav>






        <div id="searchbox">
            <!--            <h3 id="statHeader">Write a Battle.net username and ID</h3>-->
            <input id="searchboxtext1"type="text" name="search" placeholder="Battle.net Name" list="suggestions">
            <input id="searchboxtext2" type="text" name="search" placeholder="ID" list="suggestions2">

            <datalist id="suggestions">
                <option value="Taimou">
                <option value="Wormps">
            </datalist>

            <datalist id="suggestions2">
<!--                <option value="2526">
                <option value="2555">              -->
            </datalist>





            <select id="serverid">
                <option  value="eu">Europe</option>
                <option  value="na">North America</option>
                <option  value="kr">Korea</option>
            </select>

            <button id="searchbutton" type="button">Search</button>

            <img id="owlogo" src="contents/owlogo.png">
        </div>

    </body>
</html>
