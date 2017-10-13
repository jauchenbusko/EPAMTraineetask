package Operations;

import Model.Client;

/**
 * Class Operation implements OperationsI interface;
 * Contain Client class object;
 * Constructor creates Client class object;
 * getClientBalance() returns client balance status;
 * getClientLogin() return client login;
 * toString(), equals(), hashcode() overridden for tests needs;
 */

public class Operations implements OperationsI {

    private Client client;

    public Operations(String name, String surname, String login, int balance) {
        this.client = new Client(name, surname, login, balance);
    }

    @Override
    public void addCash(int value){

        if ( value%5 == 0 ){
            client.setBalance(client.getBalance() + value);
            System.out.println("Operation ended, " + value + " $ added to your account\n");
        } else {
            System.out.println("Only 5, 10 and 20 bills are accept, try again\n");
        }
    }

    @Override
    public void giveCash(int value){

        if ( value%5 == 0 && value <= client.getBalance() ){
            client.setBalance(client.getBalance() - value);
            System.out.println("Operation ended, " + value + " $ taken from your account\n");
        } else if (value%5 != 0 && value <= client.getBalance()) {
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

        System.out.println("Your current balance is " + client.getBalance() + " $ \n");
    }

    public int getClientBalance(){
        return client.getBalance();
    }

    public String getClientLogin(){
        return client.getLogin();
    }

    @Override
    public String toString() {
        return "Operations{" +
                "client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Operations)) return false;

        Operations that = (Operations) o;

        return client.equals(that.client);
    }

    @Override
    public int hashCode() {
        return client.hashCode();
    }
}