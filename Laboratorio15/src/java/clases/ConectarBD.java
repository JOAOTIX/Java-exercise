
package clases;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectarBD {
    public static Connection cn;
    public static String bd="bdempresa?useSSL=false";
    public static String usuario="root";
    public static String password="usbw";
    public static String url="jdbc:mysql://localhost/"+bd;
    
    public static Connection abrir(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn= DriverManager.getConnection(url,usuario,password);
        } catch (Exception e) {
            System.out.println("ERROR:"+e);
            e.printStackTrace();
        }
        return cn;
    }
    public static void cerrar(){
        try {
            if(cn!=null){
                cn.close();
            }
        } catch (Exception e) {
            System.out.println("NO SE PUDO CERRAR LA CONEXION ERROR:"+e);
        }
    }
}
