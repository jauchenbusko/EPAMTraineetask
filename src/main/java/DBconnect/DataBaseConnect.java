package DBconnect;

import Operations.*;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.sql.*;

/**
 * Class DataBaseConnect implements DataBaseConnectI;
 * Contain fields with URL, username and password from DataBase;
 * Contain Connection class field;
 * Constructor create connection to DataBase;
 * getResultSet() returns ResultSet object by input login and PIN;
 */

public class DataBaseConnect implements DataBaseConnectI {

    private static final String URL = "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11197877";
    private static final String USERNAME = "sql11197877";
    private static final String PASSWORD = "7xRjNADdNR";

    private Connection connection;

    public DataBaseConnect() {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException e){
            System.out.println("Problems with DataBase connection during DataBaseConnect object creation");
            e.printStackTrace();
        }
    }

    private ResultSet getResultSet(String login, int pin) throws NullPointerException{

            String query = " SELECT * FROM clients WHERE login = \"" + login + "\" AND pin = " + pin;

       try {
           Statement statement = connection.createStatement();
           return statement.executeQuery(query);
       } catch (SQLException e){
           System.out.println("Problems with DataBase connection during getResultSet() method running");
           e.printStackTrace();
           return null;
       }
    }

    @Override
    public boolean checkClient(String login, int pin){

            String name = null;
            String surname = null;

            ResultSet resultSet = getResultSet(login, pin);

            assert resultSet != null;
        try {
            while (resultSet.next()){
                name = resultSet.getString("name");
                surname = resultSet.getString("surname");
            }
        } catch (SQLException e) {
            System.out.println("Problems with DataBase connection during checkClient() method running");
            e.printStackTrace();
        }

        return name != null && surname != null;
    }

    @Override
    public Operations getClient(String login, int pin){

             String name = null;
             String surname = null;
             int balance = 0;

             ResultSet resultSet = getResultSet(login, pin);

             assert resultSet != null;
        try {
            while (resultSet.next()){
                name = resultSet.getString("name");
                surname = resultSet.getString("surname");
                balance = resultSet.getInt("balance");
            }
        } catch (SQLException e) {
            System.out.println("Problems with DataBase connection during getClient() method running");
            e.printStackTrace();
        }

        return new Operations(name, surname, login, balance);
    }

    @Override
    public void updateClientBalance(String login, int balance){

            String query = "UPDATE clients SET balance = " + balance + " WHERE login = \"" + login +"\"";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Problems with DataBase connection during updateClientBalance() method running");
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Problems with DataBase connection during closeConnection() method running");
            e.printStackTrace();
        }
    }

}