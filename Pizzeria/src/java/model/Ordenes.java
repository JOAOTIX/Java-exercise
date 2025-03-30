package model;

public class Ordenes {

    private int id_orden;
    private int cantidad;
    private double total;
    private int estado;
    private int id_cliente;
    private int id_pizza;
    private String clienteNombre;
    private String pizzaNombre;

    public Ordenes(int id_orden, int cantidad, double total, int estado, int id_cliente, int id_pizza) {
        this.id_orden = id_orden;
        this.cantidad = cantidad;
        this.total = total;
        this.estado = estado;
        this.id_cliente = id_cliente;
        this.id_pizza = id_pizza;
    }

    public Ordenes(int cantidad, double total, int estado, int id_cliente, int id_pizza) {
        this.cantidad = cantidad;
        this.total = total;
        this.estado = estado;
        this.id_cliente = id_cliente;
        this.id_pizza = id_pizza;
    }

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_pizza() {
        return id_pizza;
    }

    public void setId_pizza(int id_pizza) {
        this.id_pizza = id_pizza;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getPizzaNombre() {
        return pizzaNombre;
    }

    public void setPizzaNombre(String pizzaNombre) {
        this.pizzaNombre = pizzaNombre;
    }
}
