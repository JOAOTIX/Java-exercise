<%-- 
    Document   : ejem-5
    Created on : 12 mar. 2025, 12:05:32
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitud</title>
    </head>
    <body>
        <h1>Solicitud</h1>
        <h2>Despues de introducir tus datos oprime el botón "enviar"</h2>
        <form action="solicitud.jsp"  method="post">
            <table border="1" cellspacing="3" cellpadding="2">
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre"></td>
                </tr>
                <tr>
                    <td>Apellido:</td>
                    <td><input type="text" name="apellido"></td>
                </tr>
                <tr>
                    <td>Correo:</td>
                    <td><input type="email" name="correo"></td>
                </tr>
            </table>
            <p>Eres:  
                <input type="radio"  name="genero" value="Hombre" checked>Hombre
                <input type="radio"  name="genero" value="Mujer" >Mujer
            </p>
            
            <p>Selecciona lo que sabes:
                <input type="checkbox"  name="java" value="java">Java
                <input type="checkbox"  name="c" value="c">C/C++ 
                <input type="checkbox"  name="basic" value="basic">Basic
                <input type="checkbox"  name="html" value="html">HTML
            </p>
            <p>Selecciona los idiomas que comprendes: <br>
                (ctrl+clic para elegir varias opciones)
                <select name="lenguajes" multiple>
                    <option selected>Español</option>
                    <option >Ingles</option>
                    <option >Frances</option>
                    <option >Aleman</option>
                    <option >Japones</option>
                </select>
            <p>Comentarios adicionales:</p>
            <textarea name="area1" rows="4" cols="60"></textarea>
        </p>
        <input type="reset" value="Borrar">
        <input type="submit" value="Enviar">
    </form>
</body>
</html>
