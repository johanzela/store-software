
package dao;

import entidad.NuevaVenta;
import java.util.List;

/**
 *
 * @author luisd
 */
public interface DaoNuevaVenta {
     List<NuevaVenta> nuevaventaSel();
    NuevaVenta nuevaventaGet(Integer id);
    String nuevaventaIns(NuevaVenta nuevaventa);
    String nuevaventaUpd(NuevaVenta nuevaventa);
    String nuevaventaDel(Integer id);
    String getMensaje();
    
}
