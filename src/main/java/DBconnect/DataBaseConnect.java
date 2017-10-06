package DBconnect;

import Operations.Operations;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.sql.*;

public class DataBaseConnect {

    private static final String URL = "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11197877";
    private static final String USERNAME = "sql11197877";
    private static final String PASSWORD = "7xRjNADdNR";

    private Connection connection;

    public DataBaseConnect() throws SQLException {
        Driver driver = new FabricMySQLDriver();
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    private ResultSet getResultSet(String login, int pin) throws SQLException{

        String query = " SELECT * FROM clients WHERE login = \"" + login + "\" AND pin = " + pin;

        Statement statement = connection.createStatement();

        return statement.executeQuery(query);
    }

    public boolean checkClient(String login, int pin) throws SQLException{

        String name = null;
        String surname = null;

        ResultSet resultSet = getResultSet(login, pin);

        while (resultSet.next()){
            name = resultSet.getString("name");
            surname = resultSet.getString("surname");
        }

        return name != null || surname != null;
    }


    public Operations getClient(String login, int pin) throws SQLException{

        String name = null;
        String surname = null;
        int saldo = 0;

        ResultSet resultSet = getResultSet(login, pin);

        while (resultSet.next()){
            name = resultSet.getString("name");
            surname = resultSet.getString("surname");
            saldo = resultSet.getInt("saldo");
        }

        return new Operations(name, surname, login, pin, saldo);
    }

    public void updateClientSaldo(String login, int saldo) throws SQLException{

        String query = "UPDATE clients SET saldo = " + saldo + " WHERE login = \"" + login +"\"";

        Statement statement = connection.createStatement();

        statement.executeUpdate(query);
    }

    public void closeConnection() throws SQLException{
        connection.close();
    }



    public static void main(String args[]){

        try {
            DataBaseConnect dataBaseConnect = new DataBaseConnect();

           if (dataBaseConnect.checkClient("qwerty", 1234)){

               Operations operations = dataBaseConnect.getClient("qwerty", 1234);

               operations.showClientDetails();
               operations.addCash(110);
               operations.showClientBalance();
               operations.giveCash(1000);
               operations.showClientBalance();

               dataBaseConnect.updateClientSaldo(operations.getClientLogin(), operations.getClientSaldo());

               dataBaseConnect.closeConnection();
           } else {

               System.out.println("No such client in DB");
           }

        } catch (SQLException e) {
            System.out.println("Problems with DB connection");
        }
    }
}
