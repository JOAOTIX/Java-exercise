/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Deku
 */
public class GestorBD {

    public static Connection cn;
    public Statement stm;
    public ResultSet rs;
    public String sql;
    public List<Producto> ConsultarProductos(){
        
        List<Producto> listaProductos=new ArrayList<> ();
        try {
            cn = ConectarBD.abrir();
            stm = cn.createStatement();
            sql = "select * from tbproductos";
            rs = stm.executeQuery(sql);
            while(rs.next()) {
                Producto producto=new Producto();
                producto.setCode(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setStock(rs.getInt("stock"));
                producto.setPventa(rs.getDouble("pventa"));
                listaProductos.add(producto);
                
            }
        } catch (Exception e) {
            System.out.println("ERROR:" + e);
          
    }
        return listaProductos;
 }
    
    public boolean ConsultarUsuario(String user, String password) {
        
        try {
            cn = ConectarBD.abrir();
            stm = cn.createStatement();
            sql = "select * from tbusuarios where"
                    + " USUARIO='" + user + "' and CLAVE='" + password + "' ";
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                ConectarBD.cerrar();
                return true;
            } else {
                ConectarBD.cerrar();
                return false;
            }

        } catch (Exception e) {
            System.out.println("ERROR:" + e);
            return false;
        }
    }
}
