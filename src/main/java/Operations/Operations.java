package Operations;

import Model.Client;
import java.util.Scanner;

public class Operations implements OperationsI {

    private Client client;

    public Operations(String name, String surname, String login, int pin, int saldo) {
        client = new Client(name, surname, login, pin, saldo);
    }

    @Override
    public void addCash(int value){

        if ( value%5 == 0 ){
            client.setSaldo(client.getSaldo() + value);
        } else {
            System.out.println("Only 5, 10 and 20 bills are accept");
        }
    }

    @Override
    public void giveCash(int value){

        if ( value%5 == 0 && value <= client.getSaldo() ){
            client.setSaldo(client.getSaldo() - value);
        } else {
            System.out.println("Only 5, 10 and 20 bills are accept");
        }
    }

    @Override
    public void showClientDetails() {

        System.out.println("Greetings " + client.getName() + client.getSurname() + " in ATM of our Bank\n");
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

    public static void main(String args[]){

        Scanner in = new Scanner(System.in);

        int addValue = in.nextInt();
        int giveValue = in.nextInt();

        Operations operations = new Operations("Zenia", "Busko", "login",1111, 50);

        operations.showClientDetails();
        operations.showClientBalance();

        operations.addCash(addValue);
        operations.showClientBalance();

        operations.giveCash(giveValue);
        operations.showClientBalance();
    }
}
