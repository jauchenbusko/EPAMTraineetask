package DBconnect;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.sql.*;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConnect {

    public static final String URL = "jdbc:mysql://localhost:3306/ATM";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";


    public void dbConnect() throws SQLException {
        Driver driver = new FabricMySQLDriver();
        DriverManager.registerDriver(driver);

        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println(connection.isClosed());
        connection.close();
    }

    public static void main(String args[]){

        DataBaseConnect dataBaseConnect = new DataBaseConnect();

        try {
            dataBaseConnect.dbConnect();
        } catch (SQLException e) {
            System.out.println("Enable to load DB driver");
        }
    }
}
