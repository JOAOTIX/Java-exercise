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
    
    public Boolean ActulizarProductos(Producto prod) {
        try {
            cn = ConectarBD.abrir();
            stm = cn.createStatement();
            sql = "update productos set nombre='"+prod.getName()+"',descripcion='"+prod.getDescrip()+"',stock="+prod.getStock()+",categoria='"+prod.getCategoria()+"',pventa="+prod.getPventa()+",pcompra="+prod.getPcompra()+"where id="+prod.getId();
            stm.executeUpdate(sql);
            System.out.println(sql);
            ConectarBD.cerrar();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR:" + e);
            return false;
        }

    }
     public Boolean EliminarProductos(int cod) {
        try {
            cn = ConectarBD.abrir();
            stm = cn.createStatement();
            sql = "delete from productos where id="+cod;
            stm.executeUpdate(sql);
            ConectarBD.cerrar();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR:" + e);
            return false;
        }

    }

    public Boolean AgregarProductos(Producto prod) {
        try {
            cn = ConectarBD.abrir();
            stm = cn.createStatement();
            sql = "insert into productos (nombre,descripcion,stock,categoria,pventa,pcompra)"
                    + "values('" + prod.getName() + "','" + prod.getDescrip() + "'," + prod.getStock() + ",'" + prod.getCategoria() + "'," + prod.getPventa() + "," + prod.getPcompra() + ")";
            stm.executeUpdate(sql);
            System.out.println(sql);
            ConectarBD.cerrar();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR:" + e);
            return false;
        }

    }

    public List<Producto> ConsultarProductos() {

        List<Producto> listaProductos = new ArrayList<>();
        try {
            cn = ConectarBD.abrir();
            stm = cn.createStatement();
            sql = "select * from productos";
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setName(rs.getString("nombre"));
                producto.setDescrip(rs.getString("descripcion"));
                producto.setStock(rs.getInt("stock"));
                producto.setCategoria(rs.getString("categoria"));
                producto.setPventa(rs.getDouble("pventa"));
                producto.setPcompra(rs.getDouble("pcompra"));

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
            sql = "select * from usuarios where"
                    + " usuario='" + user + "' and clave='" + password + "' ";
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
