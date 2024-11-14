
package dao;

import entidad.Vendedor1;
import java.util.List;

public interface DaoVendedor {
     List<Vendedor1> vendedorSel();
    Vendedor1 vendedorGet(Integer codigo);
    String vendedorIns(Vendedor1 vendedor);
    String vendedorUpd(Vendedor1 vendedor);
    String vendedorDel(Integer codigo);
    String getMensaje();

}
