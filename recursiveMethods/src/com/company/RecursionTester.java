package com.company;

/**
 * Example output...
 * <pre>
 * Test Activity 4:
 * Factorial:
 * 1   2   6   24   120   720   5040   40320   362880
 *
 * Fibonacci:
 * 1   1   2   3   5   8   13   21   34
 *
 * GCD:
 * GCD of 96 and 60 is 12
 * GCD of 30 and 10 is 10
 * GCD of 96 and 120 is 24
 * </pre>
 */
public class RecursionTester {

    public static void main(String[] args) {

        System.out.println("Test Activity 4:");
        System.out.println("Factorial:");
        for (int ii = 1; ii < 10; ii++) {
            System.out.print(Recursion.fact(ii) + "   ");
        }

        System.out.println("\n\nFibonacci:");
        for (int ii = 1; ii < 10; ii++) {
            System.out.print(Recursion.fib(ii) + "   ");
        }

        // Test Euclid's algorithm
        System.out.println("\n\nGCD:");
        System.out.println("GCD of 96 and 60 is " + Recursion.gcd(96, 60));
        System.out.println("GCD of 30 and 10 is " + Recursion.gcd(30, 10));
        System.out.println("GCD of 96 and 120 is " + Recursion.gcd(96, 120));
        System.out.println();

    }

}