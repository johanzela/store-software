package KeepStyleJZ;

import interfaces.InterfaceBoleta;

public class Boleta extends DetalleVenta implements InterfaceBoleta 
{

   private String codigoVendedor;
   private Producto producto;
    private DetalleVenta venta;
    private String nuevoCliente;

    public Boleta(String idDetalle, Double totalDetalle) {
        super(idDetalle, totalDetalle);
    }
    
//************

    
//************

    public Boleta( String idDetalle,String nuevoCliente,String codigoVendedor, Double totalDetalle) {
        super(idDetalle, totalDetalle);
        this.codigoVendedor = codigoVendedor;
        this.nuevoCliente = nuevoCliente;
    }

    public String getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(String codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public DetalleVenta getVenta() {
        return venta;
    }

    public void setVenta(DetalleVenta venta) {
        this.venta = venta;
    }

    public String getNuevoCliente() {
        return nuevoCliente;
    }

    public void setNuevoCliente(String nuevoCliente) {
        this.nuevoCliente = nuevoCliente;
    }

  


    @Override
    public String emitirDetalleDeVenta() {
        return "Nombre del producto: " + producto
                + "\nCantidad: " + cantidad
                + "\nPrecio Unitario" + precio
                + "\nSubtotal:" + totalDetalle
                + "\nTotal: " + totalDetalle;
    }

    @Override
    public String emitirBoleta() {
        return "Nombre del producto: " + producto
                + "\nCantidad: " + cantidad
                + "\nPrecio Unitario" + precio
                + "\nSubtotal:" + totalDetalle
                + "\nTotal: " + totalDetalle
               + "\nCliente: " +nuevoCliente
                + "\nVendedor" + codigoVendedor;
    }

}
