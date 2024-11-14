package dao.impl;

import dao.DaoUsuario;
import entidad.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.Conexion;

public class DaoUsuarioImpl implements DaoUsuario {

    private final Conexion conexion;
    private String mensaje;

    public DaoUsuarioImpl() {
        conexion = new Conexion();
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public Usuario usuarioLogin(String nombre, String clave) {
        Usuario usuario = null;
        StringBuilder sql = new StringBuilder();
         sql.append("SELECT ")
                .append("id,")
                .append("nombre ")
                .append("FROM usuario ")
                .append("WHERE nombre = ? AND AES_DECRYPT(clave, ?) = ?");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, nombre);          
            ps.setString(2, clave);
            ps.setString(3, clave);
            ResultSet resultado = ps.executeQuery();
            usuario = new Usuario();
            if (resultado.next()){
                usuario.setId(resultado.getInt(1));
                usuario.setNombre(resultado.getString(2));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return usuario;  

    }

}
