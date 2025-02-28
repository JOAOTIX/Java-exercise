package clases;
public class Celular {
    private int numero,segundos_consumidos;
    private double precio_segundo;
    private String usuario;

    public Celular(int numero, double precio_segundo, String usuario) {
        this.numero = numero;
        this.segundos_consumidos = 0;
        this.precio_segundo = precio_segundo;
        this.usuario = usuario;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getSegundos_consumidos() {
        return segundos_consumidos;
    }

    public void setSegundos_consumidos(int segundos_consumidos) {
        this.segundos_consumidos += segundos_consumidos;
    }

    public double getPrecio_segundo() {
        return precio_segundo;
    }

    public void setPrecio_segundo(double precio_segundo) {
        this.precio_segundo = precio_segundo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public double CostoConsumo(){
        return segundos_consumidos*precio_segundo;
    }
    public double IGV(){
        return CostoConsumo()*0.18;
    }
    public double TotalPagar(){
        return CostoConsumo()+IGV();
    }
}
