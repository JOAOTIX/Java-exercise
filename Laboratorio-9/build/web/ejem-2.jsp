<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Captura con Radio-Button y CheckBox</title>
    </head>
    <body>
        <h1>Esta es la pagina de inicio</h1>
        <h2>Aqui se piden los datos</h2>
        <form action="destino.jsp" method="post">
            
            <p>Elige que transporte prefieres</p>
            <input type="radio"  name="transporte" value="Automovil" checked>Coche
            <input type="radio"  name="transporte" value="Avion" checked>Avión
            <input type="radio"  name="transporte" value="Autobus" checked>Autobus
            <p>¿Cuales son tus destinos favoritos?</p>
            <input type="checkbox" name="ciudad" value="Ciudad">Ciudad <br>
            <input type="checkbox" name="bosque" value="Bosque">Bosque <br>
            <input type="checkbox" name="playa" value="Playa">Playa <br>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
