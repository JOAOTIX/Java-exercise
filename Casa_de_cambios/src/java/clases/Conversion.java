/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Alumno
 */
public class Conversion {
    private Double soles;
    private Double dolares=3.65;

    public Conversion(Double soles) {
        this.soles = soles;
    }

    public Double getSoles() {
        return soles;
    }

    public Double getDolares() {
        return dolares;
    }
    public Double Soles_a_Dolares(){
       Double conversion=0.0;
       
       conversion=getSoles()/getDolares();
       
       return conversion;
    }
}
