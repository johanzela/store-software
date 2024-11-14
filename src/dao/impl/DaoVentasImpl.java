
package dao.impl;

import dao.DaoVentas;
import entidad.Ventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;


public class DaoVentasImpl implements DaoVentas{
    private final Conexion conexion;
    private String mensaje;

    public DaoVentasImpl() {
        conexion = new Conexion();
    }

    @Override
    public List<Ventas> ventasSel() {
        List<Ventas> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("cliente,")
                .append("vendedor,")
                .append("total ")
                .append("FROM ventas");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Ventas ventas = new Ventas();
                ventas.setId(rs.getInt(1));
                ventas.setCliente(rs.getString(2));
                ventas.setVendedor(rs.getString(3));
                ventas.setTotal(rs.getString(4));
                lista.add(ventas);
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
