/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Ordenes;
import DAO.OrdenesDAO;
import model.Pizza;
import DAO.PizzaDAO;
import model.Cliente;

/**
 *
 * @author Deku
 */
@WebServlet(name = "OrdenesServlet", urlPatterns = {"/OrdenesServlet"})
public class OrdenesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrdenesServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrdenesServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String name = request.getParameter("nombre");
    String apellido = request.getParameter("apellido");
    String dni = request.getParameter("dni");
    String[] pizza = request.getParameter("pizzaId").split("&");
    int pizzaId = Integer.parseInt(pizza[0]);
    double pizzaPre = Double.parseDouble(pizza[1]);
    int cant = Integer.parseInt(request.getParameter("cantidad"));
    double total = pizzaPre * cant;

    ClienteDAO clipower = new ClienteDAO();
    int customerId;

    if (clipower.ConsultarCliente(dni)) {
        customerId = clipower.obtenerIdCliente(dni);
    } else {
        customerId = clipower.CrearCliente(new Cliente(dni, name, apellido));
    }

    if (customerId > 0) {  
        Ordenes nuevaOrden = new Ordenes(cant, total, 0, customerId, pizzaId);
        OrdenesDAO ordenDAO = new OrdenesDAO();
        
        if (ordenDAO.CrearOrden(nuevaOrden)) {
            // Después de crear la orden, consultamos todas las órdenes para mostrarlas en la página
            
            request.getRequestDispatcher("pedidos.jsp").forward(request, response);
        } else {
            System.out.println("Error al crear la orden.");
            response.sendRedirect("registrarPedido.jsp?error=1");
        }
    } else {
        System.out.println("Error al obtener ID del cliente.");
        response.sendRedirect("error.jsp");
    }
}


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
