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
import model.Pizza;

/**
 *
 * @author Deku
 */
public class PizzaDAO {

    public static Connection cn;
    public Statement stm;
    public ResultSet rs;
    public String sql;

    public List<Pizza> ConsultarPizzas() {
        Connection connection = ConectarBD.abrir();
        List<Pizza> Pizzas = new ArrayList<>();
        String query = "SELECT * FROM pizza";

        try (PreparedStatement statement = connection.prepareStatement(query); ResultSet rs = statement.executeQuery()) {  

            while (rs.next()) {
                Pizza pizza = new Pizza(rs.getInt("pizza_id"),
                        rs.getString("name"),
                        rs.getDouble("price"));
                Pizzas.add(pizza);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar las pizzas: "+e.getMessage());
        } finally {
            ConectarBD.cerrar();
        }

        return Pizzas;
    }
}
