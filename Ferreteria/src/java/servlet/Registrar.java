/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import clases.GestorBD;
import clases.Producto;
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
@WebServlet(name = "Registrar", urlPatterns = {"/Registrar"})
public class Registrar extends HttpServlet {

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
         Producto prod=new Producto();
        String nombre=request.getParameter("nombre");
        String des=request.getParameter("desc");
        int stock=Integer.parseInt(request.getParameter("stock"));
        String cat=request.getParameter("cat");
        double pventa=Double.parseDouble(request.getParameter("pventa"));
        double pcompra=Double.parseDouble(request.getParameter("pcompra"));
        
        prod.setName(nombre);
        prod.setDescrip(des);
        prod.setStock(stock);
        prod.setCategoria(cat);
        prod.setPventa(pventa);
        prod.setPcompra(pcompra);
        int agregar=0;
        GestorBD gestor=new GestorBD();
        if(gestor.AgregarProductos(prod)){
             List <Producto> listaProducto=gestor.ConsultarProductos();
             request.setAttribute("productos", listaProducto);
            request.getRequestDispatcher("/Ferreteria.jsp").forward(request, response);
        }else{
            
            request.setAttribute("value", agregar);
            request.getRequestDispatcher("/Agregar.jsp").forward(request, response);
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
