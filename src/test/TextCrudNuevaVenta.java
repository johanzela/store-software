/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import dao.DaoNuevaVenta;
import dao.impl.DaoNuevaVentaImpl;
import entidad.NuevaVenta;
import java.util.List;

/**
 *
 * @author luisd
 */
public class TextCrudNuevaVenta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DaoNuevaVenta dao = new DaoNuevaVentaImpl();
        /*
        // Probar SELECT
        try {
            List<NuevaVenta> lista = dao.nuevaventaSel();
            lista.forEach(t->System.out.println(t.getCantidad()+"--"+t.getCliente()));
        } catch (Exception e) {
            dao.getMensaje();
        }
       
        // Probar SELECT
        try {
            NuevaVenta cat = dao.nuevaventaGet(1);
            System.out.println(cat.getCantidad());
        } catch (Exception e) {
            dao.getMensaje();
        }
       
  
        // Probar INSERT
        try {
            NuevaVenta cat = new NuevaVenta(null, "Juan", "Rodriguez", 12, "12", "144");
            System.out.println(dao.nuevaventaIns(cat));
        } catch (Exception e) {
            dao.getMensaje();
        }
        
       */
        // Probar UPDATE
        try {
            NuevaVenta cat = new NuevaVenta(1, "Juan", "Polo", 10, "12", "120");
            System.out.println(dao.nuevaventaUpd(cat));
        } catch (Exception e) {
            dao.getMensaje();
        }
        
     //borrar
       /*
        try {            
            System.out.println(dao.nuevaventaDel(3));
        } catch (Exception e) {
            dao.getMensaje();
        }*/
       
    }
    
}
