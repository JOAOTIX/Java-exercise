<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <%
            String cod= request.getParameter("codigo");
            String name= request.getParameter("nombre");
            String stock= request.getParameter("stock");
            String pventa= request.getParameter("pventa");
            String pcompra= request.getParameter("pcompra");
        %>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Editar Producto</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-light d-flex justify-content-center align-items-center vh-100">
        <div class="card shadow-lg p-4" style="width: 400px;">
            <div class="card-body">
                <h3 class="text-center mb-4">Editar Producto</h3>
                <form action="Editar" method="POST">
                    <div class="mb-3">
                        <label for="codigo" class="form-label">Código del producto</label>
                        <input type="text" id="codigo" name="codigo" class="form-control" value="<%=cod%>" readonly>
                    </div>
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Nombre del producto</label>
                        <input type="text" id="nombre" name="nombre" class="form-control" value="<%=name%>" required>
                    </div>
                    <div class="mb-3">
                        <label for="stock" class="form-label">Stock</label>
                        <input type="number" id="stock" name="stock" class="form-control" value="<%=stock%>" required>
                    </div>
                    <div class="mb-3">
                        <label for="pcompra" class="form-label">Precio de compra</label>
                        <input type="number" step="0.01" id="pcompra" name="pcompra" class="form-control" value="<%=pcompra%>" required>
                    </div>
                    <div class="mb-3">
                        <label for="pventa" class="form-label">Precio de venta</label>
                        <input type="number" step="0.01" id="pventa" name="pventa" class="form-control" value="<%=pventa%>" required>
                    </div>
                    <button type="submit" class="btn btn-primary w-100">Guardar Cambios</button>
                </form>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
