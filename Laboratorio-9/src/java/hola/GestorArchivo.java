/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hola;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Deku
 */
public class GestorArchivo {

    File archivo;
    FileWriter fw;
    PrintWriter pw;

    public boolean guardarResultado(String r1, String r2,
            String path) throws IOException {
        try {
            archivo = new File(path);
            fw = new FileWriter(archivo, true);
            pw = new PrintWriter(fw);
            pw.println("Raiz 1: " + r1 + " Raiz 2:" + r2);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            fw.close();
        }
    }
}
