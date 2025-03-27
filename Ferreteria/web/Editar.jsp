<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <%
            String cod= request.getParameter("codigo");
            String name= request.getParameter("nombre");
            String desc= request.getParameter("desc");
            String stock= request.getParameter("stock");
            String cat= request.getParameter("cat");
            String pventa= request.getParameter("pventa");
            String pcompra= request.getParameter("pcompra");
        %>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Editar</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-light d-flex justify-content-center align-items-center vh-100">
       
        <div class="card shadow-lg p-4" style="width: 350px;">
            <div class="card-body text-center">
                <h3 class="card-title mb-4">Editar producto</h3>
                <form action="Editar" method="POST">
                    <div class="mb-3">
                        <label for="codigo" class="form-label">Nombre del producto</label>
                        <input type="text" id="codigo" name="codigo" class="form-control" value="<%= cod%>"  required> 
                    </div>
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Nombre del producto</label>
                        <input type="text" id="nombre" name="nombre" class="form-control" value="<%= name %>"  required> 
                    </div>
                    <div class="mb-3">
                        <label for="desc" class="form-label">Descripción</label>
                        <input type="text" id="desc" name="desc" class="form-control" value="<%= desc %>" required>
                    </div>
                    <div class="mb-3">
                        <label for="stock" class="form-label">Stock</label>
                        <input type="text" id="stock" name="stock" class="form-control" value="<%= stock %>" required>
                    </div>
                    <div class="mb-3">
                        <label for="cat" class="form-label">Categoría</label>
                        <input type="text" id="cat" name="cat" class="form-control" value=" <%= cat%> " required>
                    </div>
                    <div class="mb-3">
                        <label for="pventa" class="form-label">Precio de venta</label>
                        <input type="text" id="pventa" name="pventa" class="form-control"  value="<%= pventa %>"required>
                    </div>
                    <div class="mb-3">
                        <label for="pcompra" class="form-label">Precio de compra</label>
                        <input type="text" id="pcompra" name="pcompra" class="form-control" value="<%= pcompra %>" required>
                    </div>
                    <button type="submit" class="btn btn-primary w-100">Actualizar Producto</button>
                </form>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
