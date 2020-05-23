import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Represents a descriptive statistics model which reads a random number of data
 * and provides measures of the given data set. 
 *
 */
public class Statistics {
	private double[] arr;
		
	/**
	 * Read dataset from an ArrayList.
	 * @param dataset given dataset.
	 */
	public void readData(ArrayList<Double> dataset) {
		this.arr = new double[dataset.size()];
		for (int i = 0; i < dataset.size(); i++) {
			this.arr[i] = dataset.get(i);
		}
		
		Arrays.sort(this.arr);
	}
	
	public void clear() {
		this.arr = null;
	}
	
	/**
	 * The main function used for debugging.
	 * @param args program arguments
	 */
	public static void main(String[] args) {

	}
	
}
