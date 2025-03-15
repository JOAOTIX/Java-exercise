
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina destino JSP</title>
    </head>
    <body>
        <%
            String transpor= request.getParameter("transporte");
            String ciudad= request.getParameter("ciudad");
            String bosque= request.getParameter("bosque");
            String playa= request.getParameter("playa");
        %>
        <h1>Esta es la pagna destino</h1>
        <h2>Aqui se despliegan los datos recibidos</h2>
        <table border="1" cellspacing="3" cellpadding="3">
            <td align="rigth">Tu transporte preferido es:</td>
            <td><%= transpor%></td>
        </table>
        <p>Elegiste los siguientes destino: <br> 
        <%if (ciudad !=null){%>
            ciudad,
         <%}%>
        <%if (bosque !=null){%>
            bosque,
         <%}%>
         <%if (playa !=null){%>
            playa,
         <%}%>
        </p>
        <form action="ejem-2.jsp" method="post">
            <input type="submit" value="Regresar">
        </form>
    </body>
</html>
