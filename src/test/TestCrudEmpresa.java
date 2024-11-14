
package test;

import dao.DaoEmpresa;
import dao.impl.DaoEmpresaImpl;
import entidad.Empresa;
import java.util.List;


public class TestCrudEmpresa {

  
    public static void main(String[] args) {
      DaoEmpresa dao = new DaoEmpresaImpl();
        
        // Probar SELECT
        try {
            List<Empresa> lista = dao.empresaSel();
            lista.forEach(t->System.out.println(t.getNombre()+"--"+t.getRuc()));
        } catch (Exception e) {
            dao.getMensaje();
        }
    }
    
}
