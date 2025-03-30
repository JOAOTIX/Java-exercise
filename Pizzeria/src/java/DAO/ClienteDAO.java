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
import model.Cliente;
import model.ConectarBD;

/**
 *
 * @author Deku
 */
public class ClienteDAO {

    public static Connection cn;
    public Statement stm;
    public ResultSet rs;
    public String sql;

    public boolean ConsultarCliente(String dni) {
        Connection connection = ConectarBD.abrir();
        String query = "SELECT customer_id FROM customer where dni = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, dni);
            ResultSet result = statement.executeQuery();
            return result.next();
        } catch (SQLException e) {
            System.out.println("Error al consultar el cliente: " + e.getMessage());
            return false;
        } finally {
            ConectarBD.cerrar();
        }
    }

   public int CrearCliente(Cliente cli) {
    Connection connection = ConectarBD.abrir();
    String query = "INSERT INTO customer (dni, name, last_name) VALUES (?, ?, ?)";
    try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
        statement.setString(1, cli.getDni());
        statement.setString(2, cli.getName());
        statement.setString(3, cli.getApellido());

        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) {
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al crear cliente: " + e.getMessage());
    } finally {
        ConectarBD.cerrar();
    }
    return -1; 
}
public int obtenerIdCliente(String dni) {
    Connection connection = ConectarBD.abrir();
    String query = "SELECT customer_id FROM customer WHERE dni = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, dni);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("customer_id");
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener ID del cliente: " + e.getMessage());
    } finally {
        ConectarBD.cerrar();
    }
    return -1; 
}
public String obtenerDniCliente(Connection conn, int idCliente) {
    String sql = "SELECT dni FROM customer WHERE customer_id = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idCliente);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getString("dni");
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener DNI del cliente: " + e.getMessage());
    }
    return null;
}

}
