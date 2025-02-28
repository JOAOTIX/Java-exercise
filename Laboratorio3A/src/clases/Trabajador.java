package clases;

public class Trabajador {

    public int codigo;
    public String nombre;
    public int horas_trabajadas;
    public double tarifa_horaria;

    public double CalcularSueldoBruto() {
        return horas_trabajadas * tarifa_horaria;
    }

    public double CalcularDescuento() {
        double desc = 0;
        if (CalcularSueldoBruto() < 4500) {
            desc = CalcularSueldoBruto() * 0.12;
        } else if (CalcularSueldoBruto() >= 4500 && CalcularSueldoBruto() < 6500) {
            desc = CalcularSueldoBruto() * 0.14;
        } else if (CalcularSueldoBruto() >= 6500) {
            desc = CalcularSueldoBruto() * 0.16;
        }
        return desc;
    }
    public double CalcularSueldoNeto(){
        return CalcularSueldoBruto()-CalcularDescuento();
    }
}
