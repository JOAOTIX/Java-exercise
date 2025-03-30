package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.BoletaCab;
import model.BoletaCompleta;
import model.BoletaDet;

public class BoletaCompletaDAO {

    public List<BoletaCompleta> obtenerBoletasCompletas(Connection conn) {
        List<BoletaCompleta> lista = new ArrayList<>();

        // La consulta combina la cabecera y el detalle, y une además con customer y pizza para traer nombres.
        // Se asume que:
        // - boleta_cab: NumBol, Fecha, DNIcli, Imp, Igv, Total, Estado (si es necesario)
        // - bolet_det: NumBol, CodProd, Cant, Punt, Importe
        // - customer: dni, name, last_name
        // - pizza: pizza_id, name
        //
        // La consulta asume que en boleta_det, CodProd es el código del producto y corresponde al pizza_id de la tabla pizza,
        // convirtiéndolo a cadena para la comparación.
         String sql = "SELECT bc.NumBol, bc.Fecha, bc.DNIcli, " +
                     "CONCAT(c.name, ' ', c.last_name) AS cliente_nombre, " +
                     "bd.CodProd, p.name AS producto_nombre, " +
                     "bd.Cant, bd.Punt, bd.Importe, " +
                     "bc.Igv, bc.Total " +
                     "FROM boleta_cab bc " +
                     "JOIN boleta_det bd ON bc.NumBol = bd.NumBol " +
                     "LEFT JOIN customer c ON bc.DNIcli = c.dni " +
                     "LEFT JOIN pizza p ON bd.CodProd = CAST(p.pizza_id AS CHAR) " +
                     "WHERE bc.Estado = 0";  // Por ejemplo, solo boletas abiertas

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                BoletaCompleta bc = new BoletaCompleta(
                    rs.getString("NumBol"),
                    rs.getString("Fecha"),
                    rs.getString("DNIcli"),
                    rs.getString("cliente_nombre"),
                    rs.getString("CodProd"),
                    rs.getString("producto_nombre"),
                    rs.getInt("Cant"),
                    rs.getDouble("Punt"),
                    rs.getDouble("Importe"),
                    rs.getDouble("Igv"),
                    rs.getDouble("Total")
                );
                lista.add(bc);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener boletas completas: " + e.getMessage());
        }
        return lista;
    }
}
