/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Deku
 */
public class BoletaDet {
    private String numBol;
    private String codProd;
    private int cant;
    private double punt;
    private double importe;

    // Constructor
    public BoletaDet(String numBol, String codProd, int cant, double punt) {
        this.numBol = numBol;
        this.codProd = codProd;
        this.cant = cant;
        this.punt = punt;
        this.importe = cant * punt; // Se calcula automáticamente
    }

    // Getters y Setters
    public String getNumBol() { return numBol; }
    public void setNumBol(String numBol) { this.numBol = numBol; }

    public String getCodProd() { return codProd; }
    public void setCodProd(String codProd) { this.codProd = codProd; }

    public int getCant() { return cant; }
    public void setCant(int cant) { 
        this.cant = cant; 
        this.importe = cant * this.punt; // Recalcular importe
    }

    public double getPunt() { return punt; }
    public void setPunt(double punt) { 
        this.punt = punt; 
        this.importe = this.cant * punt; // Recalcular importe
    }

    public double getImporte() { return importe; }
}

