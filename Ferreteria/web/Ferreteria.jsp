<%-- 
    Document   : Ferreteria
    Created on : 24 mar. 2025, 8:41:49 p. m.
    Author     : Deku
--%>

<%@page import="java.util.List"%>
<%@page import="clases.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            String user=request.getParameter("user");
            
            List<Producto> prod=(List<Producto>) request.getAttribute("productos");
            
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BIENVENIDO <%= user %></title>
    </head>
    <body>
        <h1>Bienvenido <%= user %> al sistema de gestión de la ferreteria SENATI</h1>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>NOMBRE</th>
                    <th>DESCRIPCION</th>
                    <th>STOCK</th>
                    <th>CATEGORIA</th>
                    <th>PRECIO DE VENTA</th>
                    <th>PRECIO DE COMPRA</th>
                </tr>
               
                    <%
                        for(Producto pro: prod){
                    %>
                    <tr>
                    <td><%= pro.getId() %></td>
                    <td><%= pro.getName() %></td>
                    <td><%= pro.getDescrip() %></td>
                    <td><%= pro.getStock() %></td>
                    <td><%= pro.getCategoria()%></td>
                    <td><%= pro.getPventa()%></td>
                    <td><%= pro.getPcompra() %></td>
                     </tr>
                   <%
                       }
                   %>
               
            </table>
    </body>
</html>
