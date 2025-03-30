<%@page import="DAO.PizzaDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Pizza"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Realizar Pedido</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
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
                        <li class="nav-item"><a class="nav-link " href="pedidos.jsp">Pedidos</a></li>
                        <li class="nav-item"><a class="btn btn-light" href="index.jsp">Cerrar sesión</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Contenido -->
        <div class="container mt-4">
            <%
                PizzaDAO pizzadao = new PizzaDAO();
                List<Pizza> pizzas = pizzadao.ConsultarPizzas();
                String user = (String) session.getAttribute("user") != null ? (String) session.getAttribute("user") : "admi";

            %>
            <h2 class="text-center text-danger">🍕 Realizar Pedido</h2>
            <p class="text-center">Bienvenido, <strong><%= user%></strong></p>

            <div class="card shadow p-4">
                <form action="OrdenesServlet" method="post">
                    <div class="mb-3">
                        <label class="form-label">Nombres del Cliente:</label>
                        <input type="text" name="nombre" class="form-control" placeholder="Ingrese su nombre" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Apellidos del Cliente:</label>
                        <input type="text" name="apellido" class="form-control" placeholder="Ingrese su apellido" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">DNI del Cliente:</label>
                        <input type="number" name="dni" class="form-control" placeholder="Ingrese su DNI" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Pizza:</label>
                        <select name="pizzaId" class="form-select" required>
                            <% for (Pizza pizza : pizzas) {%>
                            <option value="<%= pizza.getId()%>&<%= pizza.getPrecio()%>">
                                <%= pizza.getNombre()%> - S/<%= pizza.getPrecio()%>
                            </option>
                            <% }%>
                        </select>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Cantidad:</label>
                        <input type="number" name="cantidad" class="form-control" placeholder="Ingrese la cantidad" min="1" required>
                    </div>

                    <button type="submit" class="btn btn-danger w-100">
                        <i class="fas fa-shopping-cart"></i> Registrar Pedido
                    </button>
                </form>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>

    </body>
</html>
