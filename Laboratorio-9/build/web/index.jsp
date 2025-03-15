<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Texto y botones</title>
    </head>
    <body>
        <h1>Ejemplos de campos de texto y botones</h1>
        <p>Campo fuera del formulario: <input type="text" name="C" value="Datos del Campo"></p>
        <p>Despues de introducir su datos oprima el botom "ok"</p>
        <form action="paginaDestino.jsp">
            <p> 
                Nombre:<input type="text" name="Nombre" <br>
                Apellido1:<input type="text" name="apell1" <br>
                Apellido2:<input type="text" name="apell2" <br>
                Telefono:<input type="text" name="tel" <br>
                <input type="reset" value="Borrar">
            </p>
            <input type="submit" value="ok">
        </form>
    </body>
</html>
