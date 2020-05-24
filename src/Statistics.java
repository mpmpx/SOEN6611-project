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

    public double getMean() {
		double total = 0;
		for (double num : this.arr) {
			total += num;
		}
		return total / arr.length;
	}
    /**
     * Return the sample standard deviation. Use this
     * function when your data is a sample from a population.
     * @return a real number that is the sample standard
     * 			deviation of the data set.
     */
    public double getSD() {
        return sqrt(getVariance());
    }

    /**
     * Return the population variance. Use this
     * function to calculate the variance from the entire population.
     * @return a real number that is the population variance of the data set.
     */
    public double getPVariance() {
        double mean = getMean();
        double variance = 0;
        for (double num : this.arr) {
            variance += ((num - mean) * (num - mean));
        }
        return variance / arr.length;
    }

    /**
     * Return the population standard deviation. Use this
     * function to calculate the standard deviation from the entire population.
     * @return a real number that is the standard deviation
     *         of the data set.
     */
    public double getPSD() {
        return sqrt(getPVariance());
    }


    /**
     * Return count of value in the data set.
     * @return a number that is the count of value in the data set.
     */
    public int getCount() {
        return this.arr.length;
    }

    /**
     * Print all information of the data set.
     */
    public void printAll() {
        System.out.println("Number of values: " + this.arr.length);
        System.out.println("Min: " + getMin());
        System.out.println("Max: " + getMax());
        ArrayList<Double> mode = getMode();
        System.out.print("mode: ");

        int i = 0;
        for (i = 0; i < mode.size() && i <= 5; i++) {
            System.out.print(mode.get(i) + " ");
        }

        if (mode.size() > 5) {
            System.out.println("... and " + (mode.size() - 5) + " more value(s)");
        }
        else {
            System.out.println();
        }

        System.out.println("Median: " + getMedian());
        System.out.println("Mean: " + getMean());
        System.out.println("Mean Absolute Deviation: " + getMAD());
        System.out.println("Sample variance: " + getVariance());
        System.out.println("Sample standard deviation: " + getSD());
        System.out.println("Population variance: " + getPVariance());
        System.out.println("Population standard deviation: " + getPSD());
        System.out.println("Harmonic mean: " + getHarmonicMean());
    }

    /**
     * Return the absolute value of a double value.
     * @param num that argument whose absolute value is to be determined.
     * @return the absolute value of the argument.
     */
    public static double abs(double num) {
        return num >= 0 ? num : -num;
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
