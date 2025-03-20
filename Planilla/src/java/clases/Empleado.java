/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Alumno
 */
public class Empleado {
    private String nombre;
    private String ape;
    private Double horas;
    private Double th=15.00;
    private double afp=0.1;

    public Empleado(String nombre, String ape, Double horas) {
        this.nombre = nombre;
        this.ape = ape;
        this.horas = horas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApe() {
        return ape;
    }

    public Double getHoras() {
        return horas;
    }

    public Double getTh() {
        return th;
    }

    public double getAfp() {
        return afp;
    }
    public double sueldo_bruto(){
        return getHoras()*th;
    }
    public double aplica_afp(){
        return sueldo_bruto()*getAfp();
    }
    public double sueldo_neto(){
        return sueldo_bruto()-aplica_afp();
    }
    
}
