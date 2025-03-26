<%-- 
    Document   : inicio
    Created on : 22 mar. 2025, 10:50:19 a. m.
    Author     : Deku
--%>

<%@page import="java.util.List"%>
<%@page import="clases.Zapatillas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            String user=request.getParameter("user");
            
            List<Zapatillas> listZapatillas=(List<Zapatillas>) request.getAttribute("zapatillas");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido <%=  user %></title>
    </head>
    <body>
        <h1>Bienvenido al sistema de gestión de zapatillas</h1>
        
        <table border="1">
            <thead>
                <tr>
                    <th>ID de las zapatillas</th>
                    <th>Nombre de la zapatilla</th>
                    <th>Marca</th>
                    <th>Talla</th>
                    <th>Stock</th>
                    <th>Precio de Venta</th>
                    <th>Precio de Costo</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for(Zapatillas zap: listZapatillas){
                %>
                <tr>
                    <td> <%= zap.getId() %></td>
                    <td> <%= zap.getName() %></td>
                    <td> <%= zap.getMarca() %></td>
                    <td> <%= zap.getTalla() %></td>
                    <td> <%= zap.getStock() %></td>
                    <td> <%= zap.getPventa() %></td>
                    <td> <%= zap.getPcosto() %></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>

    </body>
</html>
