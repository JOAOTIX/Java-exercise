/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import static com.itextpdf.text.FontFactory.TIMES_BOLD;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Deku
 */
@WebServlet(name = "GenerarPDF", urlPatterns = {"/GenerarPDF"})
public class GenerarPDF extends HttpServlet {

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
            out.println("<title>Servlet GenerarPDF</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GenerarPDF at " + request.getContextPath() + "</h1>");
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
        String orden = request.getParameter("orden");
        String fecha = request.getParameter("fecha");
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String codPro = request.getParameter("codPro");
        String nombrePro = request.getParameter("nombrePro");
        String cantidad = request.getParameter("cantidad");
        String precioUni = request.getParameter("precioUni");
        String imp = request.getParameter("imp");
        String igv = request.getParameter("igv");
        String total = request.getParameter("total");
        // Configurar la respuesta para enviar un PDF
        String tipoDocumento = orden.startsWith("B") ? "BOLETA" : "FACTURA";
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=" + tipoDocumento + "-" + orden + ".pdf");

        try {
            Font fontTable = new Font(FontFactory.getFont(TIMES_BOLD, 12, Font.NORMAL, BaseColor.WHITE));
            Font fontTitle = new Font(FontFactory.getFont(TIMES_BOLD, 18, Font.BOLDITALIC, BaseColor.BLUE));
            Document documento = new Document();
            OutputStream out = response.getOutputStream();
            PdfWriter.getInstance(documento, out);
            documento.open();
            String imagePath = getServletContext().getRealPath("/img/image.png");
            Image logo = Image.getInstance(imagePath);
            logo.setAlignment(Element.ALIGN_LEFT);
            documento.add(logo);
            Paragraph titulo = new Paragraph("SEDE LIMA-2025", fontTitle);
            titulo.setAlignment(Element.ALIGN_LEFT);
            Paragraph titulo2 = new Paragraph("Av. 28 de Julio 715, Lima 15046", fontTitle);
            titulo.setAlignment(Element.ALIGN_LEFT);
            documento.add(titulo);
            documento.add(titulo2);
            Paragraph ruc = new Paragraph("R.U.C: 20131376503");
            Paragraph title = new Paragraph("BOLETA DE VENTA");
            Paragraph serie = new Paragraph(orden);
            title.setAlignment(Element.ALIGN_RIGHT);
            serie.setAlignment(Element.ALIGN_RIGHT);
            ruc.setAlignment(Element.ALIGN_RIGHT);
            documento.add(ruc);
            documento.add(title);
            documento.add(serie);

            documento.add(new Paragraph("SEÑOR(ES):" + nombre));
            documento.add(new Paragraph("DOCUMENTO DE IDENTIDAD:" + dni));
            documento.add(new Paragraph("FECHA DE EMISION:" + fecha));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("\n"));

            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            PdfPCell cel1 = new PdfPCell(new Paragraph("CODIGO DE PRODUCTO", fontTable));
            cel1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cel1.setBackgroundColor(BaseColor.GRAY);
            PdfPCell cel2 = new PdfPCell(new Paragraph("PRODUCTO", fontTable));
            cel2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cel2.setBackgroundColor(BaseColor.GRAY);
            PdfPCell cel3 = new PdfPCell(new Paragraph("CANTIDAD", fontTable));
            cel3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cel3.setBackgroundColor(BaseColor.GRAY);
            PdfPCell cel4 = new PdfPCell(new Paragraph("PRECIO UNITARIO", fontTable));
            cel4.setHorizontalAlignment(Element.ALIGN_CENTER);
            cel4.setBackgroundColor(BaseColor.GRAY);
            PdfPCell cel5 = new PdfPCell(new Paragraph("IMPORTE", fontTable));
            cel5.setHorizontalAlignment(Element.ALIGN_CENTER);
            cel5.setBackgroundColor(BaseColor.GRAY);
            table.addCell(cel1);
            table.addCell(cel2);
            table.addCell(cel3);
            table.addCell(cel4);
            table.addCell(cel5);
            //Producto

            table.addCell(codPro);
            table.addCell(nombrePro);
            table.addCell(cantidad);
            table.addCell(precioUni);
            table.addCell(imp);

            PdfPTable tableTotales = new PdfPTable(2);
            tableTotales.setWidthPercentage(40);
            tableTotales.setHorizontalAlignment(Element.ALIGN_RIGHT);

            tableTotales.addCell(new PdfPCell(new Paragraph("Subtotal:")));
            tableTotales.addCell(new PdfPCell(new Paragraph("S/ " + imp)));

            tableTotales.addCell(new PdfPCell(new Paragraph("IGV (18%):")));
            tableTotales.addCell(new PdfPCell(new Paragraph("S/ " + igv)));

            tableTotales.addCell(new PdfPCell(new Paragraph("Total:")));
            tableTotales.addCell(new PdfPCell(new Paragraph("S/ " + total)));

            documento.add(table);
            documento.add(tableTotales);
            documento.add(new Paragraph("\n"));
            documento.add(new Paragraph("\n"));
            Paragraph thanks = new Paragraph("GRACIAS POR SU PREFERENCIA " + nombre, fontTitle);
            thanks.setAlignment(Element.ALIGN_CENTER);
            documento.add(thanks);

            documento.close();
        } catch (DocumentException ex) {
            Logger.getLogger(GenerarPDF.class.getName()).log(Level.SEVERE, null, ex);
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
