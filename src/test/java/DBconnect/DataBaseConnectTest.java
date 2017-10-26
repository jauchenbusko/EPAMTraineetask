package DBconnect;

import Operations.Operations;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class  DataBaseConnectTest contain tests of DataBaseConnect class;
 * Test Client in Data Base: login: login;
 *                           PIN: 1111;
 *                           name: Name;
 *                           surname: Surname;
 *                           balance: 1000;
 */

public class DataBaseConnectTest {


    private static final int pinOK = 1111;
    private static final String loginOK = "login";

    private static final int pinWrong = 1112;
    private static final String loginWrong = "loginW";

    private static final String name = "name";
    private static final String surname = "surname";
    private static final int balance = 1000;

    @Test
    public void connectionTest() throws Exception {

        DataBaseConnect dataBaseConnect = new DataBaseConnect();
        dataBaseConnect.closeConnection();
    }

    @Test
    public void checkClientTest() throws Exception {

        DataBaseConnect dataBaseConnect = new DataBaseConnect();
        assertEquals(String.valueOf(dataBaseConnect.checkClient(loginOK, pinOK)), "true");
        assertEquals(String.valueOf(dataBaseConnect.checkClient(loginWrong, pinOK)), "false");
        assertEquals(String.valueOf(dataBaseConnect.checkClient(loginOK, pinWrong)), "false");
        assertEquals(String.valueOf(dataBaseConnect.checkClient(loginWrong, pinWrong)), "false");
        dataBaseConnect.closeConnection();
    }

    @Test
    public void getClientTest() throws Exception {

        Operations operationsLocal = new Operations(name, surname, loginOK, balance);
        DataBaseConnect dataBaseConnect = new DataBaseConnect();
        Operations operationsDB = dataBaseConnect.getClient(loginOK, pinOK);
        operationsDB.showClientDetails();
        operationsDB.showClientBalance();

        assertEquals(operationsLocal, operationsDB);
        assertEquals(operationsLocal.getClientBalance(), operationsDB.getClientBalance());
        boolean boolState = operationsLocal.equals(operationsDB);
        assertEquals(Boolean.toString(boolState), "true" );

        dataBaseConnect.closeConnection();
    }

    @Test
    public void updateClientBalanceTest() throws Exception {

        DataBaseConnect dataBaseConnectBeforeUpdate = new DataBaseConnect();
        dataBaseConnectBeforeUpdate.updateClientBalance(loginOK, balance);
        dataBaseConnectBeforeUpdate.closeConnection();

        Operations operationsLocal = new Operations(name, surname, loginOK, balance);
        DataBaseConnect dataBaseConnectAfterUpdate = new DataBaseConnect();
        Operations operationsDB = dataBaseConnectAfterUpdate.getClient(loginOK, pinOK);
        dataBaseConnectAfterUpdate.closeConnection();

        assertEquals(operationsLocal.getClientBalance(), operationsDB.getClientBalance());
    }

}