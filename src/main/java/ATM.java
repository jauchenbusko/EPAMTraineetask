import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM {

    private static int enterPin(){
        int pin = 0;

        try {

            Scanner in = new Scanner(System.in);
            pin = in.nextInt();

        } catch (InputMismatchException e){

            System.out.println("Enter PIN as 4 numbers Integer code");
        }

        return pin;
    }

    private static String enterLogin(){
        String login = "";

        Scanner in = new Scanner(System.in);
        login = in.next();

        return login;
    }

    public static void main(String args[]){

        System.out.println(enterPin());

        System.out.println(enterLogin());

    }
}
