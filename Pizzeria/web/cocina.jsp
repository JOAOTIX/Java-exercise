<%@page import="DAO.OrdenesDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Ordenes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Pedidos Pagados</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <style>
            body {
                background-color: #f8f9fa;
                padding: 20px;
            }
            .table-container {
                max-width: 800px;
                margin: auto;
                background: white;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
            }
            .btn-cooked {
                background-color: #28a745;
                color: white;
                border-radius: 8px;
                padding: 6px 12px;
                text-decoration: none;
            }
            .btn-cooked:hover {
                background-color: #218838;
            }
        </style>
        <!-- Navbar -->

    </head>
    <body>
        <div class="table-container">
            <h2 class="text-center text-danger">🍕 Pedidos por Preparar</h2>
            <hr>

            <%
                OrdenesDAO ordenDAO = new OrdenesDAO();
                List<Ordenes> ordenesPagadas = ordenDAO.ConsultarOrdenesPagadas();
                if (ordenesPagadas == null || ordenesPagadas.isEmpty()) {
            %>
            <div class="alert alert-warning text-center" role="alert">
                🚨 No hay pedidos listos para cocinar.
            </div>
            <%
            } else {
            %>

            <table class="table table-striped table-hover">
                <thead class="table-danger">
                    <tr>
                        <th>Cliente</th>
                        <th>Pizza</th>
                        <th>Cantidad</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Ordenes orden : ordenesPagadas) {
                    %>
                    <tr>
                        <td><%= orden.getClienteNombre()%></td>
                        <td><%= orden.getPizzaNombre()%></td>
                        <td><%= orden.getCantidad()%></td>
                        <td>
                            <a href="Cocina?orden=<%= orden.getId_orden()%>" class="btn btn-cooked">Marcar como Cocinada</a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>

            <%
                }
            %>
            <div class="text-center mt-4">
                <a href="http://localhost:8080/Pizzeria/registrarPedido.jsp" class="btn btn-success ">Registrar Pedidos</a>
                <a href="http://localhost:8080/Pizzeria/pedidos.jsp" class="btn btn-info ">Ver Pedidos</a>
                <a href="http://localhost:8080/Pizzeria/MostrarBoletas" class="btn btn-warning "> Ver Boletas</a>
                <a href="http://localhost:8080/Pizzeria/cerrarCocina.jsp" class="btn btn-info ">Ir a Cerrar Cocina</a>
                <a href="http://localhost:8080/Pizzeria/index.jsp" class="btn btn-primary ">Cerrar Sesión</a>
            </div>
        </div>

    </body>
</html>