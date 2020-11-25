import java.util.Scanner;

public class InputHandler {

    public static Scanner input = new Scanner(System.in);


    public static String stringInput (String aMessage) {
        System.out.println( aMessage );
        String sentence = input.next();

        return sentence;

    }
    public static void pressAnyKey (){
        System.out.print("Press enter to continue: ");
        input.nextLine();
        System.out.print("");
    }

    public static double doubleInput (String aMessage) {
        System.out.print( aMessage );
        double decimalValue = input.nextDouble();
        input.nextLine();

        return decimalValue;
    }

    public static void closeScanner() {
        input.close();
    }

    public static int intInput(String aMessage) {
        System.out.println(aMessage);
        int integer = input.nextInt();
        return integer;
    }

}
