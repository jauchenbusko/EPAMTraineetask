package Input;

import java.util.InputMismatchException;
import java.util.Scanner;

public  class Input {

    public static String enterLogin(){
        String login;

        Scanner in = new Scanner(System.in);
        login = in.next();

        return login;
    }

    public static int enterPin(){
        int pin;

        try {
            Scanner in = new Scanner(System.in);
            pin = in.nextInt();

            if(pin < 999 || pin > 10000){
                System.out.println("Enter PIN as 4 numbers Integer code");
                return 0;
            } else
                return pin;
        } catch (InputMismatchException e){
            System.out.println("Enter PIN as 4 numbers Integer code");
            return 0;
        }
    }

    public static int enterOperationNumber(){
        int operationNumber = 0;

        try {

            Scanner in = new Scanner(System.in);
            operationNumber = in.nextInt();

        } catch (InputMismatchException e){

            System.out.println("Operation number is integer number\n");
        }

        return operationNumber;
    }

    public static int enterCashValue(){
        int cashValue;

        try {
            Scanner in = new Scanner(System.in);
            cashValue = in.nextInt();

            if(cashValue < 0){
                System.out.println("Enter positive integer value\n");
                return 0;
            } else
                return cashValue;
        } catch (InputMismatchException e){
            System.out.println("Enter positive integer value\n");
            return 0;
        }
    }
}
