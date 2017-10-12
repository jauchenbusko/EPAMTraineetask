package DBconnect;

import Operations.Operations;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataBaseConnectTest {


    private static final int pinOK = 1111;
    private static final String loginOK = "login";

    private static final int pinWrong = 1112;
    private static final String loginWrong = "loginW";

    private static final String name = "name";
    private static final String surname = "surname";
    private static final int saldo = 1000;

    @Test
    public void checkClientTest() throws Exception {

        DataBaseConnect dataBaseConnect = new DataBaseConnect();
        assertEquals(String.valueOf(dataBaseConnect.checkClient(loginOK, pinOK)), "true");
        assertEquals(String.valueOf(dataBaseConnect.checkClient(loginWrong, pinWrong)), "false");
    }

    @Test
    public void getClient() throws Exception {

        Operations operationsLocal = new Operations(name, surname, loginOK, saldo);
        DataBaseConnect dataBaseConnect = new DataBaseConnect();
        Operations operationsDB = dataBaseConnect.getClient(loginOK, pinOK);

        assertEquals(operationsLocal, operationsDB);

        boolean boolState = operationsLocal.equals(operationsDB);
        assertEquals(Boolean.toString(boolState), "true" );
    }

    @Test
    public void updateClientSaldo() throws Exception {
    }

}