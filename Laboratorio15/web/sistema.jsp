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
         <%
            String a=request.getParameter("user");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido <%= a %> </title>
    </head>
    <body>
       
        <h1>INICIO</h1>
        <p>Bienvenido <%=a%> </p>
    </body>
</html>
