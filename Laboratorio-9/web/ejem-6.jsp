<%-- 
    Document   : ejem-6
    Created on : 12 mar. 2025, 12:42:13
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Esta es la página de inicio</title>
    </head>
    <body>
        <h1>Esta es la página de inicio</h1>
        <h2>Aqui se piden los datos</h2>
        
        <p>Hola, por favor introduce la información</p>
        
        <form action="velocidad.jsp" method="post">
            
            <table border="1">
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre"></td>
                </tr>
                <tr>
                    <td>Minuto inicial:</td>
                    <td><input type="text" name="tiempoi"></td>
                </tr>
                <tr>
                    <td>Minuto final:</td>
                    <td><input type="text" name="tiempof"></td>
                </tr>
                <tr>
                    <td>Distancia recorrida:</td>
                    <td><input type="text" name="distancia"></td>
                </tr>
            </table>
            <input type="reset" value="Borrar">
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
