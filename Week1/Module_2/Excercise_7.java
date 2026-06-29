package Week1.Module_2;

/*
 * Exercise 7: Financial Forecasting
 * This program predicts the future value
 * using a recursive algorithm.
 */

public class Excercise_7 {

    // Recursive Method
    public static double futureValue(double currentValue, double growthRate, int years) {

        // Base Case
        if (years == 0) {
            return currentValue;
        }

        // Recursive Call
        return futureValue(currentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {

        double currentValue = 10000;
        double growthRate = 0.10;     // 10% Growth
        int years = 5;

        double result = futureValue(currentValue, growthRate, years);

        System.out.println("Current Value : ₹" + currentValue);
        System.out.println("Growth Rate : " + (growthRate * 100) + "%");
        System.out.println("Years : " + years);
        System.out.println("Future Value : ₹" + result);
    }
}