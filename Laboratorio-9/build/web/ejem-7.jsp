<%-- 
    Document   : ejem-7
    Created on : 12 mar. 2025, 12:59:40
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejem-7</title>
    </head>
    <body>
        <h1>Hola! Proporciona tus datos:</h1>
        <form action="registro.jsp" method="post">
            <table border="1">
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre"></td>
                </tr>
                <tr>
                    <td>Apellidos:</td>
                    <td><input type="text" name="apellidos"></td>
                </tr>
                <tr>
                    <td>Promedio:</td>
                    <td><input type="text" name="promedio"></td>
                </tr>
            </table>
            <input type="reset" value="Borrar">
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
