
package dao.impl;

import dao.DaoProducto;
import entidad.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;

public class DaoProductoImpl implements DaoProducto {
    private final Conexion conexion;
    private String mensaje;
    
    public DaoProductoImpl() {
        conexion = new Conexion();
    }
///////////////////////////
    
    @Override
    public List<Producto> productoSel() {
        List<Producto> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("nombre,")
                .append("categoria,")
                .append("precio ")
                .append("FROM producto");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setCategoria(rs.getString(3));
                producto.setPrecio(rs.getString(4));
                lista.add(producto);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return lista;
    }
    
    //////////////////////////
    @Override
    public Producto productoGet(Integer id) {
        Producto producto = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("nombre,")
                .append("categoria,")
                .append("precio ")
                .append("FROM producto ")
                .append("WHERE id = ?");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            producto = new Producto();
            if (rs.next()) {                
                producto.setId(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setCategoria(rs.getString(3));
                producto.setPrecio(rs.getString(4));
                
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return producto;
    }
    /////////////////////
    @Override
    public String productoIns(Producto producto) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO producto(")
                .append("nombre,")
                .append("categoria,")
                .append("precio ")
                .append(") VALUES (?,?,?)");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getCategoria()); 
            ps.setString(3, producto.getPrecio()); 
            int resultado = ps.executeUpdate();
            if (resultado == 0){
                mensaje = "Cero registros agregados";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;        
    }
///////////////////////////////////
    
    
     @Override
    public String productoUpd(Producto producto) {
     StringBuilder sql = new StringBuilder();
        sql.append("UPDATE producto SET ")
                .append("nombre = ?,")
                .append("categoria = ?,")
                .append("precio = ? ")
                .append("WHERE id = ?");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getCategoria());  
            ps.setString(3, producto.getPrecio());  
            ps.setInt(4, producto.getId());
            int resultado = ps.executeUpdate();
            if (resultado == 0){
                mensaje = "Cero registros actualizados";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;   
    }
    
    ///////////////////
    
    
     @Override
    public String productoDel(Integer id) {
       StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM producto")
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
/////////
    @Override
    public String getMensaje() {
        return mensaje;
    }

    
    
}
