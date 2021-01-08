package softManagement18;

import java.io.File;
import java.io.IOException;

public class Main {


	public static void main(String [] args) {
		System.out.println("\n Welcome to SoftManagement18! Your management buddy to a more organised work! :D ");
		try {
			File myObj = new File("SoftManagement18file.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		new Menus();

	}

}

