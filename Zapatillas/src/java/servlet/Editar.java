/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import clases.GestorBD;
import clases.Zapatillas;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "Editar", urlPatterns = {"/Editar"})
public class Editar extends HttpServlet {

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
          Zapatillas prod=new Zapatillas ();
          int code= Integer.parseInt(request.getParameter("codigo"));
        String nombre=request.getParameter("nombre");
        String marca=request.getParameter("marca");
        String talla=request.getParameter("talla");
        int stock=Integer.parseInt(request.getParameter("stock"));
        double pventa=Double.parseDouble(request.getParameter("pventa"));
        double pcompra=Double.parseDouble(request.getParameter("pcompra"));
        
        prod.setId(code);
        prod.setName(nombre);
        prod.setMarca(marca);
        prod.setTalla(talla);
        prod.setStock(stock);
        prod.setPventa(pventa);
        prod.setPcosto(pcompra);
        GestorBD gestor=new GestorBD();
        if(gestor.ActulizarProductos(prod)){
             List <Zapatillas> listaProducto=gestor.ConsultarProductos();
             request.setAttribute("zapatillas", listaProducto);
            request.getRequestDispatcher("/inicio.jsp").forward(request, response);
        }else{
            
            request.getRequestDispatcher("/Agregar.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
