<%-- 
    Document   : muestraDatos
    Created on : 19 mar. 2025, 08:58:40
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@page import="negocios.Alumno" %>
        <%
            Alumno alu=(Alumno)request.getAttribute("atribAlumn");
        %>
        <h1>Aqui se muestran tus datos que se procesaron en el servlet</h1>
        <p>Se guardaron los siguientes datos:</p>
         <table cellspacing="3" cellpadding="3" border="1"> 
            <tr> <td>Nombre:</td>
                <td><%= alu.getName() %></td>
            </tr> 
            <tr> <td>Apellidos:</td>
                <td><%= alu.getApellidos() %></td>
            </tr> 
            <tr> <td>Promedio:</td> 
                <td><%= alu.getPromedio()%></td>
            </tr> 
        </table> 
        <form action="index.jsp" method="post">
            <input type="submit" value="Regresar">
        </form>
    </body>
</html>
