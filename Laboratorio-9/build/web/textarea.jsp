<%-- 
    Document   : tetxarea
    Created on : 12 mar. 2025, 11:57:31
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Destino page</title>
    </head>
    <body>
        <%
            String areatext=request.getParameter("area1");
        %>
        <h1>Esta es la pagina destino</h1>
        <h2>Aqui se despliegan los datos que se recibieron</h2>

        <table cellspacing="3" cellpadding="3" border="1">
            <tr>
                <td align="right">El usuario escribio: </td>
                <td><%=areatext%> </td>
            </tr>
        </table>
        <form action="ejem-4.jsp" method="post">
            <input type="submit" value="Regresar">
        </form>
    </body>
</html>
