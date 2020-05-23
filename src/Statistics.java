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

	/**
	 * Return the sample variance. Use this
	 * function when your data is a sample from a population.
	 * @return a real number that is the sample variance
	 *         of the data set.
	 *
	 */
	public double getVariance() {
		double mean = getMean();
		double variance = 0;
		for (double num : this.arr) {
			variance += ((num - mean) * (num - mean));
		}
		return variance / (arr.length - 1);
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
