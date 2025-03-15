
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Area de Texto</title>
    </head>
    <body>
        <h1>Area de texto</h1>
        <p>Se puede desplegar el texto por default</p>
        <form action="textarea.jsp" method="post">
        <textarea name="area1" rows="3" cols="30">
            Lorem Ipsum is simply dummy text of the 
            printing and typesetting industry. Lorem Ipsum has been 
            the industry's standard dummy text ever since the 1500s, when 
an unknown printer took a galley of type and scrambled it to make
 a type specimen book. It has survived not only five centuries, but
 also the leap into electronic typesetting, remaining essentially unchanged. 
It was popularised in the 1960s with the release of Letraset sheets containing 
Lorem Ipsum passages, and more recently with desktop publishing software 
like Aldus PageMaker including versions of Lorem Ipsum
        </textarea>
        <p>O puede ser un area en blanco para capturar texto</p>
        <textarea name="area2" rows="4" cols="60"></textarea>
        <input type="submit" value="Enviar">
        </form>
    </body>
</html>
