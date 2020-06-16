/**
 * <h1>Statistics Test</h1>
 * This class provides various test cases to Test Statistics Class
 * <p>
 * These Tests are executed by running the TestSuite Class, which
 * actually contains the test suite for this project.
 *
 * @author  Sanchit Kumar
 * @version 1.0
 * @since   2020-05-17
 */


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import java.lang.Math;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class   StatisticsTest {
    private static Statistics statistics = new Statistics();
    double[] tempArr;

    @BeforeClass
    public static void  setUpClass(){
        System.out.println("\nPerforming setup before running test cases.\n");
        String fileName = "test\\test1.txt";
        ArrayList<Double> dataset = new ArrayList<Double>();
        try {
            Scanner reader = new Scanner(new File(fileName));
            while (reader.hasNextLine()) {
                dataset.add(Double.parseDouble(reader.nextLine()));
            }
            reader.close();
            statistics.readData(dataset);
        } catch (FileNotFoundException e) {
            System.out.println("An error occured when reading " + fileName + "\tError : " + e.getMessage() + "\n");
        }
        System.out.print("Setup Completed.\n");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("\nEnding StatisticsTest Class.\n");
    }

    @Test
    public void getMin() {
        System.out.println("\nExecuting test case for Minimum");
        assertEquals(1.75E-4, round(statistics.getMin(),6));
    }

    @Test
    public void getMax() {
        System.out.println("\nExecuting test case for Maximum");
        assertEquals(999.997246, round(statistics.getMax(),6));
    }

    @Test
    public void getMode() {
        System.out.println("\nExecuting test case for Mode");
        String fileName = "test\\test2.txt";
        Statistics tempVar = new Statistics();
        ArrayList<Double> dataset = new ArrayList<Double>();
        try {
            Scanner reader = new Scanner(new File(fileName));
            while (reader.hasNextLine()) {
                dataset.add(Double.parseDouble(reader.nextLine()));
            }
            reader.close();
            tempVar.readData(dataset);
        } catch (FileNotFoundException e) {
            System.out.println("An error occured when reading " + fileName + "\tError : " + e.getMessage() + "\n");
        }
        assertEquals(10.0, tempVar.getMode().get(0));
    }

    @Test
    public void getMedian() {
        System.out.println("\nExecuting test case for Median");
        assertEquals(499.474147, round(statistics.getMedian(), 6));
    }

    @Test
    public void getMean() {
        System.out.println("\nExecuting test case for Meam");
        assertEquals(499.898014, round(statistics.getMean(),6));

    }

    @Test
    public void getMAD() {
        System.out.println("\nExecuting test case for Mean Absolute Deviation");
        assertEquals(249.844572, round(statistics.getMAD(),6));
    }

    @Test
    public void getSD() {
        System.out.println("\nExecuting test case for Standard Deviation");
        assertEquals(288.561081, round(statistics.getSD(),6));
    }

    @Test
    public void getHarmonicMean() {
        System.out.println("\nExecuting test case for Harmonic Mean");
        assertEquals(43.739426, round(statistics.getHarmonicMean(),6));

    }

    @Test
    public void getVariance() {
        System.out.println("\nExecuting test case for Variance");
        assertEquals(83267.497348, round(statistics.getVariance(),6));
    }

    @Test
    public void getPVariance() {
        System.out.println("\nExecuting test case for PVariance");
        assertEquals(83267.41408, round(statistics.getPVariance(),6));
    }

    @Test
    public void getPSD(){
        System.out.println("\nExecuting test case for PSD");
        assertEquals(288.560937, round(statistics.getPSD(),6) );
    }

    @Test
    public void getAbs(){
        System.out.println("\nExecuting test case for ABS");
        assertEquals(10, Statistics.abs(-10));
    }

    @Test
    public void getSqrt(){
        System.out.println("\nExecuting test case for Square Root");
        assertEquals(5, round(Statistics.sqrt(25),0));
    }

    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


}