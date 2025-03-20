
package clases;

public class Sueldo {
    private  String nombre;
    private Double  sueldo;
    private Double dias;
    private Double sueldo_total;

    public Sueldo(String nombre, String sueldo, String dias) {
        this.nombre = nombre;
        this.sueldo = Double.parseDouble(sueldo);
        this.dias = Double.parseDouble(dias);
    }
    public String getNombre() {
        return nombre;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public Double getDias() {
        return dias;
    }
     public void CalcularSueldo(){
        sueldo_total= getDias()*getSueldo();
    }
    public Double getSueldo_total() {
        return sueldo_total;
    }
    
}
