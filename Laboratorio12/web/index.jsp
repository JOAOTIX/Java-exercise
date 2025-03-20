
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hola!! proporciona tus datos:</h1>
    <form action="Procesar" method="post"> 
        <table cellspacing="3" cellpadding="3" border="1"> 
            <tr> <td>Nombre:</td>
                <td><input type="text" name="nombre"></td>
            </tr> 
            <tr> <td>Apellidos:</td>
                <td><input type="text" name="apellido"></td>
            </tr> 
            <tr> <td>Promedio:</td> 
                <td><input type="text" name="promedio"></td>
            </tr> 
        </table> 
        <input type="reset" value="Borrar">
        <input type="submit" value="Enviar"> 
    </form>
    </body>
</html>
