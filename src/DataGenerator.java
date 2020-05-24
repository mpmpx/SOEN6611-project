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
}