/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios;

/**
 *
 * @author Alumno
 */
public class Alumno {
    private String name;
    private String apellidos;
    private Double promedio;

    public Alumno(String name, String apellidos, Double promedio) {
        this.name = name;
        this.apellidos = apellidos;
        this.promedio = promedio;
    }

    public String getName() {
        return name;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Double getPromedio() {
        return promedio;
    }
    
}
