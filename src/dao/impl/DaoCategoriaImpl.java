package dao.impl;

import dao.DaoCategoria;
import entidad.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;

public class DaoCategoriaImpl implements DaoCategoria {

    private final Conexion conexion;
    private String mensaje;

    public DaoCategoriaImpl() {
        conexion = new Conexion();
    }

    @Override
    public List<Categoria> categoriaSel() {
        List<Categoria> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("nombre,")
                .append("descripcion ")
                .append("FROM categoria");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt(1));
                categoria.setNombre(rs.getString(2));
                categoria.setDescripcion(rs.getString(3));
                lista.add(categoria);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return lista;
    }

    @Override
    public Categoria categoriaGet(Integer id) {
        Categoria categoria = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("nombre,")
                .append("descripcion ")
                .append("FROM categoria ")
                .append("WHERE id = ?");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            categoria = new Categoria();
            if (rs.next()) {                
                categoria.setId(rs.getInt(1));
                categoria.setNombre(rs.getString(2));
                categoria.setDescripcion(rs.getString(3));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return categoria;
    }

    @Override
    public String categoriaIns(Categoria categoria) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO categoria(")
                .append("nombre,")
                .append("descripcion ")
                .append(") VALUES (?,?)");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());            
            int resultado = ps.executeUpdate();
            if (resultado == 0){
                mensaje = "Cero registros agregados";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;        
    }

    @Override
    public String categoriaUpd(Categoria categoria) {
     StringBuilder sql = new StringBuilder();
        sql.append("UPDATE categoria SET ")
                .append("nombre = ?,")
                .append("descripcion = ? ")
                .append("WHERE id = ?");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());  
            ps.setInt(3, categoria.getId());
            int resultado = ps.executeUpdate();
            if (resultado == 0){
                mensaje = "Cero registros actualizados";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;   
    }

    @Override
    public String categoriaDel(Integer id) {
       StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM categoria")
                .append(" WHERE id = ?");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);          
            int resultado = ps.executeUpdate();
            if (resultado == 0){
                mensaje = "Cero registros eliminados";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;  
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

}
