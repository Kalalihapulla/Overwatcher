

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--CSS-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="CSS/Style.css">


        <!--Javascript-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="script/jquery.min.js"></script>
        <script src="script/javascript.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <!--Fix scaling!!!-->

        <title>User search</title>
    </head>
    <body>
        
    <div class="navbar navbar-inverse navbar-static-top" id="nav">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
      </div>
      <div class="collapse navbar-collapse">
      <div class="navbar-brand">Hanzonator 2.0</div>
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#">About</a></li>
        </ul>
      </div>
    </div>
</div>



        <div id="searchbox">         
            <input id="searchboxtext" type="text" name="search" placeholder="Search for Battle.net user">
            <input id="searchboxtext2" type="text" name="search" placeholder="Type in the Battle.net ID associated with the user">
            <button id="searchbutton" type="button">Search</button>
            <img id="owlogo" src="contents/owlogo.png">

        </div>
    </body>
</html>
