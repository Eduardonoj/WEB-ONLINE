<%-- 
    Document   : login
    Created on : 17/08/2019, 02:29:28 PM
    Author     : cmayen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <jsp:include page="menu.jsp"></jsp:include>
    <body>
        <div class="container">
            <div class="jumbotron mx-auto col-6">
                <h1 class="display-4 text-center">Login</h1>
                <br>
                <form method="post" action="ServletAutenticar.do">
                    <div class="form-group input-group flex-nowrap">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-primary text-light" id="addon-wrapping">Username</span>
                        </div>
                        <input name="username" type="text" class="form-control" placeholder="Write your Username" aria-label="Username" aria-describedby="addon-wrapping">
                    </div>
                    <br>
                    <div class="form-group input-group flex-nowrap">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-primary text-light" id="addon-wrapping">Password</span>
                        </div>
                        <input name="password" type="password" class="form-control" placeholder="Write your Password" aria-label="Username" aria-describedby="addon-wrapping">
                    </div>
                    <br>
                    <div class="text-center">
                        <button type="submit" class="btn btn-success btn-lg" >Login</button>
                    </div>
                </form>

            </div>
        </div>
        <script src="assets/js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
