package Operations;

import static org.junit.Assert.*;

/**
 * Class  OperationsTest contain tests of Operations class;
 */

public class OperationsTest {


    private Operations operations = new Operations("TestName", "TestSurname", "test", 2000);


    @org.junit.Test
    public void addCashTest() throws Exception {
        operations.addCash(10);
        assertEquals(String.valueOf(operations.getClientBalance()), "2010");
    }

    @org.junit.Test
    public void giveCashTest() throws Exception {
        operations.giveCash(10);
        assertEquals(String.valueOf(operations.getClientBalance()), "1990");
    }

    @org.junit.Test
    public void getClientBalanceTest() throws Exception{
        assertEquals(String.valueOf(operations.getClientBalance()), "2000");
    }

    @org.junit.Test
    public void getClientLoginTest() throws Exception{
        assertEquals(operations.getClientLogin(), "test");
    }

}