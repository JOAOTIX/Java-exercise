
package clases;

/**
 *
 * @author Deku
 */
public class Producto {
    private int id;
    private String name;
    private String descrip;
    private int stock;
    private String categoria;
    private double pventa;
    private double pcompra;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPventa() {
        return pventa;
    }

    public void setPventa(double pventa) {
        this.pventa = pventa;
    }

    public double getPcompra() {
        return pcompra;
    }

    public void setPcompra(double pcompra) {
        this.pcompra = pcompra;
    }
}
