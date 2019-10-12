<%-- 
    Document   : tipoempaque
    Created on : 31/08/2019, 03:29:13 PM
    Author     : cmayen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tipo Empaque</title>
    </head>
    <jsp:include page="menu.jsp"></jsp:include>
        <body>
            <h1>Categorias</h1>
            <div class="card border-primary mb-3">
                <div class="card-header">
                    Categorias
                </div>
                <div class="card-body text-primary">
                    <h5 class="card-title">Listado de Tipo de Empaque</h5>
                    <div class="my-2 text-left">
                        <button class="btn btn-rounded btn-primary" type="button">Crear Tipo de Empaque</button>
                    </div>
                    <table class="table table-bordered table-striped">
                        <thead class="text-center">
                        <th>Codigo</th>                        
                        <th>Descripcion</th>
                        <th>Editar</th>
                        <th>Eliminar</th>
                        </thead>
                        <tbody id="datos" class="text-center">
                        <c:forEach items="${tiposempaque}" var="tipoempaque">
                            <tr>
                                <td>${tipoempaque.codigoEmpaque}</td>
                                <td>${tipoempaque.descripcion}</td>
                                <td><button class="btn btn-warning">Editar</button></td>
                                <td><button class="btn btn-danger">Eliminar</button></td>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </body>

</html>
