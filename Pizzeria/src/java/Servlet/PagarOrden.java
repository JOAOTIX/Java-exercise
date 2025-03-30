/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.BoletaCabDAO;
import DAO.BoletaDetDAO;
import DAO.ClienteDAO;
import DAO.OrdenesDAO;
import jakarta.servlet.RequestDispatcher;
import java.sql.Connection;
import model.ConectarBD;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.BoletaCab;
import model.BoletaDet;
import model.Ordenes;

/**
 *
 * @author Deku
 */
@WebServlet(name = "PagarOrden", urlPatterns = {"/PagarOrden"})
public class PagarOrden extends HttpServlet {

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
            out.println("<title>Servlet PagarOrden</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PagarOrden at " + request.getContextPath() + "</h1>");
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
         int idOrden = Integer.parseInt(request.getParameter("orden"));
         String tipo = request.getParameter("tipo");
         System.out.println(tipo);

        OrdenesDAO ordenDAO = new OrdenesDAO();
         BoletaCabDAO boletaCabDAO = new BoletaCabDAO();  // Nuevo DAO
    BoletaDetDAO boletaDetDAO = new BoletaDetDAO();  // Nuevo DAO
      ClienteDAO clienteDAO = new ClienteDAO(); // Para obtener el DNI del cliente

        try (Connection conn = ConectarBD.abrir()) {
           
              // Obtener los datos de la orden
            Ordenes orden = ordenDAO.obtenerOrdenPorId(conn, idOrden); // Método que recupera la orden
        
            if (ordenDAO.PagarOrden(conn, idOrden)) {
              String numBol = boletaCabDAO.generarNumeroSerie(conn, tipo); // Método para generar número de boleta
            
               // Obtener datos necesarios:
            String fechaActual = java.time.LocalDate.now().toString();
            String dniCliente = clienteDAO.obtenerDniCliente(conn, orden.getId_cliente()); // Método que debes tener en ClienteDAO

            // Asumamos que el total de la orden es sin IGV; calculemos:
            double imp = orden.getTotal();
            double igv = imp * 0.18;
            double totalConIgv = imp + igv;
            
            // Crear objeto BoletaCab con los parámetros correctos:
            BoletaCab boletaCab = new BoletaCab(numBol, fechaActual, dniCliente, imp, igv, totalConIgv);
            
            // Insertar la cabecera de la boleta en la BD
            boletaCabDAO.insertarBoleta(boletaCab);

            // Para el detalle: 
            // Supongamos que la orden se trata de un solo producto (la pizza)
            // Calculamos el precio unitario:
            int cantidad = orden.getCantidad();
            double precioUnitario = (cantidad > 0) ? (imp / cantidad) : 0;
            
            // Crear objeto BoletaDet; usamos como código de producto el id de pizza convertido a String
            BoletaDet boletaDet = new BoletaDet(numBol, String.valueOf(orden.getId_pizza()), cantidad, precioUnitario);
            
            // Insertar el detalle en la BD
            boletaDetDAO.insertarBoletaDet(boletaDet);
                List<Ordenes> listaOrdenesPagadas = ordenDAO.ConsultarOrdenesPagadas();
                request.setAttribute("ordenesPagadas", listaOrdenesPagadas);
                RequestDispatcher dispatcher = request.getRequestDispatcher("cocina.jsp");
                dispatcher.forward(request, response);
            } else {
             
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
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
