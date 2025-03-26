<%-- 
    Document   : index
    Created on : 22 mar. 2025, 9:10:40 a. m.
    Author     : Deku
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Ingreso al sistema:</h1>
        <form action="Validar" method="post">
            <table border="1">
                <tr>
                    <td>Usuario:</td>
                    <td><input type="text" name="usuario"></td>
                </tr>
                <tr>
                    <td>Contraseña:</td>
                    <td><input type="text" name="clave"></td>
                </tr>
            </table>
            <input type="reset" value="Borrar">
            <input type="submit" value="Ingresar">
        </form>
    </body>
</html>
