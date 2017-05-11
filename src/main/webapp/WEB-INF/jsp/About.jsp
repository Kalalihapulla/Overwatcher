<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.5/d3.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/c3/0.4.10/c3.min.js"></script>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/c3/0.4.10/c3.min.css" rel="stylesheet"/>


        <!--CSS-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="script/jquery.min.js"></script>
        <script src="script/javascript.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <!--CSS-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="CSS/Style.css">



        <title>Ladder statistics</title>
    </head>
    <body>

        <nav class="navbar navbar-default navbar-inverse" role="navigation">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/usersearch">OverWatcher</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul id ="navFont" class="nav navbar-nav">
                        <li id="aboutTextScale"><a href="/about">About</a></li>
                        <li><a href="/ladderstats">Ladder statistics</a></li>
                        <li><a href="/heroes">Hero statistics</a></li>
                    </ul>
                    <p id="toRight">TeamLUL. tm</p>

                </div>
            </div>
        </nav>

        <div id="aboutbox">
            <p style="font-size: 1.5em">Welcome to the TeamLUL Overwatch site!</p>

            <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis feugiat vulputate diam, et molestie ex dignissim pretium. Nunc sed sapien diam. Praesent imperdiet ut eros in hendrerit. Vivamus pellentesque mi lacinia turpis elementum interdum. Nam quis accumsan lacus. Aliquam vitae sem maximus, porttitor urna id, hendrerit arcu. Cras vehicula nulla in viverra dictum. Vivamus lectus mauris, venenatis quis ultrices et, accumsan id nunc. Fusce mollis at odio id imperdiet. Nam ac metus vitae nisl euismod vulputate nec sed mi. Duis sed ultricies ante. Sed et augue vel est volutpat mattis. Aliquam placerat massa non rhoncus tristique. Sed sit amet elit nisl. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nunc aliquam vehicula ipsum, sit amet dignissim neque eleifend vel.
            </p>
        </div>



    </body>
</html>
