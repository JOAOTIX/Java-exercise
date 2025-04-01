<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Sistema de Zapatillas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-lg p-4" style="width: 350px;">
        <div class="card-body text-center">
            <h3 class="card-title mb-4">Bienvenido</h3>
            <p class="text-muted">Inicia sesión en el sistema</p>
            <form action="Validar" method="post">
                <div class="mb-3">
                    <label for="user" class="form-label">Usuario</label>
                    <input type="text" id="user" name="user" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="clave" class="form-label">Contraseña</label>
                    <input type="password" id="clave" name="clave" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-primary w-100">Ingresar</button>
            </form>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
