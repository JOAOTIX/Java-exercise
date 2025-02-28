package clases;
public class Factura {
    private String ruc;
    private String empresa;
    private int unidades;
    private double precio_uni;
    private static int factura_creada=0;
    private static double importe_factura=0;
    public static final String clase="Sunat";
    public Factura(String Ruc,String Empresa,int Unidades, double Precio_uni){
        this.ruc=Ruc;
        this.empresa=Empresa;
        this.unidades=Unidades;
        this.precio_uni=Precio_uni;
        factura_creada++;
        importe_factura+= unidades * precio_uni;
    }
    public Factura(String Ruc,String Empresa){
        this(Ruc,Empresa,10,50);
    }
    public Factura(){
        this("11111111","MN-Global SRL");
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getPrecio_uni() {
        return precio_uni;
    }

    public void setPrecio_uni(double precio_uni) {
        this.precio_uni = precio_uni;
    }

    public static int getFactura_creada() {
        return factura_creada;
    }

    public static void setFactura_creada(int factura_creada) {
        Factura.factura_creada = factura_creada;
    }

    public static double getImporte_factura() {
        return importe_factura;
    }

    public static String getClase() {
        return clase;
    }
    

    
    public double ImporteFacturado(){
        return unidades*precio_uni;
    }
    
}
