package KeepStyleJZ;

import KeepStyleJZ.Persona;

public class Cliente extends Persona {
    private String idCliente;
    private String telefono;
    private String correo;
    private Persona persona;
    

    public Cliente(String telefono, String correo, Persona persona, String idCliente, String dni, String nombres, String apellidos) {
        super(dni, nombres, apellidos);
        this.telefono = telefono;
        this.correo = correo;
        this.persona = persona;
        this.idCliente = idCliente;
    }

    public Cliente(String idCliente,String dni,String nombres, String apellidos, String telefono, String correo) {
        super(dni, nombres, apellidos);
        this.idCliente = idCliente;
        this.telefono = telefono;
        this.correo = correo;
    }
    
    

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
        
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }


    @Override
    public String mostrarInfoDetallado() {
        return "Nombre: "+getNombres()+"\nApellido: "+getApellidos()+"\nDNI: "+getDni()+"\nTelefono: "+telefono+"\nCorreo: "+correo+"\nID: "+idCliente;
    }
    @Override
    public String mostrarInfo() {
        return "Nombre: "+getNombres()+"\nApellido: "+getApellidos()+"\nDNI: "+getDni();
    }

    
    
    
    
}

