package clases;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestorBD {

    Connection cn;
    Statement stm;
    ResultSet rs;

    Basedatos bd = new Basedatos();
    
    public boolean actualizarSerie(String serie) {
    int a = 0;
    try {
        cn = bd.abrir();
        stm = cn.createStatement();
        String sql = "UPDATE tbserie SET numero = numero + 1 WHERE serie = '" + serie + "' ";
        a = stm.executeUpdate(sql);
    } catch (Exception e) {
        System.err.println("ERROR:" + e);
    }
    return a == 1;
}

    public int buscarproductocod(String buscar) {
        try {
            cn = bd.abrir();
            stm = cn.createStatement();
            String sql = "select codigo from tbproducto where producto='" + buscar + "'";
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.err.println("ERROR:" + e);
            return 0;
        }
    }

    public boolean guardarBoletaDet(Boletadet boldet) {
        String cadena;
        try {
            cn = bd.abrir();
            stm = cn.createStatement();
            String sql = "insert into tbboletadet (numero, codproducto, cantidad, precio,importe) values ('"  + boldet.numero + "',"
                    + boldet.codproducto + "," + boldet.cantidad + "," + boldet.precio + "," + boldet.importe + ")";
            stm.executeUpdate(sql);
            System.out.println(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        }
    }

    public boolean guardarBoleta(Boletacab bolcab) {
        String cadena;
        try {
            cn = bd.abrir();
            stm = cn.createStatement();
            String sql = "insert into tbboletacab (numero, dniclientes, subtotal, igv,total) values ('" + bolcab.numero + "','"
                    + bolcab.dni + "'," + bolcab.subtotal + "," + bolcab.igv + "," + bolcab.total + ")";
            stm.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        }
    }

    public boolean guardarCliente(Cliente cli) {
        String cadena;
        try {
            cn = bd.abrir();
            stm = cn.createStatement();
            String sql = "insert into tbclientes (dni, nombres, apellidos, direccion,distrito) values ('" + cli.dni + "','"
                    + cli.nombres + "','" + cli.apellidos + "','" + cli.direccion + "','" + cli.distrito + "')";
            stm.executeUpdate(sql);
            System.out.println(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return false;
        }
    }

   public boolean descontarStock(String name, int cant) {
    int stockdb = 0;
    int a = 0;
    try {
        cn = bd.abrir();
        stm = cn.createStatement();
        String sql = "SELECT stock FROM tbproducto WHERE producto = '" + name + "'";
        rs = stm.executeQuery(sql);
        
        while (rs.next()) {
            stockdb = rs.getInt(1);
        }

        String upd = "UPDATE tbproducto SET stock = '" + (stockdb - cant) + "' WHERE producto = '" + name + "'";
        a = stm.executeUpdate(upd);

    } catch (Exception e) {
        System.err.println("ERROR:" + e);
    }
    return a == 1;
}


    public ArrayList<Producto> listarProuctos() {
        ArrayList<Producto> lista = new ArrayList<Producto>();
        try {
            cn = bd.abrir();
            stm = cn.createStatement();
            String sql = "select * from tbproducto";
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Producto producto = new Producto();
                producto.name = rs.getString(2);
                producto.price = rs.getDouble(3);
                lista.add(producto);
            }
            return lista;
        } catch (Exception e) {
            System.err.println("ERROR:" + e);
            return null;
        }
    }

    public Cliente buscarcliente(String buscar) {
        Cliente user = new Cliente();
        try {
            cn = bd.abrir();
            stm = cn.createStatement();
            String sql = "select * from tbclientes where dni='" + buscar + "'";
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                user.dni = rs.getString(1);
                user.nombres = rs.getString(2);
                user.apellidos = rs.getString(3);
                user.direccion = rs.getString(4);
                user.distrito = rs.getString(5);

                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println("ERROR:" + e);
            return null;
        }
    }

    public String cargarBoleta() {
        String cadena;
        try {

            cn = bd.abrir();
            stm = cn.createStatement();
            String sql = "select * from tbserie";
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                cadena = rs.getString(1) + "-" + (rs.getInt(2) + 1);
            } else {
                return "";
            }
        } catch (Exception e) {
            System.err.println("ERROR:" + e);
            return "";
        }
        return cadena;
    }

    public boolean verificarUsuario(String user, String password) {
        try {
            cn = bd.abrir();
            stm = cn.createStatement();
            String sql = "select * from tbusuarios where usuario='" + user + "' and clave='" + password + "'";
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("ERROR:" + e);
        }
        return false;
    }
}
