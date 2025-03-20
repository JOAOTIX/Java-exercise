<%-- 
    Document   : ejem-9
    Created on : 16 mar. 2025, 8:38:41 a. m.
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
        <h3>SOLUCIÓN UNA ECUACION DE 2° GRADO</h3>
        <table border="1">
            <td>Propocionar los coeficientes de la ec. de segundo grado de la forma:</td>
            <tr>
                <td>
                    <img src="Ecuacion1.png" width="170" height="170"  alt="Imagen uno"/>
                </td>
            </tr>
            <td>La solución se obtiene con la formula:</td>
            <tr>
                <td><img src="Ecuacion2.png" width="170" height="170"  alt="Imagen dos"/></td>
            </tr>
        </table>
        <form action="ecuacion.jsp" method="post">
            <table>
                <tr>
                    <td>a:</td>
                    <td><input type="text" name="VarA"></td>
                </tr>
                <tr>
                    <td>b:</td>
                    <td><input type="text" name="VarB"></td>
                </tr>
                <tr>
                    <td>c:</td>
                    <td><input type="text" name="VarC"></td>
                </tr>
                <tr>
                <input type="reset" value="Borrar">
                <input type="submit" value="Resolver">    
                </tr>
            </table>
        </form>
    </body>
</html>
