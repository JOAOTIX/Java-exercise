/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Alumno
 */
public class Filmacion {
    public int codigo,duracion_minutos;
    public double precio_soles;
    public String titulo;
    public final  double dolar=3.80;
    
    public double PrecioDolar(){
        double precio_dolar=0;
        
        precio_dolar=(precio_soles*duracion_minutos)*dolar;
             
        return precio_dolar;
    }
}
