<%-- 
    Document   : muestraDolares
    Created on : 19 mar. 2025, 09:26:18
    Author     : Alumno
--%>

<%@page import="clases.Conversion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cambio realizado</title>
    </head>
    <body>
        <%
            Conversion con=(Conversion) request.getAttribute("conversion");
        %>
        <h1>Hola!! El cambio ha sido realizado con exito</h1>
        <p>Aqui puedes ver el monto total:</p>
        <table cellspacing="3" cellpadding="3" border="1"> 
            <tr> <td>El monto de soles ingresado:</td>
                <td><%= con.getSoles() %></td>
            </tr>
            <tr>
                <td>El monto de dolares obtenido:</td>
                <td> <%= con.Soles_a_Dolares() %></td>
            </tr>
        </table> 
        <form action="index.jsp" method="post">
            <input type="submit" value="Regresar"> 
        </form>
    </body>
</html>
