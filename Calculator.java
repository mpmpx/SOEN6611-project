import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A statistics calculator simulator that reads a random number of value from a uniform distribution,
 * and then provides measures for the given data set upon the request from a user. It also supports a
 * command line user interface, a few options for loading and reloading data, and exceptions handling
 * for user's input.
 *
 */
public class Calculator {

	private Statistics model;
	private Scanner scanner;
	private String seperator;
	
	/**
	 * Constructor. Initialize the descriptive statistics model, the user input 
	 * scanner.
	 */
	public Calculator() {
		model = new Statistics();
		scanner = new Scanner(System.in);
		seperator = "";
		for (int i = 0; i < 80; i++) {
			seperator += "-";
		}
	}

	/**
	 * Turn off the calculator and close the scanner for the user's input.
	 */
	public void close() {
		scanner.close();
	}

	/**
	 * Start the calculator. Asking the user for loading a data set first. 
	 * After successfully loading a data set, move to the main function selection section
	 * which provides multiple measures for the given data set and a option for reloading
	 * a new data set. Terminate the execution when the user choose to exit.
	 */
	public void start() {
		System.out.println("Hi, welcome to use this statistical calculator.\n");
		
		// Choose to load data set into the calculator
		boolean isFinished = false;
		do {
			System.out.println(seperator);
			System.out.println("No data set is loaded into the calculator.");
			System.out.println("    1. Load data");
			System.out.println("    2. Exit");
			System.out.print("Your choice (1-2): ");
			String choice = scanner.nextLine();
			switch (choice) {
				case "1":
					loadData();
					isFinished = true;
					break;
				case "2":
					System.out.println("Good bye.");
					return;
				default:
					System.out.println("Invalid choice, try again.\n");
					continue;
			}
			
			isFinished = selectFunction();
		} while (!isFinished);
	}
	
	/**
	 * The main method is where the calculator is created, turned on and closed.
	 * @param args program arguments.
	 */
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.start();
		calculator.close();
	}
	
}
