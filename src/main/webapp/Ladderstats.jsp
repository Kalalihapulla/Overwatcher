

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>s
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



        <!--Javascript-->
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
                    <a class="navbar-brand" href="Usersearch.jsp">Hanzonator 2.0</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="#">About</a></li>
                        <li><a href="#">Ladder statistics</a></li>

                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li><p class="navbar-text">Already have an account?</p></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b> <span class="caret"></span></a>
                            <ul id="login-dp" class="dropdown-menu">
                                <li>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
                                                <div class="form-group">
                                                    <label class="sr-only" for="exampleInputEmail2">Email address</label>
                                                    <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Email address" required>
                                                </div>
                                                <div class="form-group">
                                                    <label class="sr-only" for="exampleInputPassword2">Password</label>
                                                    <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password" required>

                                                </div>
                                                <div class="form-group">
                                                    <button type="submit" class="btn btn-primary btn-block">Sign in</button>
                                                </div>
                                                <div class="checkbox">
                                                    <label>
                                                        <input type="checkbox"> <b id="logincolor">keep me logged-in</b>
                                                    </label>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="bottom text-center" id="logincolor">
                                            New here ? <a href="#"><b>Join Us</b></a>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

    <body>

        <div class="container" id="tablebg">
            <table class="table">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Ranking</th>
                        <th>K/D average</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>Rob</td>
                        <td>1337</td>
                        <td>1.3</td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>Bob</td>
                        <td>1234</td>
                        <td>0.6</td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td>Rub</td>
                        <td>4200</td>
                        <td>1.8</td>
                    </tr>
                </tbody>
            </table>
        </div>


        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col col-lg-2">
                    1 of 3
                </div>
                <div class="col-12 col-md-auto">
                    Variable width content
                </div>
                <div class="col col-lg-2">
                    3 of 3
                </div>
            </div>
            <div class="row">
                <div class="col">
                    1 of 3
                </div>
                <div class="col-12 col-md-auto">
                    Variable width content
                </div>
                <div class="col col-lg-2">
                    3 of 3
                </div>
            </div>
        </div>
    </body>


</div>


</body>
</html>
