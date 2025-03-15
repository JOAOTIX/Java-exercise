<%-- 
    Document   : velocidad
    Created on : 12 mar. 2025, 12:42:34
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
        <%@page import="clases.Calcula" %>
        <%
            String name=request.getParameter("nombre");
            String tInicial=request.getParameter("tiempoi");
            String tFinal=request.getParameter("tiempof");
            String dist=request.getParameter("distancia");
            Double vel,tiempo;
            
            Calcula cal=new Calcula(tInicial,tFinal,dist);
            cal.velocidad();
            vel=cal.getVel();
            cal.tiempoTotal();
            tiempo=cal.gettTotal();
        %>
        <h1>Resultado</h1>
        <p>Hola <%= name%></p>
        
        <table border="1">
            <tr>
                <td>Tu tiempo total fue:</td>
                <td><%=tiempo%> minutos.</td>
            </tr>
            <tr>
                <td>Y tu velocidad fue:</td>
                <td><%= vel%> metros/min.</td>
            </tr>
        </table>
            <form action="ejem-6.jsp" method="post">
                <input type="submit" value="Regresar">
            </form>
    </body>
</html>
