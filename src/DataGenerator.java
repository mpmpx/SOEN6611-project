import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * A generator that generates random numbers from a uniform distribution.
 *
 */

public class DataGenerator
{
    private Random random;

    /**
     * Constructor
     */
    public DataGenerator() {
        random = new Random();
    }

    /**
     * Constructor. Initialize the random generator with a seed.
     *
     * @param seed
     */
    public DataGenerator(int seed)
    {
        random = new Random(seed);
    }

    /**
     * Return a generated data set with specified lower bound, upper bound and count of number.
     * @param lowerBound the lower bound (inclusive).
     * @param upperBound the upper bound (exclusive).
     * @param count number of value to be generated.
     * @return an ArrayList which contains a set of pseudorandom value.
     * @throws Exception
     */
    public ArrayList<Double> generateDouble(double lowerBound, double upperBound, int count) throws IllegalArgumentException {
        if (upperBound <= lowerBound) {
            throw new IllegalArgumentException("The upper bound should be bigger than the lower bound.\n"
                    + "Your upper bound: " + upperBound + ", your lower bound: " + lowerBound);
        }

        if (count <= 0) {
            throw new IllegalArgumentException("The count of number should be greater than 0, your count: " + count);
        }

        ArrayList<Double> dataset = new ArrayList<Double>();
        for (int i = 0; i < count; i++) {
            double randomNum = random.nextDouble() * (upperBound - lowerBound) + lowerBound;
            dataset.add(randomNum);
        }
        return dataset;
    }

    /**
     * Generate a set of pseudorandom value and write it to a specified file.
     * @param lowerBound the lower bound (inclusive).
     * @param upperBound the upper bound (exclusive).
     * @param count count number of value to be generated.
     * @param fileName path of the file to be written.
     * @throws IllegalArgumentException exception when there are bad arguments.
     */
    public void generateDouble(double lowerBound, double upperBound, int count, String fileName) throws IllegalArgumentException {
        if (upperBound <= lowerBound) {
            throw new IllegalArgumentException("The upper bound should be bigger than the lower bound.\n"
                    + "Your upper bound: " + upperBound + ", your lower bound: " + lowerBound);
        }

        if (count <= 0) {
            throw new IllegalArgumentException("The count of number should be greater than 0, your count: " + count);
        }
    }
  
}