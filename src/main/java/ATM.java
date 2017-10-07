import DBconnect.DataBaseConnect;
import Input.Input;
import Operations.Operations;

public class ATM {

    public static void main(String args[]){

        boolean operationContinue = true;

        String ATMlogin;
        int ATMpin;
        int operationNumber;

        Operations operations;
        DataBaseConnect dataBaseConnect;

        while (operationContinue){
            System.out.println();
            System.out.println("/**********************************************/");

            System.out.println("Please Enter Login");
            ATMlogin = Input.enterLogin();

            System.out.println("Please Enter PIN");
            ATMpin = Input.enterPin();

            if (ATMpin == 0){
                while (true){
                System.out.println("To repeat Login operation enter \"1\"");
                System.out.println("To end operations enter \"2\"\n");

                operationNumber = Input.enterOperationNumber();

                    if (operationNumber == 2) {
                        operationContinue = false;
                        break;
                    } else if (operationNumber != 1){
                        System.out.println("Wrong operation number, try again\n");
                    } else
                        break;
                }

            } else {

                dataBaseConnect = new DataBaseConnect();

                if (!dataBaseConnect.checkClient(ATMlogin, ATMpin)){
                    while (true){
                    System.out.println("Login or PIN are incorrect");
                    System.out.println("To repeat Login operation enter \"1\"");
                    System.out.println("To end operations enter \"2\"\n");

                    operationNumber = Input.enterOperationNumber();

                        if (operationNumber == 2) {
                            dataBaseConnect.closeConnection();
                            operationContinue = false;
                            break;
                        } else if (operationNumber != 1){
                            System.out.println("Wrong operation number, try again\n");
                        } else
                            break;
                    }
                } else {
                    operations = dataBaseConnect.getClient(ATMlogin, ATMpin);
                    System.out.println("/**********************************************/");
                    operations.showClientDetails();

                    while (true){
                        System.out.println("1. To add cash to your account enter \"1\"");
                        System.out.println("2. To take cash from your account enter \"2\"");
                        System.out.println("3. To show your current balance status enter \"3\"");
                        System.out.println("4. To end transactions enter \"4\"");

                        operationNumber = Input.enterOperationNumber();

                        if (operationNumber == 1){
                            System.out.println("Enter cash value:");
                            operations.addCash(Input.enterCashValue());
                        } else if (operationNumber == 2){
                            System.out.println("Enter cash value:");
                            operations.giveCash(Input.enterCashValue());
                        } else if (operationNumber == 3)
                            operations.showClientBalance();
                        else if (operationNumber == 4){
                            dataBaseConnect.updateClientSaldo(operations.getClientLogin(), operations.getClientSaldo());
                            dataBaseConnect.closeConnection();
                            break;
                        } else
                            System.out.println("Wrong operation number, try again\n");
                    }

                    operationContinue = false;
                }
            }

        }

        System.out.println("/**********************************************/");
        System.out.println("End of operations. Goodbye!");
    }
}
