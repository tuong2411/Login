package vn.iostar.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


    private final String serverName = "LAPTOP-3N644IDG";
    private final String dbName = "User";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "123456";
    private final String instance = "";  

    private String getConnectionURL() {

        if (instance == null || instance.trim().isEmpty()) {
            return "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        } else {
            return "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber + ";databaseName=" + dbName;
        }
    }

    public Connection getConnection() throws SQLException {
        String connectionURL = getConnectionURL(); 
        return DriverManager.getConnection(connectionURL, userID, password); 
    }
}
