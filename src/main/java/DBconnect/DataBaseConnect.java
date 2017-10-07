package DBconnect;

import Operations.*;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import com.sun.istack.internal.Nullable;

import java.sql.*;

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

    @Nullable
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

        return name != null || surname != null;
    }


    @Override
    public Operations getClient(String login, int pin){

             String name = null;
             String surname = null;
             int saldo = 0;

             ResultSet resultSet = getResultSet(login, pin);

             assert resultSet != null;
        try {
            while (resultSet.next()){
                name = resultSet.getString("name");
                surname = resultSet.getString("surname");
                saldo = resultSet.getInt("saldo");
            }
        } catch (SQLException e) {
            System.out.println("Problems with DataBase connection during getClient() method running");
            e.printStackTrace();
        }

        return new Operations(name, surname, login, saldo);
    }

    @Override
    public void updateClientSaldo(String login, int saldo){

            String query = "UPDATE clients SET saldo = " + saldo + " WHERE login = \"" + login +"\"";

            Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Problems with DataBase connection during updateClientSaldo() method running");
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
