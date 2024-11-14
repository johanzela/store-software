package KeepStyleJZ;

public class DetalleVenta extends Producto{

    protected String idDetalle;
    protected Producto producto;
    protected int cantidad;
    protected Double totalDetalle;

    public DetalleVenta(String idDetalle,String nombre, int cantidad,Double precio) {
        super(nombre, precio);
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
        this.totalDetalle = cantidad*precio;
    }

    public DetalleVenta(String idDetalle, Double totalDetalle) {
        this.idDetalle = idDetalle;
        this.totalDetalle = totalDetalle;
    }

    public String getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(String idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Double getTotalDetalle() {
        return totalDetalle;
    }

    public void setTotalDetalle(Double totalDetalle) {
        this.totalDetalle = totalDetalle;
    }

    

 
  
    public double getSubtotal() {
        return totalDetalle;
    }

    public void setSubtotal(double subtotal) {
        this.totalDetalle = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public String caracteristicasCompra() {
        return " ";
    }
}
