
package dao.impl;

import dao.DaoNuevaVenta;
import entidad.NuevaVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;


public class DaoNuevaVentaImpl implements DaoNuevaVenta{
    
    
    private final Conexion conexion;
    private String mensaje;

    public DaoNuevaVentaImpl() {
        conexion = new Conexion();
    }

    @Override
    public List<NuevaVenta> nuevaventaSel() {
        List<NuevaVenta> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("cliente,")
                .append("producto,")
                .append("cantidad,")
                .append("precio,")
                .append("total ")
                .append("FROM detalleventa");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                NuevaVenta nuevaventa = new NuevaVenta();
                nuevaventa.setId(rs.getInt(1));
                nuevaventa.setCliente(rs.getString(2));
                nuevaventa.setProducto(rs.getString(3));
                nuevaventa.setCantidad(rs.getInt(4));
                nuevaventa.setPrecio(rs.getString(5));
                nuevaventa.setTotal(rs.getString(6));
                lista.add(nuevaventa);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return lista;
    }

    @Override
    public NuevaVenta nuevaventaGet(Integer id) {
        NuevaVenta nuevaventa = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("cliente,")
                .append("producto,")
                .append("cantidad,")
                .append("precio,")
                .append("total ")
                .append("FROM detalleventa ")
                .append("WHERE id = ?");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            nuevaventa = new NuevaVenta();
            if (rs.next()) {                
                 nuevaventa.setId(rs.getInt(1));
                nuevaventa.setCliente(rs.getString(2));
                nuevaventa.setProducto(rs.getString(3));
                nuevaventa.setCantidad(rs.getInt(4));
                nuevaventa.setPrecio(rs.getString(5));
                nuevaventa.setTotal(rs.getString(6));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return nuevaventa;
    }

    @Override
    public String nuevaventaIns(NuevaVenta nuevaventa) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO detalleventa(")
                .append("cliente,")
                .append("producto,")
                .append("cantidad,")
                .append("precio,")
                .append("total ")
                .append(") VALUES (?,?,?,?,?)");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, nuevaventa.getCliente());
            ps.setString(2, nuevaventa.getProducto());  
            ps.setInt(3, nuevaventa.getCantidad());  
            ps.setString(4, nuevaventa.getPrecio());  
            ps.setString(5, nuevaventa.getTotal());  
            
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
    public String nuevaventaUpd(NuevaVenta nuevaventa) {
     StringBuilder sql = new StringBuilder();
        sql.append("UPDATE detalleventa SET ")
                .append("cliente = ?,")
                .append("producto = ?, ")
                .append("cantidad = ?,")
                .append("precio = ?, ")
                .append("total = ? ")
                .append("WHERE id = ?");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, nuevaventa.getCliente());
            ps.setString(2, nuevaventa.getProducto());  
            ps.setInt(3, nuevaventa.getCantidad());  
            ps.setString(4, nuevaventa.getPrecio());  
            ps.setString(5, nuevaventa.getTotal());  
            ps.setInt(6, nuevaventa.getId());
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
    public String nuevaventaDel(Integer id) {
       StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM detalleventa")
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
