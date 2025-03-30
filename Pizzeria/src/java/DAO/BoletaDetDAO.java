package DAO;

import model.BoletaDet;
import model.ConectarBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoletaDetDAO {

    // Método para insertar un detalle de boleta
    public void insertarBoletaDet(BoletaDet detalle) {
        String sql = "INSERT INTO boleta_det (numBol, codProd, cant, punt, importe) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConectarBD.abrir();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, detalle.getNumBol());
            stmt.setString(2, detalle.getCodProd());
            stmt.setInt(3, detalle.getCant());
            stmt.setDouble(4, detalle.getPunt());
            stmt.setDouble(5, detalle.getImporte());

            stmt.executeUpdate();
            System.out.println("Detalle de boleta registrado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al insertar detalle de boleta: " + e.getMessage());
        }
    }

    // Método para obtener los detalles de una boleta por su número
    public List<BoletaDet> obtenerDetallesPorBoleta(String numBol) {
        List<BoletaDet> lista = new ArrayList<>();
        String sql = "SELECT codProd, cant, punt, importe FROM boleta_det WHERE numBol = ?";

        try (Connection conn = ConectarBD.abrir();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, numBol);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                BoletaDet detalle = new BoletaDet(
                    numBol,
                    rs.getString("codProd"),
                    rs.getInt("cant"),
                    rs.getDouble("punt")
                );
                lista.add(detalle);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener detalles de la boleta: " + e.getMessage());
        }
        return lista;
    }
}
