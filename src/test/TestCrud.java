package test;

import dao.DaoVendedor;
import dao.impl.DaoVendedorImpl;
import entidad.Vendedor1;
import java.sql.Connection;
import java.util.List;
import util.Conexion;

public class TestCrud {

    public static void main(String[] args) {
                
        DaoVendedor dao = new DaoVendedorImpl();
        
        // Probar SELECT
        try {
            List<Vendedor1> lista = dao.vendedorSel();
            lista.forEach(t->System.out.println(t.getApellido()+"--"+t.getCodigo()));
        } catch (Exception e) {
            dao.getMensaje();
        }
       /*
        // Probar SELECT
        try {
            Vendedor1 cat = dao.vendedorGet(1);
            System.out.println(cat.getApellido());
        } catch (Exception e) {
            dao.getMensaje();
        }
       
  
        // Probar INSERT
        try {
            Vendedor1 cat = new Vendedor1(null, "86745226", "Nayi","Huatuco");
            System.out.println(dao.vendedorIns(cat));
        } catch (Exception e) {
            dao.getMensaje();
        }*/
        
        /*
        // Probar UPDATE
        try {
            Vendedor1 cat = new Vendedor1(1, "74727124", "Luis","Principe");
            System.out.println(dao.vendedorUpd(cat));
        } catch (Exception e) {
            dao.getMensaje();
        }
        
     
       
        try {            
            System.out.println(dao.vendedorDel(3));
        } catch (Exception e) {
            dao.getMensaje();
        }
        */
        
    }
    
}
