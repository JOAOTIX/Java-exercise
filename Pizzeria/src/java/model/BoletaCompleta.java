package model;

public class BoletaCompleta {
    private String numBol;
    private String fecha;
    private String dniCli;
    private String clienteNombre;
    private String codProd;
    private String productoNombre;
    private int cant;
    private double punt;
    private double importe;
    private double igv;
    private double total;

    // Constructor
    public BoletaCompleta(String numBol, String fecha, String dniCli, String clienteNombre,
                           String codProd, String productoNombre, int cant, double punt,
                           double importe, double igv, double total) {
        this.numBol = numBol;
        this.fecha = fecha;
        this.dniCli = dniCli;
        this.clienteNombre = clienteNombre;
        this.codProd = codProd;
        this.productoNombre = productoNombre;
        this.cant = cant;
        this.punt = punt;
        this.importe = importe;
        this.igv = igv;
        this.total = total;
    }

    // Getters y setters...
    public String getNumBol() { return numBol; }
    public String getFecha() { return fecha; }
    public String getDniCli() { return dniCli; }
    public String getClienteNombre() { return clienteNombre; }
    public String getCodProd() { return codProd; }
    public String getProductoNombre() { return productoNombre; }
    public int getCant() { return cant; }
    public double getPunt() { return punt; }
    public double getImporte() { return importe; }
    public double getIgv() { return igv; }
    public double getTotal() { return total; }
}
