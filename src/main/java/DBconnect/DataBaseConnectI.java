package DBconnect;

import Operations.Operations;

public interface DataBaseConnectI {
    boolean checkClient(String login, int pin);

    Operations getClient(String login, int pin);

    void updateClientSaldo(String login, int saldo);

    void closeConnection();
}
