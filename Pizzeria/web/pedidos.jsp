<%@page import="DAO.OrdenesDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Ordenes"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Pedidos Registrados</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    </head>
    <body>

        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-danger">
            <div class="container">
                <a class="navbar-brand" href="registrarPedido.jsp">🍕 Pizzería</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item"><a class="nav-link" href="MostrarBoletas">Boletas</a></li>
                        <li class="nav-item"><a class="nav-link" href="cocina.jsp">Cocina</a></li>
                        <li class="nav-item"><a class="nav-link" href="registrarPedido.jsp">Registrar Pedido</a></li>
                        <li class="nav-item"><a class="btn btn-light" href="index.jsp">Cerrar sesión</a></li>

                    </ul>
                </div>
            </div>
        </nav>

        <!-- Contenido -->
        <div class="container mt-4">
            <h2 class="text-center text-danger">📋 Lista de Pedidos</h2>

            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <thead class="table-danger">
                        <tr>
                            <th>Cliente</th>
                            <th>Pizza</th>
                            <th>Cantidad</th>
                            <th>Generar Boleta</th>
                            <th>Generar Factura</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            OrdenesDAO ordenDAO = new OrdenesDAO();
                            List<Ordenes> ordenes = ordenDAO.ConsultarOrdenes();
                            if (ordenes != null && !ordenes.isEmpty()) {
                                for (Ordenes orden : ordenes) {
                        %>
                        <tr>
                            <td><%= orden.getClienteNombre()%></td>
                            <td><%= orden.getPizzaNombre()%></td>
                            <td><%= orden.getCantidad()%></td>
                            <td>
                                <form action="PagarOrden" method="post">
                                    <input type="hidden" name="orden" value="<%= orden.getId_orden()%>">
                                    <input type="hidden" name="tipo" value="B001">
                                    <button type="submit" class="btn btn-primary btn-sm">
                                        <i class="fas fa-credit-card"></i> Generar Boleta
                                    </button>
                                </form>
                            </td>
                            <td>
                                <form action="PagarOrden" method="post">
                                    <input type="hidden" name="orden" value="<%= orden.getId_orden()%>">
                                    <input type="hidden" name="tipo" value="F001">
                                    <button type="submit" class="btn btn-info btn-sm">
                                        <i class="fas fa-credit-card"></i> Generar Factura
                                    </button>
                                </form>
                            </td>


                        </tr>
                        <%
                            }
                        } else {
                        %>
                        <tr>
                            <td colspan="4" class="text-center text-muted">No hay pedidos registrados.</td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
