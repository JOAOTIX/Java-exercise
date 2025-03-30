/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.ConectarBD;
import model.Ordenes;

/**
 *
 * @author Deku
 */
public class OrdenesDAO {

    public static Connection cn;
    public Statement stm;
    public ResultSet rs;
    public String sql;

    public boolean CrearOrden(Ordenes orden) {
        Connection connection = ConectarBD.abrir();
        String query = "INSERT INTO orders (quantity, total, state, customer_customer_id, pizza_pizza_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, orden.getCantidad());
            statement.setDouble(2, orden.getTotal());
            statement.setInt(3, orden.getEstado());
            statement.setInt(4, orden.getId_cliente());
            statement.setInt(5, orden.getId_pizza());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al crear la orden: " + e.getMessage());
            return false;
        } finally {
            ConectarBD.cerrar();
        }
    }

    public List<Ordenes> ConsultarOrdenes() {

        Connection connection = ConectarBD.abrir();
        List<Ordenes> ordenes = new ArrayList<>();

        String query = "SELECT o.order_id, o.quantity, o.total, o.state, "
                + "CONCAT(c.name, ' ', c.last_name) AS customer_name, "
                + "p.name AS pizza_name "
                + "FROM orders o "
                + "JOIN customer c ON o.customer_customer_id = c.customer_id "
                + "JOIN pizza p ON o.pizza_pizza_id = p.pizza_id "
                + "WHERE o.state = 0";

        try (PreparedStatement statement = connection.prepareStatement(query); ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Ordenes order = new Ordenes(
                        rs.getInt("order_id"),
                        rs.getInt("quantity"),
                        rs.getDouble("total"),
                        rs.getInt("state"),
                        0,
                        0
                );

                order.setClienteNombre(rs.getString("customer_name"));
                order.setPizzaNombre(rs.getString("pizza_name"));

                ordenes.add(order);
            }

        } catch (SQLException e) {
            System.out.println(">>> Error en ConsultarOrdenes(): " + e.getMessage());
            e.printStackTrace();
        } finally {
            ConectarBD.cerrar();

        }

        return ordenes;
    }

    public boolean PagarOrden(Connection conn, int idOrden) {
    String query = "UPDATE orders SET state = 1 WHERE order_id = ?"; 

    try (PreparedStatement statement = conn.prepareStatement(query)) {
        statement.setInt(1, idOrden);
        int rowsAffected = statement.executeUpdate();

       

        return rowsAffected > 0;
    } catch (SQLException e) {
        System.out.println("Error al pagar la orden: " + e.getMessage());
        return false;
    }
}


    public List<Ordenes> ConsultarOrdenesPagadas() {

        Connection connection = ConectarBD.abrir();
        List<Ordenes> ordenes = new ArrayList<>();

        String query = "SELECT o.order_id, o.quantity, o.total, o.state, "
                + "CONCAT(c.name, ' ', c.last_name) AS customer_name, "
                + "p.name AS pizza_name "
                + "FROM orders o "
                + "JOIN customer c ON o.customer_customer_id = c.customer_id "
                + "JOIN pizza p ON o.pizza_pizza_id = p.pizza_id "
                + "WHERE o.state = 1";

        try (PreparedStatement statement = connection.prepareStatement(query); ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Ordenes order = new Ordenes(
                        rs.getInt("order_id"),
                        rs.getInt("quantity"),
                        rs.getDouble("total"),
                        rs.getInt("state"),
                        0,
                        0
                );

                order.setClienteNombre(rs.getString("customer_name"));
                order.setPizzaNombre(rs.getString("pizza_name"));

                ordenes.add(order);
            }

        } catch (SQLException e) {
            System.out.println(">>> Error en ConsultarOrdenes(): " + e.getMessage());
            e.printStackTrace();
        } finally {
            ConectarBD.cerrar();

        }

        return ordenes;
    }
     public boolean OrdenCocinada(Connection conn, int idOrden) {
    String query = "UPDATE orders SET state = 2 WHERE order_id = ?"; 

    try (PreparedStatement statement = conn.prepareStatement(query)) {
        statement.setInt(1, idOrden);
        int rowsAffected = statement.executeUpdate();

       

        return rowsAffected > 0;
    } catch (SQLException e) {
        System.out.println("Error al cocinar la orden " + e.getMessage());
        return false;
    }
}
     public List<Ordenes> ConsultarOrdenesCocinadas() {

        Connection connection = ConectarBD.abrir();
        List<Ordenes> ordenes = new ArrayList<>();

        String query = "SELECT o.order_id, o.quantity, o.total, o.state, "
                + "CONCAT(c.name, ' ', c.last_name) AS customer_name, "
                + "p.name AS pizza_name "
                + "FROM orders o "
                + "JOIN customer c ON o.customer_customer_id = c.customer_id "
                + "JOIN pizza p ON o.pizza_pizza_id = p.pizza_id "
                + "WHERE o.state = 2";

        try (PreparedStatement statement = connection.prepareStatement(query); ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Ordenes order = new Ordenes(
                        rs.getInt("order_id"),
                        rs.getInt("quantity"),
                        rs.getDouble("total"),
                        rs.getInt("state"),
                        0,
                        0
                );

                order.setClienteNombre(rs.getString("customer_name"));
                order.setPizzaNombre(rs.getString("pizza_name"));

                ordenes.add(order);
            }

        } catch (SQLException e) {
            System.out.println(">>> Error en ConsultarOrdenesCocinadas(): " + e.getMessage());
            e.printStackTrace();
        } finally {
            ConectarBD.cerrar();
  
        }

        return ordenes;
    }
     public boolean cerrarCocina() {
    String query = "UPDATE orders SET state = 3 WHERE state = 2"; // Cambia todas las órdenes cocinads a cerradas

    try (Connection conn = ConectarBD.abrir(); PreparedStatement stmt = conn.prepareStatement(query)) {
        int filasActualizadas = stmt.executeUpdate();
        return filasActualizadas > 0; // Devuelve true si se actualizaron filas
    } catch (SQLException e) {
        System.out.println("Error al cerrar la cocina():"+e);
        return false;
    }
}
   public Ordenes obtenerOrdenPorId(Connection conn, int idOrden) {
    // Usamos los nombres de columna correctos: order_id, quantity, total, state, customer_customer_id, pizza_pizza_id
    String sql = "SELECT order_id, quantity, total, state, customer_customer_id, pizza_pizza_id " +
                 "FROM orders WHERE order_id = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idOrden);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            return new Ordenes(
                rs.getInt("order_id"),
                rs.getInt("quantity"),
                rs.getDouble("total"),
                rs.getInt("state"),  // 'state' es el nombre correcto
                rs.getInt("customer_customer_id"),
                rs.getInt("pizza_pizza_id")
            );
        } else {
            System.out.println("No se encontró la orden con id: " + idOrden);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener la orden: " + e.getMessage());
    }
    return null;
}



}
