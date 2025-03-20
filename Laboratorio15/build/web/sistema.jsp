<%-- 
    Document   : login
    Created on : 19 mar. 2025, 13:18:00
    Author     : Alumno
--%>

<%@page import="clases.GestorBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%
            String a=request.getParameter("user");
        %>
        <h1>INICIO</h1>
        <p>Bienvenido <%=a%> </p>
    </body>
</html>
