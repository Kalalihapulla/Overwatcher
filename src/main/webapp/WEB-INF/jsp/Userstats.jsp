
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/c3/0.4.10/c3.min.css">  
        <script src="http://d3js.org/d3.v3.min.js" charset="utf-8"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/c3/0.4.10/c3.min.js"></script>

        <!--Javascript-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="script/jquery.min.js"></script>
        <script src="script/javascript.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <!--CSS-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link rel="stylesheet" type="text/css" href="CSS/Style.css">



        <title>Ladder statistics</title>
    </head>
    <body id="statsbody">


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
                        <li><a href="/usersearch">User statistics</a></li>
                      


                    </ul>
                    <p id="toRight">TeamLUL. tm</p>


                </div>
            </div>
        </nav>




        <div class="container">

            <div class="row">
                <div class="col-md-12" id="playerinfo" >   
                </div>

            </div>



            <div class="row">
                <div class="col-md-3" id="statsboarddetails">
                    <div id="graphBoard">

                    </div>
                </div>

                <div class="col-md-9" id="statsboarddetails4">
                    <div id="statsboard">


                        <div class="statscontent">
                            <table class="table" id="playerStats">
                                <thead id="ladderHead">
                                    <!--                  <tr>
                                                            <th>#</th>
                                                            <th>Name</th>
                                                            <th>Value rating</th>
                                                            <th>Ladder ranking</th>
                                                            <th>Team name</th>
                                                            <th>Player avatar</th>
                                                        </tr>-->
                                </thead>
                                <tbody id="ladderBody">

                                </tbody>
                            </table>


                        </div>

                    </div>
                </div>

                <div class="col-md-3" id="statsboarddetails2">
                    <div id="graphBoard2">

                    </div>


                </div>

                <div class="col-md-9" id="statsboarddetails">
                    <div id="graphBoard3">



                    </div>
                </div>

            </div>
        </div>

    </body>
</html>
