package recursividad;

/**
 * A classic example of recursion: calculating the factorial of a number.
 * n! = n * (n-1) * (n-2) * ... * 1
 */
public class Factorial {

    /**
     * Calculates the factorial of a number n recursively.
     *
     * @param n The number to calculate the factorial of (must be non-negative).
     * @return The value of n!
     */
    public static long calculate(int n) {
        // Safety condition to prevent negative numbers.
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }

        // BASE CASE: The factorial of 0 is 1. The recursion stops here.
        if (n == 0) {
            return 1;
        }

        // RECURSIVE CASE: n! = n * (n-1)!
        // The function calls itself with a smaller problem (n-1).
        return n * calculate(n - 1);
    }

    public static void main(String[] args) {
        int number = 5;
        System.out.println("Calculating the factorial of " + number);
        long result = calculate(number);
        System.out.println("The factorial of " + number + " is: " + result); // Expected: 120

        number = 10;
        System.out.println("\nCalculating the factorial of " + number);
        result = calculate(number);
        System.out.println("The factorial of " + number + " is: " + result); // Expected: 3628800
    }
}
