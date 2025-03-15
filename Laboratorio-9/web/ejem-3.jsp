<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de opciones</title>
    </head>
    <body>
        <h1>Esta es la pagina de inicio</h1>
        <h2>Aqui se piden los datos</h2>

        <form action="language.jsp" method="post">
            <p>Idiona natal: <br>
                <select name="idioma">
                    <option selected>Spanish</option>
                    <option>English</option>
                    <option>Frances</option>
                    <option>Aleman</option>
                </select>
            </p>
            <p>Selecciona tu lenguaje de programación <br>
                (ctrl+clic para elegir varias opciones)
                <select name="lenguajes" multiple>
                    <option selected>Java</option>
                    <option >C/C++</option>
                    <option >Basic</option>
                    <option >Python</option>
                    <option >Pascal</option>
                </select>
            </p>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
