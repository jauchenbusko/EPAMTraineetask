package DBconnect;

import Operations.OperationsImpl;
import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.sql.*;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConnect {

    private static final String URL = "jdbc:mysql://localhost:3306/ATM";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private String login;
    private int pin;

    private String name;
    private String surname;
    private int saldo;

    private Driver driver = new FabricMySQLDriver();
    private Connection connection;

    public DataBaseConnect() throws SQLException {
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public OperationsImpl getClient(String login, int pin) throws SQLException{

        this.login = login;
        this.pin = pin;

        String queryFirstPart = " SELECT * FROM clients WHERE login = \"";
        String querySecondPart = "\" AND pin = ";
        String query = queryFirstPart + login + querySecondPart + pin;

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet == null)
            System.out.println("empty RS");

        while (resultSet.next()){
            this.name = resultSet.getString("name");
            this.surname = resultSet.getString("surname");
            this.saldo = resultSet.getInt("saldo");
        }

        return new OperationsImpl(name, surname, login, pin, saldo);
    }

    public void closeConnection() throws SQLException{
        connection.close();
    }



    public static void main(String args[]){

        try {
            DataBaseConnect dataBaseConnect = new DataBaseConnect();
            OperationsImpl operations = dataBaseConnect.getClient("qwerty", 1234);
            operations.showClientDetails();
            dataBaseConnect.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
