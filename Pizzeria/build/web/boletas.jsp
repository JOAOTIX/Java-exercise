<%@page import="java.util.List"%>
<%@page import="model.BoletaCompleta"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Boletas Generadas</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <style>
            body {
                background-color: #f8f9fa;
                padding: 20px;
            }
            .container {
                max-width: 1100px;
                margin: auto;
                background: white;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
            }
            .btn-close-caja {
                background-color: #dc3545;
                color: white;
                border-radius: 8px;
                padding: 10px 15px;
                text-decoration: none;
                width: 100%;
                font-weight: bold;
            }
            .btn-close-caja:hover {
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
            <h2 class="text-center text-primary">📜 Boletas Generadas</h2>
            <hr>

            <%
                List<BoletaCompleta> boletas = (List<BoletaCompleta>) request.getAttribute("boletas");
                if (boletas == null || boletas.isEmpty()) {
            %>
            <div class="alert alert-info text-center" role="alert">
                📝 No hay boletas generadas aún.
            </div>
            <%
            } else {
            %>

            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead class="table-primary">
                        <tr>
                            <th>Número de Boleta</th>
                            <th>Fecha/Hora</th>
                            <th>DNI Cliente</th>
                            <th>Cliente</th>
                            <th>Codigo producto</th>
                            <th>Producto</th>
                            <th>Cantidad</th>
                            <th>Precio Unitario</th>
                            <th>Importe</th>
                            <th>IGV 18%</th>
                            <th>Monto Total (S/.)</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (BoletaCompleta boleta : boletas) {
                        %>
                        <tr>
                            <td><%= boleta.getNumBol()%></td>
                            <td><%= boleta.getFecha()%></td>
                            <td><%= boleta.getDniCli()%></td>
                            <td><%= boleta.getClienteNombre()%></td>
                            <td><%= boleta.getCodProd()%></td>
                            <td><%= boleta.getProductoNombre()%></td>
                            <td><%= boleta.getCant()%></td>
                            <td><%= boleta.getPunt()%></td>
                            <td>S/. <%= String.format("%.2f", boleta.getImporte())%></td>
                            <td><%= boleta.getIgv()%></td>
                            <td><%= boleta.getTotal()%></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>

            <%
                }
            %>

            <form action="CerrarCaja" method="post" class="text-center mt-4">
                <button type="submit" class="btn btn-close-caja">Cerrar Caja 🔒 </button>
            </form>
            <div class="text-center mt-4">
                <a href="http://localhost:8080/Pizzeria/registrarPedido.jsp" class="btn btn-success ">Registrar Pedidos</a>
                <a href="http://localhost:8080/Pizzeria/pedidos.jsp" class="btn btn-info ">Ver Pedidos</a>
                <a href="http://localhost:8080/Pizzeria/cocina.jsp" class="btn btn-warning "> Ver Cocina</a>
                <a href="http://localhost:8080/Pizzeria/index.jsp" class="btn btn-primary ">Cerrar Sesión</a>
            </div>
        </div>

    </body>
</html>
