package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private final String URL = "jdbc:mysql://localhost:3306/tienda";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String USER = "root";
    private final String PASS = "";

    public Connection getConexion() throws SQLException {
        Connection c = null;
        try {
            Class.forName(DRIVER).newInstance();
            c = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException e) {
            throw new SQLException(e.getMessage());
        }

        return c;
    }
}
