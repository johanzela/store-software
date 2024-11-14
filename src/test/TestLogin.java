
package test;

import dao.DaoUsuario;
import dao.impl.DaoUsuarioImpl;
import entidad.Usuario;

public class TestLogin {


    public static void main(String[] args) {
        DaoUsuario dao = new DaoUsuarioImpl();
        
        try {
            Usuario user = dao.usuarioLogin("ADMIN", "1234");
            System.out.println("Nombre:" + user.getNombre());
        } catch (Exception e) {
            System.out.println(dao.getMensaje());
        }
    
    }
    
}
