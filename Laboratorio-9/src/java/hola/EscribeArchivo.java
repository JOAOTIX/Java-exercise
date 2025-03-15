/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hola;

import clases.Alumno;
import java.io.*;

/**
 *
 * @author Alumno
 */
public class EscribeArchivo {

    public static void add(Alumno a, String path) throws IOException {
        File archivo;
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            archivo = new File(path);
            fw = new FileWriter(archivo,true);
            pw = new PrintWriter(fw);
            pw.println(a.getNombre() + "," + a.getApellidos() + "," + a.getPromedio());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
