package softManagement18;

import java.util.Scanner;

public class UserInput {
	public static Scanner in = new Scanner(System.in);
	
	public static String readString(String userMessage) {
		System.out.print(userMessage);
		String userInput =  in.nextLine();
		
		return userInput;
	}
	
	public static int readInt(String userMessage) {
		System.out.print(userMessage);
		int userInput = in.nextInt();
		in.nextLine();
		return userInput;
	}
	
	public static double readDouble(String userMessage) {
		System.out.print(userMessage);
		double userInput = in.nextDouble();
		in.nextLine();
		return userInput;
	}
	
	
	public static void closeScanner() {
		in.close();
	}
}
