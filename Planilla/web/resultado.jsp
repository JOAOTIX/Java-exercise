<%-- 
    Document   : resultado
    Created on : 19 mar. 2025, 10:21:39
    Author     : Alumno
--%>

<%@page import="clases.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Planilla</title>
    </head>
    <body>
        <%
            Empleado emp=(Empleado) request.getAttribute("sueldo");
        %>
        <h1>Datos del empleado:</h1>
        <p>Nombre: <%= emp.getNombre() %></p>
        <p>Apellidos: <%= emp.getApe() %></p>
        <p>Horas trabajadas: <%= emp.getHoras() %></p>
        <p>Precio por horas: <%= emp.getTh() %></p>
        <p>Sueldo bruto: <%= emp.sueldo_bruto() %></p>
        <p>Afp(10%): -<%= emp.aplica_afp()%></p>
        <p>Sueldo neto: <%= emp.sueldo_neto() %></p>
    </body>
</html>
