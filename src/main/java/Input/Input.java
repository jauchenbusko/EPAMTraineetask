package Input;

import java.util.InputMismatchException;
import java.util.Scanner;

public  class Input {


    public static int enterPin(){
        int pin = 0;

        try {

            Scanner in = new Scanner(System.in);
            pin = in.nextInt();

        } catch (InputMismatchException e){

            System.out.println("Enter PIN as 4 numbers Integer code");
        }

        return pin;
    }

    public static String enterLogin(){
        String login;

        Scanner in = new Scanner(System.in);
        login = in.next();

        return login;
    }

    public static int enterOperationNumber(){
        int operationNumber = 0;

        try {

            Scanner in = new Scanner(System.in);
            operationNumber = in.nextInt();

        } catch (InputMismatchException e){

            System.out.println("Operation number is integer number");
        }

        return operationNumber;
    }
}
