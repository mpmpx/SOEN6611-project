import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A statistics calculator simulator that reads a random number of value from a
 * uniform distribution, and then provides measures for the given data set upon
 * the request from a user. It also supports a command line user interface, a
 * few options for loading and reloading data, and exceptions handling for
 * user's input.
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
	public void close()
	{
		scanner.close();
	}

	/**
	 * Start the calculator. Asking the user for loading a data set first. After
	 * successfully loading a data set, move to the main function selection section
	 * which provides multiple measures for the given data set and a option for
	 * reloading a new data set. Terminate the execution when the user choose to
	 * exit.
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
	 * Load data set from user's manual input.
	 * 
	 * @return true if the process is executed successfully. Otherwise, return
	 *         false.
	 */
	private boolean loadFromUser() {
		System.out.println(seperator);
		System.out.println(
				"Please enter numbers seperated by commas, press enter to ternimate input (1000 numbers at most): ");
		String input = scanner.nextLine();
		ArrayList<Double> dataset = new ArrayList<Double>();
		try {
			String[] data = input.split(",");
			for (int i = 0; i < 1000 && i < data.length; i++) {
				dataset.add(Double.parseDouble(data[i]));
			}
			model.readData(dataset);
		} catch (Exception e) {
			System.out.println("Invalid input.\n");
			return false;
		}
		return true;
	}

	/**
	 * Load data set from a external file specified by a user.
	 * 
	 * @return true if the process is executed successfully. Otherwise, return
	 *         false.
	 */
	public boolean loadFromFile() {
		System.out.println(seperator);
		System.out.print("Please enter full path to the file which contains data set: ");
		String fileName = scanner.nextLine();
		ArrayList<Double> dataset = new ArrayList<Double>();
		try {
			Scanner reader = new Scanner(new File(fileName));
			while (reader.hasNextLine()) {
				dataset.add(Double.parseDouble(reader.nextLine()));
			}
			reader.close();
			model.readData(dataset);
		} catch (FileNotFoundException e) {
			System.out.println("An error occured when reading " + fileName + "\n");
			return false;
		}
		return true;
	}

	/**
	 * Load data set generated from a random number generator. The user needs to
	 * provide upper bound, lower bound and count of number to be generated to the
	 * generator.
	 * 
	 * @return true if the process is executed successfully. Otherwise, return
	 *         false.
	 */
	public boolean loadFromGenerator() {
		DataGenerator generator = new DataGenerator();
		System.out.println(seperator);

		boolean isFinished = false;
		do {
			System.out.print(
					"Please enter lower bound, upper bound and count of number of the data set you want to generate (seperate by comma: x,x,x): ");
			try {
				String[] input = scanner.nextLine().split(",");
				double lowerBound = Double.parseDouble(input[0]);
				double upperBound = Double.parseDouble(input[1]);
				int count = Integer.parseInt(input[2]);

				ArrayList<Double> dataset = generator.generateDouble(lowerBound, upperBound, count);
				model.readData(dataset);
				isFinished = true;
			} catch (IllegalArgumentException e) {
				System.out.print("Invalid parameters for the random number generator: \n");
				System.out.println(e.getMessage());
				System.out.println("Please try agian.\n");
			} catch (Exception e) {
				System.out.println("Invalid parameters for the random number generator.");
				System.out.println("Please try agian.\n");
			}
		} while (!isFinished);

		return true;
	}

	/**
	 * The section of choosing a method for loading a data set. User can load a data
	 * set from manual input, from an external file, or from a random number
	 * generator.
	 */
	private void loadData() {
		boolean isFinished = false;
		do {
			System.out.println(seperator);
			System.out.println("Choose a way to input your data: ");
			System.out.println(
					"    1. Manual input\n    2. Load from an external file\n    3. Load from data generated by a random number generator");
			System.out.print("Your choice (1-3): ");
			String choice = scanner.nextLine();
			switch (choice) {
			case "1":
				isFinished = loadFromUser();
				break;
			case "2":
				isFinished = loadFromFile();
				break;
			case "3":
				isFinished = loadFromGenerator();
				break;
			default:
				System.out.println("Invalid choice, try again.\n");
			}
		} while (!isFinished);
		System.out.println(model.getCount() + " values are successfully loaded.\n");
	}

	/**
	 * A section for selecting a measure for the given data set. Also, the user can either clear
	 * the current data set and reload a new one, or terminate the program execution.
	 * @return
	 */
	private boolean selectFunction()
	{
		boolean isFinished = false;
		// Function provided by the calculator
		do {
			System.out.println(seperator);
			System.out.println("Choose a measure for the data set or reload a new data set:");
			System.out.println("    1.  Minimum\n"
					+ "    2.  Maximum\n"
					+ "    3.  Mode\n"
					+ "    4.  Median\n"
					+ "    5.  Mean\n"
					+ "    6.  Harmonic mean\n"
					+ "    7.  Mean absolute deviation\n"
					+ "    8.  Population variance\n"
					+ "    9.  Population standard deviation\n"
					+ "    10. Sample variance\n"
					+ "    11. Sample standard deviation\n"
					+ "    12. Show all\n"
					+ "    13. Clear data set\n"
					+ "    14. Exit");
			System.out.print("Your choice (1-14): ");
			String choice = scanner.nextLine();
			switch (choice)
			{
				case "1":
					System.out.println("Minimum: " + model.getMin());
					break;
				case "2":
					System.out.println("Maximum: " + model.getMax());
					break;
				case "3":
					System.out.println("Mode: " + model.getMode());
					break;
				case "4":
					System.out.println("Median: " + model.getMedian());
					break;
				case "5":
					System.out.println("Mean: " + model.getMean());
					break;
				case "6":
					System.out.println("Harmonic mean: " + model.getHarmonicMean());
					break;
				case "7":
					System.out.println("Mean absolute deviation: " + model.getMAD());
					break;
				case "8":
					System.out.println("Population variance: " + model.getPVariance());
					break;
				case "9":
					System.out.println("Population standard deviation: " + model.getPSD());
					break;
				case "10":
					System.out.println("Sample variance: " + model.getVariance());
					break;
				case "11":
					System.out.println("Sample standard deviation: " + model.getSD());
					break;
				case "12":
					model.printAll();
					break;
				case "13":
					model.clear();
					return false;
				case "14":
					System.out.println("Good bye.");
					return true;
				default:
					System.out.println("Invalid choice, try again.\n");
			}
		} while(!isFinished);

		return true;
	}


	/**
	 * The main method is where the calculator is created, turned on and closed.
	 * 
	 * @param args program arguments.
	 */
	public static void main(String[] args)
	{
		Calculator calculator = new Calculator();
		calculator.start();
		calculator.close();
	}

}
