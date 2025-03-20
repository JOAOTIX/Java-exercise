/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Alumno
 */
public class GestorBD {

    public static Connection cn;
    public Statement stm;
    public ResultSet rs;

    public boolean ConsultarUsuario(String user, String password) {
        String sql;
        try {
            cn = ConectarBD.abrir();
            stm = cn.createStatement();
            sql="select * from tbusuarios where"
                    + " USUARIO='" + user + "' and CLAVE='" + password + "' ";
            rs = stm.executeQuery(sql);
            if (rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.out.println("ERROR:" + e);
            return false;
        }
    }
}
