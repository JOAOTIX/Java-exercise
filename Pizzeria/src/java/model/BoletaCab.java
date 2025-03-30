/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Deku
 */
public class BoletaCab {

    private String numBol;
    private String fecha;
    private String dniCli;
    private double imp;
    private double igv;
    private double total;

    // Constructor
    public BoletaCab(String numBol, String fecha, String dniCli, double imp, double igv, double total) {
        this.numBol = numBol;
        this.fecha = fecha;
        this.dniCli = dniCli;
        this.imp = imp;
        this.igv = igv;
        this.total = total;
    }

    // Getters y Setters
    public String getNumBol() {
        return numBol;
    }

    public void setNumBol(String numBol) {
        this.numBol = numBol;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDniCli() {
        return dniCli;
    }

    public void setDniCli(String dniCli) {
        this.dniCli = dniCli;
    }

    public double getImp() {
        return imp;
    }

    public void setImp(double imp) {
        this.imp = imp;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
