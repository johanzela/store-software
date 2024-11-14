package test;

import java.sql.Connection;
import util.Conexion;

public class TestConexion {

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        try (Connection cn = conexion.getConexion()){
            System.out.println("OK");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
