package KeepStyleJZ;

import KeepStyleJZ.Persona;

public class Vendedor extends Persona {

    protected String codigoTrabajador;

    public Vendedor(String codigoTrabajador,String dni, String nombres, String apellidos) {
        super(dni, nombres, apellidos);
        this.codigoTrabajador = codigoTrabajador;
    }

    public String getCodigoTrabajador() {
        return codigoTrabajador;
    }

    public void setCodigoTrabajador(String codigoTrabajador) {
        this.codigoTrabajador = codigoTrabajador;
    }

    @Override
    public String mostrarInfoDetallado() {
        return "Nombre: "+getNombres()+"\nApellido: "+getApellidos()+"\nDNI: "+getDni()+"\nID: "+codigoTrabajador;
    }
    @Override
    public String mostrarInfo() {
        return "Nombre: "+getNombres()+"\nApellido: "+getApellidos()+"\nDNI: "+getDni();
    }
    
    
    

}
