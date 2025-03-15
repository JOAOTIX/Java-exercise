/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Alumno
 */
public class Calcula {
    private double tInicial;
    private double tFinal;
    private double distancia;
    private double vel;
    private double tTotal;

    public Calcula(String tInicial, String tFinal, String distancia) {
        this.tInicial = Double.parseDouble(tInicial);
        this.tFinal = Double.parseDouble(tFinal);
        this.distancia = Double.parseDouble(distancia);
    }
    public void velocidad(){
        vel= distancia/(tFinal-tInicial);
    }
    public void tiempoTotal(){
        tTotal= tFinal-tInicial;
    }
    public double getVel() {
        return vel;
    }

    public double gettTotal() {
        return tTotal;
    }
    
    
}
