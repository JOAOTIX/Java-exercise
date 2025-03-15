/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Alumno
 */
public class Alumno {
    private String nombre;
    private String apellidos;
    private Double promedio;

    public Alumno(String nombre, String apellidos, Double promedio) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.promedio = promedio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Double getPromedio() {
        return promedio;
    }

    public String toString() {
        return ( nombre + " " + apellidos + "  tiene un promedio: " + promedio);
    }
    
    
}
