<%-- 
    Document   : index
    Created on : 19 mar. 2025, 09:17:22
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Casa de cambios</title>
    </head>
    <body>
        <h1>Bienvenido a la casa de cambios de dolares Senati</h1>
        <p>Ingresa el monto a cambiar:</p>
         <form action="ProcesarDolares" method="post"> 
        <table cellspacing="3" cellpadding="3" border="1"> 
            <tr> <td>Soles:</td>
                <td><input type="text" name="soles"></td>
            </tr> 
        </table> 
        <input type="reset" value="Borrar">
        <input type="submit" value="Convertir a dolares"> 
    </form>
    </body>
</html>
