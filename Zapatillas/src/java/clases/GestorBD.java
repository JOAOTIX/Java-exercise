/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
     public Boolean ActulizarProductos(Zapatillas prod) {
        try {
            cn = ConexionBD.abrir();
            stm = cn.createStatement();
            sql = "update productos set nombre='"+prod.getName()+"',marca='"+prod.getMarca()+"',talla='"+prod.getTalla()+"',stock="+prod.getStock()+",pventa="+prod.getPventa()+",pcosto="+prod.getPcosto()+"where id="+prod.getId();
            stm.executeUpdate(sql);
            System.out.println(sql);
            ConexionBD.cerrar();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR:" + e);
            return false;
        }

    }
     public Boolean EliminarProductos(int cod) {
        try {
            cn = ConexionBD.abrir();
            stm = cn.createStatement();
            sql = "delete from productos where id="+cod;
            stm.executeUpdate(sql);
            ConexionBD.cerrar();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR:" + e);
            return false;
        }

    }

    public Boolean AgregarProductos(Zapatillas prod) {
    try {
        cn = ConexionBD.abrir();
        String sql = "INSERT INTO productos (nombre, marca, talla, stock, pventa, pcosto) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, prod.getName());
        ps.setString(2, prod.getMarca());
        ps.setString(3, prod.getTalla());
        ps.setInt(4, prod.getStock());
        ps.setDouble(5, prod.getPventa());
        ps.setDouble(6, prod.getPcosto());
        ps.executeUpdate();
        System.out.println(sql);
        System.out.println("Producto agregado correctamente.");
        ConexionBD.cerrar();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();

        return false;
    } catch (Exception e) {
        System.out.println("ERROR GENERAL: " + e);
        return false;
    }
}

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
