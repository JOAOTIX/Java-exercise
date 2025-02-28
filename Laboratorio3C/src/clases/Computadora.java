/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Alumno
 */
public class Computadora {
    private int codigo;
    private String marca,color;
    private double dolares;
    private final double euros=1.20;
    private final double soles=3.25;

    public Computadora(int codigo, String marca, String color, double dolares) {
        this.codigo = codigo;
        this.marca = marca;
        this.color = color;
        this.dolares = dolares;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getDolares() {
        return dolares;
    }

    public void setDolares(double dolares) {
        this.dolares = dolares;
    }
    public double PrecioSoles(){
        return dolares*soles;
    }
    public double PrecioEuros(){
        return dolares*euros;
    }
}
