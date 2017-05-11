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
                        <li><a href="/usersearch">User statistics</a></li>
                        <li><a href="/ladderstats">Ladder statistics</a></li>
                        <li><a href="/heroes">Hero statistics</a></li>


                    </ul>

                  
                </div>
            </div>
        </nav>

    <body>
        
        

        <div class="container" id="tablebg">
            <div class="col-md-4" id="statSelector">   
             <h3 id=statHeader>Select statistics to display: </h3> 
             <select id="statsId">
                <option  value="defStats">Default statistics</option>
                <option  value="offStats">Offensive statistics</option>
                <option  value="matStats">Match statistics</option>       
            </select>
            </div>
            
            <table class="table" id="playerList">
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

      

        
        
    </body>





</body>
</html>
