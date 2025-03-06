/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import clases.Boletacab;
import clases.Boletadet;
import clases.Cliente;
import clases.GestorBD;
import clases.Producto;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alumno
 */
public class FrmSistema extends javax.swing.JFrame {

    GestorBD gestorbd = new GestorBD();
    ArrayList<Producto> lista = new ArrayList<Producto>();

    boolean encontrado = false;
    DefaultTableModel modelotabla;

    public FrmSistema() {
        initComponents();
        mostrarserie();
        mostrarproductos();
        cargartabla();
    }
    public void generarPDF() {
    String serie = txtSerie.getText();
    String dni = txtDni.getText(); 
    String nombre = txtNombre.getText(); 
    String apellido = txtApellido.getText(); 
    String ruta = "C:\\Users\\KJhonatan\\OneDrive\\Documentos\\NetBeansProjects\\Laboratorio-7\\Boletas\\" + serie + ".pdf";

    Document document = new Document();

    try {
        PdfWriter.getInstance(document, new FileOutputStream(ruta));
        document.open();

        
        Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
        Font fontNormal = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
        Font fontBold = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);

       
        document.add(new Paragraph("BOLETA DE VENTA", fontTitulo));
        document.add(new Paragraph("Serie: " + serie, fontNormal));
        document.add(new Paragraph("DNI: " + dni, fontNormal));
        document.add(new Paragraph("Cliente: " + nombre + " " + apellido, fontNormal));
        document.add(new Paragraph("\n"));

       
        PdfPTable table = new PdfPTable(4);
        table.addCell("Producto");
        table.addCell("Cantidad");
        table.addCell("Precio Unit.");
        table.addCell("Importe");

        double subtotal = 0.0;

        for (int i = 0; i < tblTable.getRowCount(); i++) {
            for (int j = 0; j < tblTable.getColumnCount(); j++) {
                table.addCell(tblTable.getValueAt(i, j).toString());
            }
            
            subtotal += Double.parseDouble(tblTable.getValueAt(i, 3).toString());
        }

        document.add(table);
        document.add(new Paragraph("\n"));

        
        double igv = subtotal * 0.18; 
        double total = subtotal + igv;

        
        PdfPTable tableTotales = new PdfPTable(2);
        tableTotales.setWidthPercentage(40); 
        tableTotales.setHorizontalAlignment(Element.ALIGN_CENTER); 

        tableTotales.addCell(new PdfPCell(new Paragraph("Subtotal:", fontBold)));
        tableTotales.addCell(new PdfPCell(new Paragraph("S/ " + String.format("%.2f", subtotal), fontNormal)));

        tableTotales.addCell(new PdfPCell(new Paragraph("IGV (18%):", fontBold)));
        tableTotales.addCell(new PdfPCell(new Paragraph("S/ " + String.format("%.2f", igv), fontNormal)));

        tableTotales.addCell(new PdfPCell(new Paragraph("Total:", fontBold)));
        tableTotales.addCell(new PdfPCell(new Paragraph("S/ " + String.format("%.2f", total), fontNormal)));

        document.add(tableTotales);
        document.add(new Paragraph("\nGracias por su compra.", fontNormal));

        document.close();
        System.out.println("PDF generado: " + ruta);

    } catch (Exception e) {
        System.err.println("ERROR al generar el PDF: " + e);
    }
}

    public void mostrarserie() {
        String number;

        number = gestorbd.cargarBoleta();
        txtSerie.setText(number);
    }

    public double mostrarprecio(int a) {
        return lista.get(a).price;
    }

    public void mostrarproductos() {

        lista = gestorbd.listarProuctos();

        for (int pos = 0; pos < lista.size(); pos++) {
            cboProductos.addItem(lista.get(pos).name);
        }
    }

    public void cargartabla() {
        String[] titulos = {"Producto", "Cantidad", "PrecioUnit", "Importe"};
        modelotabla = new DefaultTableModel(null, titulos);
        tblTable.setModel(modelotabla);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtDistrito = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        txtPrecio = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtImporte = new javax.swing.JTextField();
        cboProductos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTable = new javax.swing.JTable();
        btnagregar = new javax.swing.JButton();
        btnCalcularTotal = new javax.swing.JButton();
        SubTotal = new javax.swing.JLabel();
        SubTotal1 = new javax.swing.JLabel();
        SubTotal2 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtIGV = new javax.swing.JTextField();
        btnGenerar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("SISTEMA DE VENTAS");

        jLabel2.setText("BOLETA NUMERO");

        txtSerie.setEnabled(false);
        txtSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerieActionPerformed(evt);
            }
        });

        jLabel3.setText("DNI:");

        jLabel4.setText("NOMBRES: ");

        jLabel5.setText("APELLIDOS:");

        jLabel6.setText("DIRECCIÓN:");

        jLabel7.setText("DISTRITO:");

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel8.setText("PRODUCTO");

        jLabel9.setText("PRECIO");

        jLabel10.setText("IMPORTE");

        jLabel11.setText("CANTIDAD");

        btnCalcular.setText("CALCULAR");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        txtImporte.setEnabled(false);
        txtImporte.setFocusable(false);

        cboProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProductosActionPerformed(evt);
            }
        });

        tblTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblTable);

        btnagregar.setText("AGREGAR");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btnCalcularTotal.setText("CALCULAR");
        btnCalcularTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularTotalActionPerformed(evt);
            }
        });

        SubTotal.setText("Subtotal");

        SubTotal1.setText("IGV");

        SubTotal2.setText("Total");

        btnGenerar.setText("AGREGAR-1");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(btnCalcularTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SubTotal1)
                            .addComponent(SubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SubTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSubTotal)
                            .addComponent(txtIGV)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(132, 132, 132)
                                    .addComponent(jLabel1))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(38, 38, 38)
                                                .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(43, 43, 43)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel8)
                                                        .addGap(94, 94, 94))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(cboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(47, 47, 47)
                                                        .addComponent(jLabel9)
                                                        .addGap(83, 83, 83)
                                                        .addComponent(jLabel11)
                                                        .addGap(88, 88, 88)
                                                        .addComponent(jLabel10))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(btnCalcular)
                                                        .addGap(38, 38, 38)
                                                        .addComponent(btnagregar))))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(297, 297, 297)
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(109, 109, 109)
                                    .addComponent(btnBuscar))))
                        .addGap(61, 61, 61)
                        .addComponent(btnGenerar)))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalcular)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnagregar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnGenerar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCalcularTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SubTotal)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SubTotal1)
                            .addComponent(txtIGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SubTotal2)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(34, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerieActionPerformed

    }//GEN-LAST:event_txtSerieActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String dni = txtDni.getText();
        Cliente cliente = new Cliente();
        cliente = gestorbd.buscarcliente(dni);
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado con exito!!!");
            txtNombre.setText(cliente.nombres);
            txtApellido.setText(cliente.apellidos);
            txtDistrito.setText(cliente.distrito);
            txtDireccion.setText(cliente.direccion);
            this.encontrado = true;
        } else {
            JOptionPane.showMessageDialog(null, "Dni el cliente: " + dni + " No encontrado".toUpperCase(), "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cboProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProductosActionPerformed

        txtPrecio.setText(mostrarprecio(cboProductos.getSelectedIndex()) + "");
    }//GEN-LAST:event_cboProductosActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        double a;
        if (txtCantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "INGRESA UNA CANTIDAD PORFAVOR!!!!!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int cant = Integer.parseInt(txtCantidad.getText());
        double prec = Double.parseDouble(txtPrecio.getText());
        a = prec * cant;
        txtImporte.setText(a + "");
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        String cant, prod, preU, imp;
        if (txtImporte.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "CALCULA EL IMPORTE ANTES DE AGREGAR!!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            return;
        }
        cant = txtCantidad.getText();
        prod = cboProductos.getSelectedItem().toString();
        preU = txtPrecio.getText();
        imp = txtImporte.getText();
        String[] fila = new String[4];

        fila[0] = prod;
        fila[1] = cant;
        fila[2] = preU;
        fila[3] = imp;

        modelotabla.addRow(fila);
        txtCantidad.setText("");
        txtImporte.setText("");
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btnCalcularTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularTotalActionPerformed
        double igv = 0.18;
        double sumaTotal = 0.0;
        double total = 0.0;
        for (int i = 0; i < modelotabla.getRowCount(); i++) {
            String impStr = modelotabla.getValueAt(i, 3).toString();
            double imp = Double.parseDouble(impStr);
            sumaTotal += imp;

        }
        txtSubTotal.setText(sumaTotal + "");
        txtIGV.setText(sumaTotal * igv + "");
        total = sumaTotal + sumaTotal * igv;
        txtTotal.setText(total + "");
       
    }//GEN-LAST:event_btnCalcularTotalActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        // TODO add your handling code here:
        if (encontrado != true) {
            Cliente cli = new Cliente();
            cli.dni = txtDni.getText();
            cli.nombres = txtNombre.getText();
            cli.apellidos = txtApellido.getText();
            cli.direccion = txtDireccion.getText();
            cli.distrito = txtDistrito.getText();
            gestorbd.guardarCliente(cli);
        }
        Boletacab bolecab=new Boletacab();
        bolecab.numero=txtSerie.getText();
        bolecab.dni=txtDni.getText();
        bolecab.subtotal=Double.parseDouble(txtSubTotal.getText());
        bolecab.igv=Double.parseDouble(txtIGV.getText());
        bolecab.total=Double.parseDouble(txtTotal.getText());
        gestorbd.guardarBoleta(bolecab);
        
        
        for (int i = 0; i < modelotabla.getRowCount(); i++) {
            Boletadet boledet=new Boletadet();
             boledet.numero=txtSerie.getText();
             boledet.codproducto=gestorbd.buscarproductocod(modelotabla.getValueAt(i, 0).toString());
             boledet.cantidad=Integer.parseInt(modelotabla.getValueAt(i, 1).toString());
             boledet.precio=Double.parseDouble(modelotabla.getValueAt(i, 2).toString());
             boledet.importe=Double.parseDouble(modelotabla.getValueAt(i, 3).toString());
             gestorbd.guardarBoletaDet(boledet);
             gestorbd.descontarStock(modelotabla.getValueAt(i, 0).toString(), boledet.cantidad);
        }
            String serie = txtSerie.getText().split("-")[0]; 
            gestorbd.actualizarSerie(serie);

            generarPDF();
    }//GEN-LAST:event_btnGenerarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SubTotal;
    private javax.swing.JLabel SubTotal1;
    private javax.swing.JLabel SubTotal2;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCalcularTotal;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnagregar;
    private javax.swing.JComboBox<String> cboProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTable;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDistrito;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtIGV;
    private javax.swing.JTextField txtImporte;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
