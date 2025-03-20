<%-- 
    Document   : index
    Created on : 19 mar. 2025, 09:30:40
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
        <h1>Bienvenido a la plataforma de notas de la UPN</h1>
        <p>Ingresa las notas para mostrar el promedio final:</p>
        <form action="Procesar" method="post"> 
            <table cellspacing="3" cellpadding="3" > 
                <tr> 
                    <td>Ingresa las nota de las practicas:</td>
                    <td><input type="text" name="practicas1"></td>
                    <td><input type="text" name="practicas2"></td>
                </tr> 
                <tr>
                    <td>Ingresa la notas de la evaluacion parcial:</td>
                    <td><input type="text" name="EP1"></td>
                </tr>
                <tr>
                    <td>Ingresa las notas de las evaluaciones final: </td>
                    <td><input type="text" name="EF1"></td>
                    <td><input type="text" name="EF2"></td>

                </tr>
                <tr>
                    <td>Ingresa las notas de los trabajos finales:</td>
                    <td><input type="text" name="trabajos1"></td>
                    <td><input type="text" name="trabajos2"></td>
                    <td><input type="text" name="trabajos3"></td>
                </tr>
            </table> 
            <input type="reset" value="Borrar">
            <input type="submit" value="Calcular promedio"> 
        </form>
    </body>
</html>
