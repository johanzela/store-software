package test;

import java.util.Scanner;
import KeepStyleJZ.Boleta;
import KeepStyleJZ.Cliente;
import KeepStyleJZ.Persona;

import java.util.Scanner;
import KeepStyleJZ.Producto;
import javax.swing.JOptionPane;

public class Test {

    public static void main(String[] args) {

        String nombres, apellidos, dni, telefono, correo;

        nombres = JOptionPane.showInputDialog("Ingrese su nombre");
        apellidos = JOptionPane.showInputDialog("Ingrese su apellido");
        do {
            dni = JOptionPane.showInputDialog("Ingrese su DNi");
            if (dni.length() != 8) {
                JOptionPane.showMessageDialog(null, "Dato invalido");

            }
        } while (dni.length() != 8);
        do {
            telefono = JOptionPane.showInputDialog("Ingrese su numero de telefono");
            if (telefono.length() != 9) {
                JOptionPane.showMessageDialog(null, "Dato invalido");

            }
        } while (telefono.length() != 9);
        correo = JOptionPane.showInputDialog("Ingrese su correo");

//Persona persona1=new Cliente(telefono, correo, dni, nombres, apellidos);
//persona1.mostrarinfo();
     
       
    }
}