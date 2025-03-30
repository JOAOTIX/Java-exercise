package DAO;

import model.BoletaCab;
import model.ConectarBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoletaCabDAO {
 public String generarNumeroSerie(Connection conn,String tipo) {
        
        int cantidad = 0;

        try {
          
            String sql = "SELECT quantity FROM serie WHERE name = ?"; 
            try (PreparedStatement stmt = conn.prepareStatement(sql)){
                 stmt.setString(1, tipo);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {  
                    cantidad = rs.getInt("quantity"); 
                }
            }

        
            cantidad++;

 
            String updateSql = "UPDATE serie SET quantity = ? WHERE name = ?";
            try (PreparedStatement stmt = conn.prepareStatement(updateSql)) {
                stmt.setInt(1, cantidad);
                stmt.setString(2, tipo);
                stmt.executeUpdate();
            }

        
            return String.format("%s-%04d", tipo, cantidad);

        } catch (SQLException e) {
            System.out.println("Error en el numerosSerie()"+e.getMessage());
        }
        return null;
    }

    // Método para insertar una boleta en la base de datos
    public void insertarBoleta(BoletaCab boleta) {
        String sql = "INSERT INTO boleta_cab (NumBol, Fecha, DNIcli, Igv, Total) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConectarBD.abrir();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, boleta.getNumBol());
            stmt.setString(2, boleta.getFecha());
            stmt.setString(3, boleta.getDniCli());
            stmt.setDouble(4, boleta.getIgv());
            stmt.setDouble(5, boleta.getTotal());

            stmt.executeUpdate();
            System.out.println("Boleta registrada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al insertar boleta: " + e.getMessage());
        }
    }

    // Método para obtener todas las boletas
    public List<BoletaCab> obtenerBoletas() {
        List<BoletaCab> lista = new ArrayList<>();
        String sql = "SELECT NumBol, Fecha, DNIcli, Igv, Total FROM boleta_cab";

        try (Connection conn = ConectarBD.abrir();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                BoletaCab boleta = new BoletaCab(
                    rs.getString("NumBol"),
                    rs.getString("Fecha"),
                    rs.getString("DNIcli"),
                    rs.getDouble("Igv"),
                    rs.getDouble("Total")
                );
                lista.add(boleta);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener boletas: " + e.getMessage());
        }
        return lista;
    }

    // Método para buscar una boleta por número de boleta
    public BoletaCab buscarBoletaPorNumero(String numBol) {
        String sql = "SELECT * FROM boleta_cab WHERE NumBol = ?";
        try (Connection conn = ConectarBD.abrir();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, numBol);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new BoletaCab(
                    rs.getString("NumBol"),
                    rs.getString("Fecha"),
                    rs.getString("DNIcli"),
                    rs.getDouble("Igv"),
                    rs.getDouble("Total")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar boleta: " + e.getMessage());
        }
        return null;
    }

    // Método para cerrar caja (cambiar el estado de las boletas)
    public boolean cerrarCaja() {
        String sql = "UPDATE boleta_cab SET Estado = 1 WHERE estado = 0";
        try (Connection conn = ConectarBD.abrir();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            int filasActualizadas = stmt.executeUpdate();
            return filasActualizadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al cerrar caja: " + e.getMessage());
        }
        return false;
    }
}