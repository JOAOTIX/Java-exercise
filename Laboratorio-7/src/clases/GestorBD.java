
package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class GestorBD {
    Connection cn;
     Statement stm;
     ResultSet rs;
      
     Basedatos bd=new Basedatos();
    public boolean verificarUsuario(String user,String password){
        try {
            cn=bd.abrir();
            stm = cn.createStatement();
            String sql="select * from tbusuarios where usuario='"+user+"' and clave='"+password+"'";
            rs = stm.executeQuery(sql);
            if(rs.next())
                return true;
             else
                return false;
        } catch (Exception e) {
            System.out.println("ERROR:" + e);
        }
       return false;
    }
}
