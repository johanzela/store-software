
package dao.impl;

import dao.DaoCliente;
import entidad.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;


public class DaoClienteImpl implements DaoCliente{
    
    private final Conexion conexion;
    private String mensaje;

    public DaoClienteImpl() {
        conexion = new Conexion();
    }

    @Override
    public List<Cliente> clienteSel() {
        List<Cliente> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("dni,")
                .append("nombre,")
                .append("apellido,")
                .append("telefono,")
                .append("correo ")
                .append("FROM cliente");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setDni(rs.getString(2));
                cliente.setNombre(rs.getString(3));
                cliente.setApellido(rs.getString(4));
                cliente.setTelefono(rs.getString(5));
                cliente.setCorreo(rs.getString(6));
                lista.add(cliente);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return lista;
    }

    @Override
    public Cliente clienteGet(Integer id) {
        Cliente cliente = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("dni,")
                .append("nombre,")
                .append("apellido,")
                .append("telefono,")
                .append("correo ")
                .append("FROM cliente ")
                .append("WHERE id = ?");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            cliente = new Cliente();
            if (rs.next()) {                
                cliente.setId(rs.getInt(1));
                cliente.setDni(rs.getString(2));
                cliente.setNombre(rs.getString(3));
                cliente.setApellido(rs.getString(4));
                cliente.setTelefono(rs.getString(5));
                cliente.setCorreo(rs.getString(6));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return cliente;
    }

    @Override
    public String clienteIns(Cliente cliente) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO cliente(")
                .append("dni,")
                .append("nombre,")
                .append("apellido,")
                .append("telefono,")
                .append("correo ")
                .append(") VALUES (?,?,?,?,?)");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombre()); 
            ps.setString(3, cliente.getApellido()); 
            ps.setString(4, cliente.getTelefono()); 
            ps.setString(5, cliente.getCorreo()); 
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
    public String clienteUpd(Cliente cliente) {
     StringBuilder sql = new StringBuilder();
        sql.append("UPDATE cliente SET ")
                .append("dni = ?,")
                .append("nombre = ?,")
                .append("apellido = ?,")
                .append("telefono = ?,")
                .append("correo = ? ")
                .append("WHERE id = ?");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombre()); 
            ps.setString(3, cliente.getApellido()); 
            ps.setString(4, cliente.getTelefono()); 
            ps.setString(5, cliente.getCorreo()); 
            ps.setInt(6, cliente.getId());
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
    public String clienteDel(Integer id) {
       StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM cliente")
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
