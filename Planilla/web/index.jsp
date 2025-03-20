<%-- 
    Document   : index
    Created on : 19 mar. 2025, 09:56:01
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
         <h1>Bienvenido al sistema de planilla de Senati</h1>
        <p>Ingresa los datos del empleado:</p>
        <form action="Procesar" method="post"> 
            <table cellspacing="3" cellpadding="3" > 
                <tr> 
                    <td>Nombre y apellidos:</td>
                    <td><input type="text" name="nombre"></td>
                    <td><input type="text" name="apellidos"></td>
                </tr> 
                <tr>
                    <td>Ingresa las horas trabajadas :</td>
                    <td><input type="text" name="horas"></td>
                </tr>
            </table> 
            <input type="reset" value="Borrar">
            <input type="submit" value="Calcular Salario"> 
        </form>
    </body>
</html>
