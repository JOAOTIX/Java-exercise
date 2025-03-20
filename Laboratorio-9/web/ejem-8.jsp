<%-- 
    Document   : ejem-8
    Created on : 16 mar. 2025, 7:54:21 a. m.
    Author     : Deku
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejem-8</title>
    </head>
    <body>
        <h1>Página de inicio</h1>
        <p>Hola, por favor introduce la información</p>

        <form action="sueldo.jsp" method="post">
            <table border="1">
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre"></td>
                </tr>
                <tr>
                    <td>Sueldo por día:</td>
                    <td><input type="number" name="sueldo_dia"></td>
                </tr>
                <tr>
                    <td>Dias trabajados:</td>
                    <td><input type="number" name="dias"></td>
                </tr>
                
            </table>
            <input type="submit" value="Calular Sueldo">
        </form>
    </body>
</html>
