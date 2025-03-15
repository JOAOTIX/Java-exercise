<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String name= request.getParameter("Nombre");
            String apellido_one= request.getParameter("apell1");
            String apellido_two= request.getParameter("apell2");
            String tel=request.getParameter("tel");
        %>
        <table border="1">
            <thead>
                <tr>
                    <th colspan="2">Datos Enviados de <%=name + " "+ apellido_one +" "+apellido_two %></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Nombre:</td>
                    <td><%=name%></td>
                </tr>
                <tr>
                    <td>Apellido 1</td>
                    <td><%=apellido_one%></td>
                </tr>
                <tr>
                    <td>Apellido 2</td>
                    <td><%=apellido_two%></td>
                </tr>
                <tr>
                    <td>Telefono:</td>
                    <td><%=tel%></td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
