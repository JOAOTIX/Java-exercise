<%@page import="java.util.List"%>
<%@page import="clases.Zapatillas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <%
        String user = request.getParameter("user");
        user = (user == null || user.isEmpty()) ? "Invitado" : user;

        List<Zapatillas> listZapatillas = (List<Zapatillas>) request.getAttribute("zapatillas");
    %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bienvenido <%= user %></title>
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <!-- Navbar -->
    <nav class="navbar navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="#">Gestión de Zapatillas</a>
            <span class="navbar-text text-white">Bienvenido, <%= user %></span>
        </div>
    </nav>

    <div class="container mt-4">
        <h2 class="text-center">Lista de Zapatillas</h2>
        
        <div class="text-end mb-3">
            <a href="Agregar.jsp" class="btn btn-success">Agregar Producto</a>
        </div>

        <div class="table-responsive">
            <table class="table table-striped table-bordered">
                <thead class="table-dark text-center">
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Marca</th>
                        <th>Talla</th>
                        <th>Stock</th>
                        <th>Precio Venta</th>
                        <th>Precio Costo</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <% if (listZapatillas != null && !listZapatillas.isEmpty()) { 
                        for (Zapatillas zap : listZapatillas) { %>
                            <tr class="text-center align-middle">
                                <td><%= zap.getId() %></td>
                                <td><%= zap.getName() %></td>
                                <td><%= zap.getMarca() %></td>
                                <td><%= zap.getTalla() %></td>
                                <td><%= zap.getStock() %></td>
                                <td>S/. <%= zap.getPventa() %></td>
                                <td>S/. <%= zap.getPcosto() %></td>
                                <td>
                                    <a href="Editar.jsp?codigo=<%=zap.getId()%>&nombre=<%=zap.getName()%>&marca=<%=zap.getMarca()%>&stock=<%=zap.getStock()%>&talla=<%=zap.getTalla()%>&pventa=<%=zap.getPventa()%>&pcompra=<%=zap.getPcosto()%>"
                                       class="btn btn-warning btn-sm">Editar</a>
                                    <a href="Eliminar?codigo=<%= zap.getId() %>" 
                                       class="btn btn-danger btn-sm"
                                       onclick="return confirm('¿Estás seguro de eliminar este producto?');">
                                       Eliminar</a>
                                </td>
                            </tr>
                    <% } } else { %>
                        <tr>
                            <td colspan="8" class="text-center">No hay zapatillas registradas.</td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
