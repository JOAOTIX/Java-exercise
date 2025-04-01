<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Agregar Producto</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-light d-flex justify-content-center align-items-center vh-100">
        <div class="card shadow-lg p-4" style="width: 400px;">
            <div class="card-body">
                <h3 class="text-center mb-4">Agregar Producto</h3>
                <form action="Registrar" method="POST">
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Nombre del producto</label>
                        <input type="text" id="nombre" name="nombre" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="stock" class="form-label">Stock</label>
                        <input type="number" id="stock" name="stock" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="pcompra" class="form-label">Precio de compra</label>
                        <input type="number" step="0.01" id="pcompra" name="pcompra" class="form-control" required>
                    </div>
                    <div class="mb-3">
                        <label for="pventa" class="form-label">Precio de venta</label>
                        <input type="number" step="0.01" id="pventa" name="pventa" class="form-control" required>
                    </div>
                    <button type="submit" class="btn btn-primary w-100">Agregar Producto</button>
                </form>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
