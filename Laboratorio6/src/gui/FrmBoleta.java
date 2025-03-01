/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alumno
 */
public class FrmBoleta extends javax.swing.JFrame {

    DefaultTableModel modelotabla;

    public FrmBoleta() {
        initComponents();
        CargarBoletaNumero();
        CargarProductos();
        CargaTabla();
    }

    void CargarBoletaNumero() {
        String linea;
        int numero;
        try {
            File archivo = new File("C:\\Sistema\\TXTSERIE.txt");
            Scanner leer = new Scanner(archivo);
            if (leer.hasNextLine()) {
                linea = leer.nextLine();
                String[] registro = linea.split("-");
                numero = Integer.parseInt(registro[1]) + 1;
                txtBoletaNum.setText(registro[0] + "-" + numero);
            }
            leer.close();

        } catch (Exception e) {
            System.err.println("Error" + e);

        }
    }

    void CargarProductos() {
        String linea;
        int numero;
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try {
            File archivo = new File("C:\\Sistema\\TXTPRODUCTOS.txt");
            Scanner leer = new Scanner(archivo);
            while (leer.hasNextLine()) {
                linea = leer.nextLine();
                String[] registro = linea.split("-");

                modelo.addElement(registro[0]);

            }
            cboProducto.setModel(modelo);
            leer.close();
        } catch (Exception e) {
            System.err.println("Error" + e);

        }
    }

    void CargaTabla() {
        String[] titulos = {"Cantidad", "Producto", "PrecioUnit", "Importe"};
        modelotabla = new DefaultTableModel(null, titulos);
        tblDatos.setModel(modelotabla);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBoletaNum = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtDistrito = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPrecioUnit = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtImporte = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        cboProducto = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnCalcular = new javax.swing.JButton();
        SubTotal = new javax.swing.JLabel();
        SubTotal1 = new javax.swing.JLabel();
        SubTotal2 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtIGV = new javax.swing.JTextField();
        btnCalcularTotal = new javax.swing.JButton();
        btnGenerarBoleta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("BOLETA DE VENTA");

        jLabel2.setText("Boleta Numero:");

        jLabel3.setText("Nombres:");

        jLabel4.setText("DNI:");

        jLabel5.setText("Apellidos:");

        jLabel6.setText("Distrito:");

        jLabel7.setText("Direccion:");

        txtBoletaNum.setEditable(false);
        txtBoletaNum.setEnabled(false);

        jLabel8.setText("Producto");

        jLabel9.setText("PrecioUnit");

        jLabel10.setText("Cantidad");

        jLabel11.setText("Importe");

        txtPrecioUnit.setEditable(false);

        txtImporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImporteActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        cboProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboProductoMouseClicked(evt);
            }
        });
        cboProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProductoActionPerformed(evt);
            }
        });

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDatos);

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        SubTotal.setText("Subtotal");

        SubTotal1.setText("IGV");

        SubTotal2.setText("Total");

        btnCalcularTotal.setText("Calcular Boleta");
        btnCalcularTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularTotalActionPerformed(evt);
            }
        });

        btnGenerarBoleta.setText("GENERAR BOLETA");
        btnGenerarBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarBoletaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBoletaNum, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(cboProducto, 0, 292, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrecioUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnAgregar))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(78, 78, 78)
                        .addComponent(jLabel9)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel10)
                        .addGap(107, 107, 107)
                        .addComponent(jLabel11)
                        .addGap(128, 128, 128))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(309, 309, 309)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDistrito))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(btnBuscar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(32, 32, 32)
                .addComponent(btnCalcular)
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(btnCalcularTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerarBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SubTotal1)
                    .addComponent(SubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SubTotal2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(txtIGV)
                    .addComponent(txtTotal))
                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBoletaNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar)
                    .addComponent(cboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcular))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SubTotal)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SubTotal1)
                            .addComponent(txtIGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SubTotal2)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCalcularTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerarBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String cant, prod, preU, imp;
        cant = txtCantidad.getText();
        prod = cboProducto.getSelectedItem().toString();
        preU = txtPrecioUnit.getText();
        imp = txtImporte.getText();
        String[] fila = new String[5];

        fila[0] = cant;
        fila[1] = prod;
        fila[2] = preU;
        fila[3] = imp;

        modelotabla.addRow(fila);

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cboProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProductoActionPerformed
        String a = cboProducto.getSelectedItem().toString();
        String linea;
        try {
            File archivo = new File("C:\\Sistema\\TXTPRODUCTOS.txt");
            Scanner leer = new Scanner(archivo);
            while (leer.hasNextLine()) {
                linea = leer.nextLine();
                String[] registro = linea.split("-");
                if (registro[0].equals(a)) {
                    txtPrecioUnit.setText(registro[1]);
                    break;
                }
            }
            leer.close();

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        txtImporte.setText("");
    }//GEN-LAST:event_cboProductoActionPerformed

    private void cboProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboProductoMouseClicked

    }//GEN-LAST:event_cboProductoMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String dniBuscado = txtDni.getText();
        try {
            File archivo = new File("C:\\Sistema\\TXTCLIENTES.txt");
            Scanner leer = new Scanner(archivo);
            while (leer.hasNextLine()) {
                String[] registro = leer.nextLine().split("-");
                if (registro[0].equals(dniBuscado)) {
                    txtNombres.setText(registro[1]);
                    txtApellidos.setText(registro[2] + " " + registro[3]);
                    txtDireccion.setText(registro[4]);
                    txtDistrito.setText(registro[5]);
                    JOptionPane.showMessageDialog(rootPane, "Cliente encontrado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Cliente no registrado o dni erroneo, verificalo e intenta de nuevo");
                }
                break;

            }
            leer.close();
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        if (txtCantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Ingresa una cantidad porfavor.");
        } else {
            double b = Double.parseDouble(txtPrecioUnit.getText());
            double c = Double.parseDouble(txtCantidad.getText());
            double importe = b * c;
            txtImporte.setText("" + importe);
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void txtImporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImporteActionPerformed

    private void btnCalcularTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularTotalActionPerformed

       double igv=0.18;
      double sumaTotal = 0.0;
      double total=0.0;
        for (int i = 0; i < modelotabla.getRowCount(); i++) {
            
            String impStr = modelotabla.getValueAt(i, 3).toString();
                double imp = Double.parseDouble(impStr); 
                sumaTotal += imp; 
            
        }
        txtSubTotal.setText(sumaTotal+"");
        txtIGV.setText(String.format("%.2f", sumaTotal * igv));
        total=sumaTotal+sumaTotal*igv;
        txtTotal.setText(total+"");
    }//GEN-LAST:event_btnCalcularTotalActionPerformed

    private void btnGenerarBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarBoletaActionPerformed
       String numeroBoleta = txtBoletaNum.getText();
    String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    String dni = txtDni.getText();
    String subtotal = txtSubTotal.getText();
    String igv = txtIGV.getText();
    String total = txtTotal.getText();
    
    try {
        // Guardar Boleta General
        FileWriter fwBoleta = new FileWriter("C:\\Sistema\\TXTBOLETA.txt", true);
        PrintWriter pwBoleta = new PrintWriter(fwBoleta);
        pwBoleta.println(numeroBoleta + "-" + fecha + "-" + dni + "-" + subtotal + "-" + igv + "-" + total);
        pwBoleta.close();
        fwBoleta.close();
        
        // Guardar Detalles de la Boleta y Actualizar Stock
        FileWriter fwBoletaDet = new FileWriter("C:\\Sistema\\TXTBOLETADET.txt", true);
        PrintWriter pwBoletaDet = new PrintWriter(fwBoletaDet);
        
        File archivoProductos = new File("C:\\Sistema\\TXTPRODUCTOS.txt");
        Scanner leer = new Scanner(archivoProductos);
        ArrayList<String> productosActualizados = new ArrayList<>();
        
        while (leer.hasNextLine()) {
            String linea = leer.nextLine();
            String[] datos = linea.split("-");
            String nombreProducto = datos[0];
            double precioUnit = Double.parseDouble(datos[1]);
            int stock = Integer.parseInt(datos[2]);
            
            for (int i = 0; i < modelotabla.getRowCount(); i++) {
                String prod = modelotabla.getValueAt(i, 1).toString();
                int cantidadVendida = Integer.parseInt(modelotabla.getValueAt(i, 0).toString());
                double importe = Double.parseDouble(modelotabla.getValueAt(i, 3).toString());
                
                if (prod.equals(nombreProducto)) {
                    if (stock >= cantidadVendida) {
                        stock -= cantidadVendida;
                        pwBoletaDet.println(numeroBoleta + "-" + cantidadVendida + "-" + prod + "-" + precioUnit + "-" + importe);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Stock insuficiente para " + prod);
                    }
                }
            }
            productosActualizados.add(nombreProducto + "-" + precioUnit + "-" + stock);
        }
        leer.close();
        
        // Escribir el archivo de productos actualizado
        FileWriter fwProductos = new FileWriter("C:\\Sistema\\TXTPRODUCTOS.txt");
        PrintWriter pwProductos = new PrintWriter(fwProductos);
        for (String prod : productosActualizados) {
            pwProductos.println(prod);
        }
        pwProductos.close();
        fwProductos.close();
        
        pwBoletaDet.close();
        fwBoletaDet.close();
        
        JOptionPane.showMessageDialog(rootPane, "Boleta generada correctamente.");
    } catch (Exception e) {
        System.err.println("Error: " + e);
    }
    }//GEN-LAST:event_btnGenerarBoletaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmBoleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBoleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBoleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBoleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBoleta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SubTotal;
    private javax.swing.JLabel SubTotal1;
    private javax.swing.JLabel SubTotal2;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCalcularTotal;
    private javax.swing.JButton btnGenerarBoleta;
    private javax.swing.JComboBox<String> cboProducto;
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
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBoletaNum;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDistrito;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtIGV;
    private javax.swing.JTextField txtImporte;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtPrecioUnit;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
