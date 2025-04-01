<%@page import="java.util.List"%>
<%@page import="clases.GestorBD"%>
<%@page import="clases.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistema de Almacén</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-4">
        <h1 class="text-center">Bienvenido, <%= request.getParameter("usuario") %></h1>
        <div class="d-flex justify-content-between mb-3">
            <h3>Sistema de Almacén</h3>
            <a href="Agregar.jsp" class="btn btn-success">Agregar Producto</a>
        </div>
        <div class="table-responsive">
            <table class="table table-striped table-bordered">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Stock</th>
                        <th>Precio de Venta</th>
                        <th>Precio de Compra</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <% List<Producto> listaProductos = (List<Producto>) request.getAttribute("productos"); %>
                    <% for (Producto producto : listaProductos) { %>
                    <tr>
                        <td><%= producto.getCode() %></td>
                        <td><%= producto.getNombre() %></td>
                        <td><%= producto.getStock() %></td>
                        <td>S/ <%= producto.getPventa() %></td>
                        <td>S/ <%= producto.getPcompra() %></td>
                        <td>
                            <a href="Editar.jsp?codigo=<%= producto.getCode() %>&nombre=<%= producto.getNombre() %>&stock=<%= producto.getStock() %>&pventa=<%= producto.getPventa() %>&pcompra=<%= producto.getPcompra() %>" class="btn btn-warning btn-sm">Editar</a>
                            <a href="Eliminar?codigo=<%= producto.getCode() %>" class="btn btn-danger btn-sm">Eliminar</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>