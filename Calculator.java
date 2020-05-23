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

	public void start() {

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
