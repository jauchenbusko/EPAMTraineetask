package Operations;

import Model.Client;
import java.util.Scanner;

public class OperationsImpl implements Operations {

    private Client client;

    public OperationsImpl(String name, String surname, String login, int pin, int saldo) {
        client = new Client(name, surname, login, pin, saldo);
    }

    @Override
    public void addCash(int value){

        if ( value%5 == 0 ){
            client.setSaldo(client.getSaldo()+value);
        } else {
            System.out.println("Only 5, 10 and 20 bills are accept");
        }
    }

    @Override
    public void giveCash(int value){

        if ( value%5 == 0 && value <= client.getSaldo() ){
            client.setSaldo(client.getSaldo()- value);
        } else {
            System.out.println("Only 5, 10 and 20 bills are accept");
        }
    }

    @Override
    public void showClientDetails() {

        System.out.println(client.toString());
    }

    @Override
    public void showBalance() {

        System.out.println(client.getSaldo());
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

        OperationsImpl operations = new OperationsImpl("Zenia", "Busko", "login",1111, 50);

        operations.showClientDetails();
        operations.showBalance();

        operations.addCash(addValue);
        operations.showBalance();

        operations.giveCash(giveValue);
        operations.showBalance();
    }
}
