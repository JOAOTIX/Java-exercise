<%-- 
    Document   : ecuacion
    Created on : 16 mar. 2025, 8:52:50 a. m.
    Author     : Deku
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ page import="clases.ResuelveEc" %>
        <%@ page import="hola.GestorArchivo" %>
        <%
            String a = request.getParameter("VarA");
            String b = request.getParameter("VarB");
            String c = request.getParameter("VarC");

            ResuelveEc ec = new ResuelveEc(a, b, c);

            String result1 = ec.raiz1();
            String result2 = ec.raiz2();

            ServletContext sc = this.getServletContext();
            String path = sc.getRealPath("Resultados.txt");

            GestorArchivo guardar = new GestorArchivo();
            
            guardar.guardarResultado(result1, result2, path);
        %>
        
        <form action="" method="post">
            <table border="1">
                <tr>
                    <th colspan="2">Resultados</th>
                    
                </tr>
                <tr>
                    <td>Primera raiz:</td>
                    <td><%= result1%></td>
                </tr>
                <tr>
                    <td>Segunda raiz:</td>
                    <td><%= result2%></td>
                </tr>
            </table>
        </form>
                <p>Los resultados se guardar en el archivo <br> "Resultados.txt"</p>
                <br>
                <form action="ejem-9.jsp" method="post">
                    <input type="submit" value="Regresar">
                </form>
    </body>
</html>
