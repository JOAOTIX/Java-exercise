<%-- 
    Document   : resultado
    Created on : 19 mar. 2025, 09:31:22
    Author     : Alumno
--%>

<%@page import="clases.Alumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notas</title>
    </head>
    <body>
        <%
            Alumno au1=(Alumno) request.getAttribute("notas");
        %>
        <h1>El promedio final es:</h1>
        <p> <%= au1.PromedioFinal() %> </p>
    </body>
</html>
