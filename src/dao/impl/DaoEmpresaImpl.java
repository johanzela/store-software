
package dao.impl;


import dao.DaoEmpresa;
import entidad.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;

public class DaoEmpresaImpl implements DaoEmpresa{
    private final Conexion conexion;
    private String mensaje;

    public DaoEmpresaImpl() {
        conexion = new Conexion();
    }

    @Override
    public List<Empresa> empresaSel() {
        List<Empresa> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("ruc,")
                .append("nombre,")
                .append("direccion,")
                .append("telefono ")
                .append("FROM empresa");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setRuc(rs.getString(1));
                empresa.setNombre(rs.getString(2));
                empresa.setDireccion(rs.getString(3));
                empresa.setTelefono(rs.getString(4));
                lista.add(empresa);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return lista;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

}
