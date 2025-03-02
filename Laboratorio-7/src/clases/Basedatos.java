package clases;

import java.sql.Connection;
import java.sql.DriverManager;
public class Basedatos {
    public static Connection cn;
    private static String bd="bdempresa?useSSL=false";
    public static String usuario ="root";
    public static String clave ="usbw";
    public static String url ="jdbc:mysql://localhost:3306/"+bd;
    
    public static Connection abrir(){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           cn=DriverManager.getConnection(url,usuario,clave);
           
       }catch (Exception e){
           System.err.println("ERROR:"+e);
       }
       return cn;
    }
    public static void cerrar(){
        try{
            if(cn!=null){
                cn.close();
            }
        }catch(Exception e){
            System.err.println("ERORR:" +e);
        }
    }
}
