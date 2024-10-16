package csc210;

import java.util.Random;

public class StandardDeviation {

    // 1. Generate an array of N random doubles in the range [0, 1)
    public static double[] generateRandomNumbers(int N) {
        Random random = new Random();
        double[] array = new double[N];
        for (int i = 0; i < N; i++) {
            array[i] = random.nextDouble();
        }
        return array;
    }

    // 2. Calculate the mean of the array
    public static double calculateMean(double[] array) {
        double sum = 0;
        for (double num : array) {
            sum += num;
        }
        return sum / array.length;
    }

    // 3. Calculate standard deviation using the Two-Pass method
    public static double standardDeviationTwoPass(double[] array) {
        int N = array.length;
        double mean = calculateMean(array);
        double sum = 0;
        for (double num : array) {
            sum += Math.pow(num - mean, 2);
        }
        double variance = sum / N;
        return Math.sqrt(variance);
    }

    // 4. Calculate standard deviation using the Naive method
    public static double standardDeviationNaive(double[] array) {
        int N = array.length;
        double sumOfSquares = 0;
        for (double num : array) {
            sumOfSquares += Math.pow(num, 2);
        }
        double mean = calculateMean(array);
        double variance = (sumOfSquares / N) - Math.pow(mean, 2);
        return Math.sqrt(variance);
    }

    // 5. Calculate standard deviation using Welford's method
    public static double standardDeviationWelford(double[] array) {
        double mean = 0.0;
        double M2 = 0.0;
        int i = 0;

        for (double x : array) {
            i++;
            double delta = x - mean;
            mean += delta / i;
            M2 += delta * (x - mean);
        }

        double variance = (i > 1) ? M2 / (i - 1) : 0.0;
        return Math.sqrt(variance);
    }

    // Main method to generate array and compute statistics
    public static void main(String[] args) {
        int N = 1000000;
        double[] randomNumbers = generateRandomNumbers(N);

        // Calculate the mean
        double mean = calculateMean(randomNumbers);

        // Calculate standard deviations
        double stddevTwoPass = standardDeviationTwoPass(randomNumbers);
        double stddevNaive = standardDeviationNaive(randomNumbers);
        double stddevWelford = standardDeviationWelford(randomNumbers);

        // Print results
        System.out.println("Mean: " + mean);
        System.out.println("Standard Deviation (Two-Pass Method): " + stddevTwoPass);
        System.out.println("Standard Deviation (Naive Method): " + stddevNaive);
        System.out.println("Standard Deviation (Welford's Method): " + stddevWelford);
    }
}
    
