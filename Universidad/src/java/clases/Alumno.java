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
    private Double prac1;
    private Double prac2;
    private Double ep1;
    private Double ef1;
    private Double ef2;
    private Double trabajos1;
    private Double trabajos2;
    private Double trabajos3;

    public Alumno(Double prac1, Double prac2, Double ep1, Double ef1, Double ef2, Double trabajos1, Double trabajos2, Double trabajos3) {
        this.prac1 = prac1;
        this.prac2 = prac2;
        this.ep1 = ep1;
        this.ef1 = ef1;
        this.ef2 = ef2;
        this.trabajos1 = trabajos1;
        this.trabajos2 = trabajos2;
        this.trabajos3 = trabajos3;
    }

    public Double getPrac1() {
        return prac1;
    }

    public Double getPrac2() {
        return prac2;
    }

    public Double getEp1() {
        return ep1;
    }

    public Double getEf1() {
        return ef1;
    }

    public Double getEf2() {
        return ef2;
    }

    public Double getTrabajos1() {
        return trabajos1;
    }

    public Double getTrabajos2() {
        return trabajos2;
    }

    public Double getTrabajos3() {
        return trabajos3;
    }
    public double PromedioFinal(){
       Double pf=0.0;
       
       pf=getPrac1()+getPrac2()+getEp1()+getEf1()+getEf2()+getTrabajos1()+getTrabajos2()+getTrabajos3();
       return pf/8;
    }
}
