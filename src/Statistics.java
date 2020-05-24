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
    /**
	 * Return arithmetic mean of the data set.
	 * @return a real number that is the arithmetic 
	 *         mean of the data set.
	 */

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
	 * Return a list of most frequent number(s) in the data set.
	 * @return an ArrayList which contains most frequent number(s)
	 *         in the data set.
	 */
    public ArrayList<Double> getMode() {
		ArrayList<Double> mode = new ArrayList<Double>();
		HashMap<Double, Integer> hashmap = new HashMap<Double, Integer>();
		
		for (double num : this.arr) {
			if (hashmap.containsKey(num)) {
				hashmap.put(num, hashmap.get(num) + 1);
			}
			else {
				hashmap.put(num, 1);
			}
		}

		int maxCount = 0;
		for (int count : hashmap.values()) {
			maxCount = count > maxCount ? count : maxCount;
		}
		
		for (double key : hashmap.keySet()) {
			if (hashmap.get(key) == maxCount) {
				mode.add(key);
			}
		}
		
		return mode;
	}
    
    
    /**
	 * Return the smallest number in the data set.
	 * @return the smallest number in the data set.
	 */
	public double getMin() {
		return arr[0];
	}
	
	/**
	 * Return the largest number in the data set.
	 * @return the largest number in the data set.
	 */
	public double getMax() {

		return arr[arr.length - 1];
	}
	
	
	/**
	 * Return the median of the data set.
	 * @return the middle number of the data set if there are odd number of data.
	 *         Otherwise, the arithmetic mean of the two middle numbers is returned.
	 */
	public double getMedian() {
		if (arr.length % 2 == 0) {
			return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2.0;
		}
		else {
			return arr[arr.length / 2];
		}
	}
	/**
	 * Return the mean of absolute deviation of the data set.
	 * @return a real number that is the mean of absolute deviation 
	 *         of the data set.
	 */
	public double getMAD() {
		double mean = getMean();
		double total = 0;
		for (double num : this.arr) {
			total += (abs(num - mean));
		}
		return total / arr.length;
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
