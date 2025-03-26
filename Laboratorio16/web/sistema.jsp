<%-- 
    Document   : sistema
    Created on : 22 mar. 2025, 9:10:45 a. m.
    Author     : Deku
--%>

<%@page import="java.util.List"%>
<%@page import="clases.GestorBD"%>
<%@page import="clases.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String user=request.getParameter("usuario");
        List<Producto> listaProductos=(List<Producto>) request.getAttribute("productos");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido <%= user %></title>
    </head>
    <body>
        <h1>Sistema de almacen</h1>
        <table border="1">
            <tr>
                <th>Id del producto</th>
                <th>Nombre del producto</th>
                <th>Stock</th>
                <th>Precio de venta</th>
            </tr>
            <%
                for(Producto producto: listaProductos){
            %>
            <tr>
                <td><%= producto.getCode() %></td>
                <td><%= producto.getNombre() %></td>
                <td><%= producto.getStock() %></td>
                <td><%= producto.getPventa() %></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
