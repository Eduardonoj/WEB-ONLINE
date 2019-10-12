<%-- 
    Document   : index
    Created on : 17/08/2019, 02:01:43 PM
    Author     : cmayen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

    </head>
    <jsp:include page="menu.jsp"></jsp:include>
    <body>
        <div class="jumbotron">
            <h1 class="display-4">Bienvenido al portal de compras en linea!</h1>
            <h1>${token.accessToken}</h1>
            <p class="lead">Sistema de control de compras.</p>
            <hr class="my-4">
            <p>Puede iniciar el proceso de compras en cualquier momento.</p>
            <a class="btn btn-primary btn-lg" href="login.jsp" role="button">Login</a>
        </div>
        <script src="assets/js/app.js" type="text/javascript"></script>
        <script src="assets/js/jquery-3.4.1.min.js" type="text/javascript"></script>

    </body>
</html>
