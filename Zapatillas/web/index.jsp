<%-- 
    Document   : index
    Created on : 22 mar. 2025, 10:50:14 a. m.
    Author     : Deku
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Bienvenido al sistema de zapatillas</h1>
        <form action="Validar" method="post">
            <table border="1">
                <tr>
                    <td>Ingresa tu usuario</td>
                    <td><input type="text" name="user"></td>
                </tr>
                <tr>
                    <td>Ingresa tu contraseña</td>
                    <td><input type="text" name="clave"></td>
                </tr>
            </table>
            <input type="reset" value="Borrar">
            <input type="submit" value="Ingresar">
        </form>
    </body>
</html>
