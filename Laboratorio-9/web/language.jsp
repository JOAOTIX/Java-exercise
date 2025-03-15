<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina destino JSP</title>
    </head>
    <body>
        <%
            String idioma = request.getParameter("idioma");
            String[] lenguaje = request.getParameterValues("lenguajes");
        %>
        <h1>Esta es la pagina destino</h1>
        <h2>Aqui se despliegan los datos que se recibieron</h2>

        <table>
            <tr>
                <td align="right">Tu idioma natal es: </td>
                <td><%= idioma%> </td>
            </tr>
        </table>
        <p>Manejas los siguientes lenguajes de programación: <br>
            <%
                for (int i = 0; i < lenguaje.length; i++) {
            %>
            <%= lenguaje[i]%>,
            <%}%>
        </p>
        <form action="ejem-3.jsp" method="post">
            <input type="submit" value="Regresar">
        </form>
    </body>
</html>
