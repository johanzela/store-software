
package dao;

import entidad.Empresa;
import java.util.List;

/**
 *
 * @author luisd
 */
public interface DaoEmpresa {
    List<Empresa> empresaSel();
    String getMensaje();
}
