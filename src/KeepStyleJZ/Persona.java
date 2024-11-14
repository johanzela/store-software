package KeepStyleJZ;

import javax.swing.JOptionPane;

public abstract class  Persona {

    private String dni;
    private String nombres;
    private String apellidos;

    public Persona(String dni, String nombres, String apellidos) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String iniciarSesion() {
        return "ingresar";
    }

    public String cerrarSesion() {
        return "salir";
    }
    
    public abstract String mostrarInfoDetallado();
    public abstract String mostrarInfo();


}
