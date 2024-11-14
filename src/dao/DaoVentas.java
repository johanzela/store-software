
package dao;

import entidad.Ventas;
import java.util.List;

public interface DaoVentas {
    List<Ventas> ventasSel();
    String getMensaje();
}
