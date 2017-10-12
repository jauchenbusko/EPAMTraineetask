package Operations;

import static org.junit.Assert.*;

public class OperationsTest {


    private Operations operations = new Operations("TestName", "TestSurname", "test", 2000);


    @org.junit.Test
    public void addCashTest() throws Exception {
        operations.addCash(10);
        assertEquals(String.valueOf(operations.getClientSaldo()), "2010");
    }

    @org.junit.Test
    public void giveCashTest() throws Exception {
        operations.giveCash(10);
        assertEquals(String.valueOf(operations.getClientSaldo()), "1990");
    }

    @org.junit.Test
    public void getClientSaldoTest() throws Exception{
        assertEquals(String.valueOf(operations.getClientSaldo()), "2000");
    }

    @org.junit.Test
    public void getClientLoginTest() throws Exception{
        assertEquals(operations.getClientLogin(), "test");
    }

}