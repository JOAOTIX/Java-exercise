<%-- 
    Document   : registro
    Created on : 12 mar. 2025, 12:59:49
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de registro</title>
    </head>
    <body>
        <%@page import="hola.EscribeArchivo,clases.Alumno"%>
        <%
            String name = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String promedio = request.getParameter("promedio");

            Alumno alu1 = new Alumno(name, apellidos, Double.parseDouble(promedio));

            ServletContext sc = this.getServletContext();
            String path = sc.getRealPath("/WEB-INF/Promedios.txt");
            path = path.replace('\\', '/');

            

            EscribeArchivo.add(alu1, path);
        %>
        <h1>Tu registro se hizo con éxito</h1>
        <form action="ejem-7.jsp" method="post">
            <input type="submit" value="Nuevo registro">
        </form>
    </body>
</html>
