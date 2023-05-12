package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class PiCalculator {
    public static class CalculatePi implements Runnable {
        MathContext mc = new MathContext(1000);
        BigDecimal four = BigDecimal.valueOf(4);
        BigDecimal x;
        int n;
        public CalculatePi(int n){
            this.n = n;
        }
        @Override
        public void run() {
            BigDecimal sign = new BigDecimal(1);
            if (n % 2 == 0){
                sign = new BigDecimal(-1);
            }
            BigDecimal numerator = four.multiply(sign);
            int integer = 2 * n * (2 * n + 1) * (2 * n + 2);
            BigDecimal denominator = new BigDecimal(integer);
            BigDecimal result = numerator.divide(denominator, new MathContext(1000));
            addToSum(result);
        }
    }

    public static BigDecimal sum = new BigDecimal(0);

    public static synchronized void addToSum(BigDecimal bit){
        sum = sum.add(bit);
    }


        /**
         * Calculate pi and represent it as a BigDecimal object with the given floating point number (digits after . )
         * There are several algorithms designed for calculating pi, it's up to you to decide which one to implement.
         * Experiment with different algorithms to find accurate results.
         * <p>
         * You must design a multithreaded program to calculate pi. Creating a thread pool is recommended.
         * Create as many classes and threads as you need.
         * Your code must pass all of the test cases provided in the test folder.
         *
         * @param floatingPoint the exact number of digits after the floating point
         * @return pi in string format (the string representation of the BigDecimal object)
         */

    public static String calculate(int floatingPoint)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(4);;
        for (int i = 1; i <= floatingPoint; i++){
            CalculatePi tp = new CalculatePi(i);
            executorService.execute(tp);
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        sum = sum.setScale(floatingPoint, RoundingMode.HALF_DOWN);
        BigDecimal three = new BigDecimal(3);
        sum = sum.add(three);
        return sum.toString();
    }

    public static void main(String[] args) {
        // Use the main function to test the code yourself

    }


    }
