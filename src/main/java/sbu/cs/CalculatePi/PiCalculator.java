package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.math.MathContext;

public class PiCalculator {
    public static class CalculatePi implements Runnable {
        MathContext mc = new MathContext(1000);
        BigDecimal four = BigDecimal.valueOf(4);
        BigDecimal x;
        int n;
        public CalculatePi(BigDecimal x, int n){
            this.x = x;
            this.n = n;
        }
        @Override
        public void run() {
            BigDecimal sign = new BigDecimal(1);
            if (n % 2 == 0){
                sign = new BigDecimal(-1);
            }
            BigDecimal numerator = four.multiply(sign, mc);
            BigDecimal denominator = BigDecimal.valueOf(2*n);
            denominator = denominator.multiply(BigDecimal.valueOf(2*n+1), mc);
            denominator = denominator.multiply(BigDecimal.valueOf(2*n+2), mc);
            BigDecimal result = numerator.divide(denominator, mc);
            //addToSum(result);
        }
    }



        /**
     * Calculate pi and represent it as a BigDecimal object with the given floating point number (digits after . )
     * There are several algorithms designed for calculating pi, it's up to you to decide which one to implement.
     Experiment with different algorithms to find accurate results.

     * You must design a multithreaded program to calculate pi. Creating a thread pool is recommended.
     * Create as many classes and threads as you need.
     * Your code must pass all of the test cases provided in the test folder.

     * @param floatingPoint the exact number of digits after the floating point
     * @return pi in string format (the string representation of the BigDecimal object)
     */

    public String calculate(int floatingPoint)
    {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        // Use the main function to test the code yourself


    }


    }
