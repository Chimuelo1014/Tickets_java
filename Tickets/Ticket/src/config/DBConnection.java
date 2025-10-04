package config;
import java.sql.*;
import java.util.Properties;
import java.io.InputStream;
public class DBConnection {
    
    private static Connection connection;
    
    public static Connection getConnection() throws SQLException {
    if (connection == null || connection.isClosed()) {
    try {
        InputStream inputStream = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String password = properties.getProperty("db.password");
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("connection succesfuly");
    }
    catch(Exception e){
        System.out.println("error database connection "+e.getMessage());
    }
    
    }
    return connection;
}
}

