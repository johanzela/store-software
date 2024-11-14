
package dao;

import entidad.Producto;
import java.util.List;

public interface DaoProducto {
    List<Producto> productoSel();
    Producto productoGet(Integer id);
    String productoIns(Producto producto);
    String productoUpd(Producto producto);
    String productoDel(Integer id);
    String getMensaje();
}
