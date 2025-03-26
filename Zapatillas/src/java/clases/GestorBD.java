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
    public List<Zapatillas> ConsultarProductos(){
        
        List<Zapatillas> listaProductos=new ArrayList<> ();
        try {
            cn = ConexionBD.abrir();
            stm = cn.createStatement();
            sql = "select * from productos";
            rs = stm.executeQuery(sql);
            while(rs.next()) {
                Zapatillas zapatilla=new Zapatillas();
                
                zapatilla.setId(rs.getInt("id"));
                zapatilla.setName(rs.getString("nombre"));
                zapatilla.setMarca(rs.getString("marca"));
                zapatilla.setTalla(rs.getString("talla"));
                zapatilla.setStock(rs.getInt("stock"));
                zapatilla.setPventa(rs.getDouble("pventa"));
                zapatilla.setPcosto(rs.getDouble("pcosto"));
                listaProductos.add(zapatilla);
                
            }
        } catch (Exception e) {
            System.out.println("ERROR:" + e);
          
    }
        return listaProductos;
 }
    
    public boolean ConsultarUsuario(String user, String password) {
        
        try {
            cn = ConexionBD.abrir();
            stm = cn.createStatement();
            sql = "select * from tbusuarios where"
                    + " USUARIO='" + user + "' and CLAVE='" + password + "' ";
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                ConexionBD.cerrar();
                return true;
            } else {
                ConexionBD.cerrar();
                return false;
            }

        } catch (Exception e) {
            System.out.println("ERROR:" + e);
            return false;
        }
    }
}
