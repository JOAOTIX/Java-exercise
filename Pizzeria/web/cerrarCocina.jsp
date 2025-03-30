<%@page import="DAO.OrdenesDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Ordenes"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Pedidos Cocinados</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <style>
            body {
                background-color: #f8f9fa;
                padding: 20px;
            }
            .container {
                max-width: 800px;
                margin: auto;
                background: white;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
            }
            .btn-close-kitchen {
                background-color: #dc3545;
                color: white;
                border-radius: 8px;
                padding: 10px 15px;
                text-decoration: none;
                width: 100%;
                font-weight: bold;
            }
            .btn-close-kitchen:hover {
                background-color: #c82333;
            }
            .btn-close-ticket {
                background-color: #48e;
                color: white;
                border-radius: 8px;
                padding: 10px 15px;
                text-decoration: none;
                width: 100%;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
      
        <div class="container">
            <h2 class="text-center text-success">Pedidos Cocinados ✅ </h2>
            <hr>

            <%
                OrdenesDAO ordenDAO = new OrdenesDAO();
                List<Ordenes> ordenes = ordenDAO.ConsultarOrdenesCocinadas();
                int totalPizza = 0;
                if (ordenes == null || ordenes.isEmpty()) {

            %>
            <div class="alert alert-info text-center" role="alert">
                🍕 No hay pedidos cocinados por el momento.
            </div>
            <%    } else {
            %>

            <table class="table table-striped table-hover">
                <thead class="table-success">
                    <tr>
                        <th>Cliente</th>
                        <th>Pizza</th>
                        <th>Cantidad</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Ordenes orden : ordenes) {
                            totalPizza += orden.getCantidad();
                    %>
                    <tr>
                        <td><%= orden.getClienteNombre()%></td>
                        <td><%= orden.getPizzaNombre()%></td>
                        <td><%= orden.getCantidad()%></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <div class="alert alert-success text-center" role="alert">
                🍕 Total de Pizzas Preparadas: <strong><%= totalPizza%></strong>
            </div>     
            <%
                }
            %>

            <form action="CerrarCocina" method="post" class="text-center mt-4">
                <button type="submit" class="btn btn-close-kitchen">Cerrar Cocina 🔒</button>
            </form>
             <div class="text-center mt-4">
                <a href="http://localhost:8080/Pizzeria/registrarPedido.jsp" class="btn btn-success ">Registrar Pedidos</a>
                 <a href="http://localhost:8080/Pizzeria/pedidos.jsp" class="btn btn-info ">Ver Pedidos</a>
                   <a href="http://localhost:8080/Pizzeria/MostrarBoletas" class="btn btn-warning "> Ver Boletas</a>
                   <a href="http://localhost:8080/Pizzeria/cocina.jsp" class="btn btn-info ">Ver Cocina</a>
                       <a href="http://localhost:8080/Pizzeria/index.jsp" class="btn btn-primary ">Cerrar Sesión</a>
            </div>

    </body>
</html>
