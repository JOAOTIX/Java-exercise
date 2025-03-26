<%-- 
    Document   : index
    Created on : 24 mar. 2025, 8:41:36 p. m.
    Author     : Deku
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
    </head>
    <body>
        <h1>Bienvenido al sistema de gestión de la ferreteria SENATI</h1>
        <form action="Procesar" method="POST">
            <table border="1">               
                <tr>
                    <td>Ingresa tu usuario:</td>
                    <td><input type="text" name="user"></td>
                </tr>
                <tr>
                    <td>Ingresa tu contraseña:</td>
                    <td><input type="text" name="password"></td>
                </tr>
            </table>
            <input type="submit" value="Ingresar">
        </form>

    </body>
</html>
