/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.ConectarBD;

/**
 *
 * @author Deku
 */
public class UsuarioDAO {
    public static Connection cn;
    public Statement stm;
    public ResultSet rs;
    public String sql;
    public boolean ConsultarUsuario(String user, String password) {
  Connection connection = ConectarBD.abrir();
        String query = "SELECT * FROM user WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            return result.next();
        } catch (SQLException e) {
            System.out.println("Error al consultarUsuario" + e.getMessage());
            return false;
        } finally {
            ConectarBD.cerrar();
        }
    }
}
