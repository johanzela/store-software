/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import dao.DaoProducto;
import dao.impl.DaoProductoImpl;
import entidad.Producto;
import java.util.List;

/**
 *
 * @author luisd
 */
public class TextCrudProducto {

    public static void main(String[] args) {
       DaoProducto dao = new DaoProductoImpl();
        /*
        // Probar SELECT
        try {
            List<Producto> lista = dao.productoSel();
            lista.forEach(t->System.out.println(t.getId()+"--"+t.getPrecio()));
        } catch (Exception e) {
            dao.getMensaje();
        }
       
        // Probar SELECT
        try {
            Producto cat = dao.productoGet(1);
            System.out.println(cat.getNombre());
        } catch (Exception e) {
            dao.getMensaje();
        }
       
  
        // Probar INSERT
        try {
            Producto cat = new Producto(null, "Camisa", "Verano","20");
            System.out.println(dao.productoIns(cat));
        } catch (Exception e) {
            dao.getMensaje();
        }
        
        */
        // Probar UPDATE
        try {
            Producto cat = new Producto(3, "Blusa", "Verano","35");
            System.out.println(dao.productoUpd(cat));
        } catch (Exception e) {
            dao.getMensaje();
        }
        
     
       /*
        try {            
            System.out.println(dao.productoDel(3));
        } catch (Exception e) {
            dao.getMensaje();
        }
        */
    }
    
}
