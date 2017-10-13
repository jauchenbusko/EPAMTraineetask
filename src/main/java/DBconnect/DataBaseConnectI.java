package DBconnect;

import Operations.Operations;

/**
 * DataBaseConnectI interface describes ATM interaction with DataBase;
 *
 * checkClient() method must return true if client with input login and PIN is in DataBase;
 *
 * getClient() method must return Operations object of client with input login and PIN;
 *
 * updateClientSaldo() method must send balance status to DataBase when client ends interaction with ATM;
 *
 * closeConnection() method must close connection with DataBase;
 */

public interface DataBaseConnectI {

    boolean checkClient(String login, int pin);

    Operations getClient(String login, int pin);

    void updateClientSaldo(String login, int saldo);

    void closeConnection();
}
