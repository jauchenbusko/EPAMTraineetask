package Operations;

import Model.Client;

public class Operations implements OperationsI {

    private Client client;

    public Operations(String name, String surname, String login, int pin, int saldo) {
        client = new Client(name, surname, login, pin, saldo);
    }

    @Override
    public void addCash(int value){

        if ( value%5 == 0 ){
            client.setSaldo(client.getSaldo() + value);
            System.out.println("Operation ended, " + value + " $ added from to account\n");
        } else {
            System.out.println("Only 5, 10 and 20 bills are accept, try again\n");
        }
    }

    @Override
    public void giveCash(int value){

        if ( value%5 == 0 && value <= client.getSaldo() ){
            client.setSaldo(client.getSaldo() - value);
            System.out.println("Operation ended, " + value + " $ taken from your account\n");
        } else if (value%5 != 0 && value <= client.getSaldo()) {
            System.out.println("Only 5, 10 and 20 bills are accept, try again\n");
        } else
            System.out.println("Current status of your Balance don't allow operation\n");
    }

    @Override
    public void showClientDetails() {

        System.out.println("Greetings " + client.getName() + " "
                            + client.getSurname() + " in ATM of our Bank\n");
    }

    @Override
    public void showClientBalance() {

        System.out.println("Your current balance is " + client.getSaldo() + " $ \n");
    }

    public int getClientSaldo(){
        return client.getSaldo();
    }

    public String getClientLogin(){
        return client.getLogin();
    }

}
