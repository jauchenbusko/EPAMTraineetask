package DBconnect;

import Operations.OperationsImpl;

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

        String queryFirstPart = " SELECT * FROM clients WHERE login = \"";
        String querySecondPart = "\" AND pin = ";
        String query = queryFirstPart + login + querySecondPart + pin;

        Statement statement = connection.createStatement();

        return statement.executeQuery(query);
    }

    public OperationsImpl getClient(String login, int pin) throws SQLException, NullPointerException{

        String name = null;
        String surname = null;
        int saldo = 0;

        ResultSet resultSet = getResultSet(login, pin);

        while (resultSet.next()){
            name = resultSet.getString("name");
            surname = resultSet.getString("surname");
            saldo = resultSet.getInt("saldo");
        }

        if (name == null && surname == null){
            System.out.println("Wrong login or pin entered");
            return null;
        }
        else
            return new OperationsImpl(name, surname, login, pin, saldo);
    }

    public void updateSaldo(String login, int saldo) throws SQLException{

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
            OperationsImpl operations = dataBaseConnect.getClient("qwerty", 1234);
            operations.showClientDetails();
            operations.addCash(17);
            operations.showClientDetails();
         //   operations.giveCash(450);
            operations.showClientDetails();

            dataBaseConnect.updateSaldo(operations.getClientLogin(), operations.getClientSaldo());

            dataBaseConnect.closeConnection();

        } catch (SQLException e) {
            System.out.println("Problems with DB connection");
        } catch (NullPointerException e){
            System.out.println("No such client in DB");
        }


    }
}
