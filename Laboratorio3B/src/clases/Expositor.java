/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Alumno
 */
public class Expositor {
    public int code;
    public String name;
    public double tarifa_hora;
    public int horas_trabajadas;
    //Metodos
    public double CalcularSueldoBruto(){
        return horas_trabajadas*tarifa_hora;
    }
    public double DescuentoAfp(){
        return CalcularSueldoBruto()*0.10;
    }
    public double DescuentoEps(){
        return CalcularSueldoBruto()*0.05;
    }
    public double CalcularSueldoNeto(){
        return (CalcularSueldoBruto()-DescuentoAfp())-DescuentoEps();
    }
}
