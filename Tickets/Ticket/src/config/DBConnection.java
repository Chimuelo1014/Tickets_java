package config;
import java.sql.*;
import java.util.Properties;
import java.io.InputStream;
public class DBConnection {
    
    private  Connection connection;
    
    public Connection getConnection() throws SQLException {
    if (connection == null || connection.isClosed()) {
        try {
            InputStream inputStream = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");

            if (inputStream == null) {
                throw new RuntimeException("No se encontró el archivo db.properties");
            }

            Properties properties = new Properties();
            properties.load(inputStream);

            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.user");
            String password = properties.getProperty("db.password");

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");
        } catch (Exception e) {
            throw new SQLException("Error al conectar a la base de datos: " + e.getMessage(), e);
        }
    }
    return connection;
}

}

