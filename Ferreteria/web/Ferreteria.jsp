<%@page import="java.util.List"%>
<%@page import="clases.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
    <head>

        <% List<Producto> prod = (List<Producto>) request.getAttribute("productos");%>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Bienvenido</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-light">
        <div class="container mt-5">
            <div class="d-flex justify-content-between align-items-center mb-4">
                <h1>Bienvenido</h1>
                <a href="Agregar.jsp" class="btn btn-success">Agregar producto</a>
            </div>

            <div class="table-responsive shadow-lg">
                <table class="table table-bordered table-hover">
                    <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Descripción</th>
                            <th>Stock</th>
                            <th>Categoría</th>
                            <th>Precio Venta</th>
                            <th>Precio Compra</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Producto pro : prod) {%>
                        <tr>
                            <td><%= pro.getId()%></td>
                            <td><%= pro.getName()%></td>
                            <td><%= pro.getDescrip()%></td>
                            <td><%= pro.getStock()%></td>
                            <td><%= pro.getCategoria()%></td>
                            <td><%= pro.getPventa()%></td>
                            <td><%= pro.getPcompra()%></td>
                            <td class="d-flex gap-2">
                                <a href="Editar.jsp?codigo=<%= pro.getId()%>&desc=<%=pro.getDescrip()%>&stock=<%=pro.getStock()%>&cat=<%=pro.getCategoria()%>&pventa=<%=pro.getPventa()%>&pcompra=<%=pro.getPcompra()%>&nombre=<%= pro.getName()%>"  class="btn btn-primary btn-sm"><img src="<%= request.getContextPath()%>/img/boligrafo.png" width="50px" height="50px " alt="Editar"/></a>
                                <a href="Eliminar?codigo=<%= pro.getId() %>" class="btn btn-danger btn-sm"><img src="<%= request.getContextPath()%>/img/goma-de-borrar.png" width="50px" height="50px" alt="Borrar"/></a>
                            </td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="container mt-5">
            <a href="index.jsp" class="btn btn-info"> Cerrar Sesión</a>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
