<%-- 
    Document   : solicitud
    Created on : 12 mar. 2025, 12:22:00
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitud</title>
    </head>
    <body>
        <%
            String name = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String correo = request.getParameter("correo");
            String genero = request.getParameter("genero");
            String java = request.getParameter("java");
            String c = request.getParameter("c");
            String basic = request.getParameter("basic");
            String html = request.getParameter("html");
            String[] lenguaje = request.getParameterValues("lenguajes");
        %>
        <h1>Solicitud Recibida!</h1>
        <h2>Tus datos son:</h2>
        
        <table border="1" cellspacing="3" cellpadding="2">
            <tr>
                <td>Te llamas:</td>
                <td><%= name%></td>
            </tr>
            <tr>
                <td>Apellidos:</td>
                <td><%= apellido%></td>
            </tr>
            <tr>
                <td>Tu Correo es:</td>
                <td><%= correo%></td>
            </tr>
            <tr>
                <td>Tu Genero es:</td>
                <td><%= genero%></td>
            </tr>
        </table>
        <p>Manejas los siguientes lenguajes de programación:
            <br>
            <% if (java != null) {%>
            Java,
            <%}%>
            <% if (c != null) {%>
            C/C++,
            <%}%>
            <% if (basic != null) {%>
            Basic,
            <%}%>
            <% if (html != null) {%>
            Html,
            <%}%>
        </p>
        <p>Los idiomas que comprendes son:
            <br>
            <%
                for (int i = 0; i < lenguaje.length; i++) {
            %>
            <%= lenguaje[i]%>,
            <%}%>
        </p>
        <form action="ejem-5.jsp" method="post">
            <input type="submit" value="Regresar">
        </form>
    </body>
</html>
