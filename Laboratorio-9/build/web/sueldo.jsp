<%-- 
    Document   : sueldo
    Created on : 16 mar. 2025, 8:09:40 a. m.
    Author     : Deku
--%>

<%@page import="clases.Sueldo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <%
            String nombre = request.getParameter("nombre");
            String sueldo_dia = request.getParameter("sueldo_dia");
            String dias = request.getParameter("dias");
            
            
          
            
            Sueldo empleado1=new Sueldo(nombre,sueldo_dia,dias);
            
            empleado1.CalcularSueldo();
        %>
        <h1>Resultado</h1>
        <p>Hola <%=nombre%></p>

        <table border="1">

            <tr>
                <td>Tu sueldo total fue:</td>
                <td><%= empleado1.getSueldo_total() %> pesos</td>
            </tr>
            
        </table>
            <form action="ejem-8.jsp" method="post">
                <input type="submit" value="Regresar">
            </form>
    </body>
</html>
