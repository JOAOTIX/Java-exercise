<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login - Pizzería</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <style>
        body {
            background-image: url('https://as1.ftcdn.net/jpg/03/40/92/94/1000_F_340929408_4KImJDAXZd08X4If13IZHIS3fRsSzN6u.jpg');
            background-size: cover;
            background-position: center;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
        .login-container {
            background: rgba(255, 255, 255, 0.95);
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.3);
            width: 350px;
            text-align: center;
        }
        .login-container h2 {
            font-weight: bold;
            color: #D93025;
        }
        .form-control {
            border-radius: 8px;
            padding: 10px;
        }
        .input-group-text {
            background: #e33232;
            color: white;
            border: none;
            border-radius: 8px 0 0 8px;
        }
        .btn-danger {
            background: #D93025;
            border: none;
            border-radius: 8px;
            padding: 10px;
            font-size: 16px;
            transition: background 0.3s;
        }
        .btn-danger:hover {
            background: #B22222;
        }
        .toggle-password {
            cursor: pointer;
            background: none;
            border: none;
            padding: 0 10px;
        }
    </style>
</head>
<body>

    <div class="login-container">
        <h2>🍕 Iniciar Sesión</h2>
        <p class="text-muted">Accede a tu cuenta para gestionar pedidos 🦖</p>

        <!-- Alert de error si las credenciales son incorrectas -->
        <% if (request.getParameter("error") != null) { %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <i class="fas fa-exclamation-circle"></i> Usuario o contraseña incorrectos.
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            </div>
        <% } %>

        <form action="LoginServlet" method="post">
            <div class="mb-3 input-group">
                <span class="input-group-text">
                    <img src="img/user.png" alt="User" width="18px" height="18px">
                </span>
                <input type="text" name="username" class="form-control" placeholder="Usuario" required>
            </div>

            <div class="mb-3 input-group">
                <span class="input-group-text">
                    <img src="img/padlock.png" alt="Password" width="18px" height="18px">
                </span>
                <input type="password" id="password" name="password" class="form-control" placeholder="Contraseña" required>
                <button  type="button" class="toggle-password" onclick="togglePassword()">
                    <i id="toggleIcon" class="fas fa-eye"> <img src="img/hide.png" alt="User" width="18px" height="18px"></i>
                </button>
            </div>

            <button type="submit" class="btn btn-danger w-100">Ingresar</button>
        </form>
    </div>

    <script>
        function togglePassword() {
            var passwordField = document.getElementById("password");
            var icon = document.getElementById("toggleIcon");

            if (passwordField.type === "password") {
                passwordField.type = "text";
                icon.classList.remove("fa-eye");
                icon.classList.add("fa-eye-slash");
            } else {
                passwordField.type = "password";
                icon.classList.remove("fa-eye-slash");
                icon.classList.add("fa-eye");
            }
        }
    </script>

</body>
</html>
