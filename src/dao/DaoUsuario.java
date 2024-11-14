package dao;

import entidad.Usuario;

public interface DaoUsuario {
    
    Usuario usuarioLogin(String nombre, String clave);
    String getMensaje();
    
}
