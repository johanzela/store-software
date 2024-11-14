
package dao.impl;
import dao.DaoVendedor;
import entidad.Vendedor1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;
//////////////
public class DaoVendedorImpl implements DaoVendedor{
    
    private final Conexion conexion;
    private String mensaje;

    public DaoVendedorImpl() {
        conexion = new Conexion();
    }
   
    @Override
    public List<Vendedor1> vendedorSel() {
    
      List<Vendedor1> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("codigo,")
                .append("dni,")
                .append("nombre,")
                .append("apellido ")
                .append("FROM vendedor");
        /////////////////////////
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Vendedor1 vendedor = new Vendedor1();
                vendedor.setCodigo(rs.getInt(1));
                vendedor.setDni(rs.getString(2));
                vendedor.setNombre(rs.getString(3));
                vendedor.setApellido(rs.getString(4));
                lista.add(vendedor);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        ////////////
      return lista;
    }
    ///////////////////////////////////////////////////////////
    @Override
    public Vendedor1 vendedorGet(Integer codigo) {
        Vendedor1 vendedor = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("codigo,")
                .append("dni,")
                .append("nombre,")
                .append("apellido ")
                .append("FROM vendedor ")
                .append("WHERE codigo = ?");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            vendedor = new Vendedor1();
            if (rs.next()) {                
                vendedor.setCodigo(rs.getInt(1));
                vendedor.setDni(rs.getString(2));
                vendedor.setNombre(rs.getString(3));
                vendedor.setApellido(rs.getString(4));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return vendedor;
    }
    
    ///////////////////////////////////////////////
    @Override
    public String vendedorIns(Vendedor1 vendedor) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO vendedor(")
                .append("dni,")
                .append("nombre,")
                .append("apellido ")
                .append(") VALUES (?,?,?)");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, vendedor.getDni());
            ps.setString(2, vendedor.getNombre());
            ps.setString(3, vendedor.getApellido());
            int resultado = ps.executeUpdate();
            if (resultado == 0){
                mensaje = "Cero registros agregados";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;        
    }
    //////////////////////////////////////////////////////
    @Override
    public String vendedorUpd(Vendedor1 vendedor) {
     StringBuilder sql = new StringBuilder();
        sql.append("UPDATE vendedor SET ")
                .append("dni = ?,")
                .append("nombre = ?,")
                .append("apellido = ? ")
                .append("WHERE codigo = ?");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, vendedor.getDni());
            ps.setString(2, vendedor.getNombre()); 
            ps.setString(3, vendedor.getApellido()); 
            ps.setInt(4, vendedor.getCodigo());
            int resultado = ps.executeUpdate();
            if (resultado == 0){
                mensaje = "Cero registros actualizados";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;   
    }
    
    ///////////////////////////////////////
    @Override
    public String vendedorDel(Integer codigo) {
       StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM vendedor")
                .append(" WHERE codigo = ?");
        try (Connection cn = conexion.getConexion()){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, codigo);          
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
