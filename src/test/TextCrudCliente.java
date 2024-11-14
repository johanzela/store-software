
package test;

import dao.DaoCliente;
import dao.impl.DaoClienteImpl;
import entidad.Cliente;
import java.util.List;

public class TextCrudCliente {

   
    public static void main(String[] args) {
        DaoCliente dao = new DaoClienteImpl();
        /*
        // Probar SELECT
        try {
            List<Cliente> lista = dao.clienteSel();
            lista.forEach(t->System.out.println(t.getId()+"--"+t.getNombre()));
        } catch (Exception e) {
            dao.getMensaje();
        }
       
        // Probar SELECT
        try {
            Cliente cat = dao.clienteGet(1);
            System.out.println(cat.getNombre());
        } catch (Exception e) {
            dao.getMensaje();
        }
       
  
        // Probar INSERT
        try {
            Cliente cat = new Cliente(null, "74727124", "Juan", "Martinez", "924822168", "juan@gmail.com");
            System.out.println(dao.clienteIns(cat));
        } catch (Exception e) {
            dao.getMensaje();
        }
        
        */
        // Probar UPDATE
        try {
            Cliente cat = new Cliente(3, "74727124", "Juan", "Martinez", "924822168", "juan@gmail.com");
            System.out.println(dao.clienteUpd(cat));
        } catch (Exception e) {
            dao.getMensaje();
        }
        
     /*
       
        try {            
            System.out.println(dao.clienteDel(3));
        } catch (Exception e) {
            dao.getMensaje();
        }*/
        
    }
    
}
