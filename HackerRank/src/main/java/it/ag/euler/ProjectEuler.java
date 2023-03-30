package it.ag.euler;

import io.jmll.core.JmllConstants;
import io.jmll.core.JmllCore;
import io.jmll.core.types.JmllCoreInteger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 * https://www.hackerrank.com/contests/projecteuler/challenges
 *
 * @author Andrea Girardi
 * @since Aug 24th, 2021
 */
public class ProjectEuler {


    /**
     * Project Euler #3: Largest prime factor
     * https://www.hackerrank.com/contests/projecteuler/challenges/euler003/problem
     *
     * Q: What is the largest prime factor of a given number?
     *
     */
    private static long findNextPrime( long number) {

        // Just odd number
        for ( int index = 3; index <= Math.sqrt(number); index = index + 2 ) {

            if ( number % index == 0 ) {
                return index;
            }

        }

        return number;

    }

    private static long getLargestPrimeFactor(long number, long maxPrime) {

        if ( number == 1 ) {
            return maxPrime;
        }

        if ( number % 2 == 0 ) {

            // Even
            maxPrime = ( maxPrime > 2 ? maxPrime : 2);

        } else {

            // Odd
            maxPrime = findNextPrime(number);

        }

        return getLargestPrimeFactor(number / maxPrime, maxPrime);

    }

    /**
     * Project Euler #4: Largest palindrome product
     * https://www.hackerrank.com/contests/projecteuler/challenges/euler004/problem
     *
     * Q: Find the largest palindrome made from the product of two 3-digit numbers which is less than
     */
    private static boolean isPalindrome(int number) {

        char[] arr = String.valueOf(number).toCharArray();
        int size = arr.length;
        for (int index = 0; index < size / 2; index ++) {

            if ( arr[index] != arr[(size - 1) - index] ) {
                return false;
            }

        }

        return true;

    }

    private static int largestPalindromeProduct(int number) {

        int smallest = 0;
        if ( number < 101102 || number > 1000000 ) {
            return 0;
        }

        for ( int index = 100; index <= 999; index++ ) {

            for ( int innerIndex = 100; innerIndex <= 999; innerIndex++ ) {

                int mult = index * innerIndex;
                if ( mult > 101101 && isPalindrome(mult) && mult < number ){
                    smallest = mult > smallest ? mult : smallest;
                }

            }


        }

        return smallest;

    }

    /**
     * Project Euler #5: Smallest multiple
     * https://www.hackerrank.com/contests/projecteuler/challenges/euler005/problem
     *
     * @param
     */
    public static int smallstMultiple(int number) {

        if ( number == 1 ) {
            return 1;
        }

        boolean found = false;
        int result = 0;
        while ( !found && result < 800000 ) {

            result++;

            for ( int index = 2; index <= number; index++ ) {

                if ( result % index == 0 ) {
                    found = false;
                    break;
                } else {
                    found = true;
                }

            }
        }

        if (found) {
            return result;
        } else {
            return 0;
        }

    }

    /**
     * Project Euler #6: Sum square difference
     * https://www.hackerrank.com/contests/projecteuler/challenges/euler006/problem
     *
     * Find the absolute difference between the sum of the squares of the first  natural numbers and the square of the sum.
     *
     * @param
     */
    public static Long sumSquareDifference(Long number) {

        long sumOfSquareEach = (number * (number + 1) * (2 * number + 1)) / 6;
        long sumOfEachAndSquare = (long) Math.pow( (number * (number + 1)) / 2, 2);
        return sumOfEachAndSquare - sumOfSquareEach;

    }

    /**
     * Project Euler #7: 10001st prime
     * https://www.hackerrank.com/contests/projecteuler/challenges/euler007/problem
     *
     * Q: What is the Nth  prime number?
     *
     * @param number
     */
    public static boolean isPrime(int number) {

        if ( number == 3 || number == 5 ) {
            return true;
        }

        if ( number % 2 == 0 || number % 3 == 0 || number % 5 == 0 ) {
            return false;
        }

        int sqrt = (int) Math.sqrt(number);
        int index = 5;

        while (index <= sqrt) {

            // https://www.xarg.org/puzzle/project-euler/problem-7/
            // What we also can do is unrolling checks of multiples of 2 and 3, which allows us to loop in a stepwidth of 6, which however requires a check of every
            // i + 2 as well.
            // However, it is also known that all primes except 2 and 3 have the form 6k + 1 or 6k - 1
            // which allows us to go in steps of 6. An implementation can then look as follows:

            if ( number % index == 0) {
                return false;
            }

            if (number % (index + 2) == 0) {
                return false;
            }

            index += 6;

        }

        return true;

    }

    public static int printNTHPrimeNumber(int number) {

        int[] primes = new int[10000];
        primes[0] = 2;

        int counter = 0;
        int next = 3;

        while (counter < ( number - 1) ) {

            if (isPrime(next)) {
                counter++;
                primes[counter] = next;
            }

            next = next + 2;

        }

        return primes[number - 1];

    }

    /**
     * Project Euler #8: Largest product in a series
     * https://www.hackerrank.com/contests/projecteuler/challenges/euler008/problem
     *
     *
     * @param number
     */
    public static int largeProductInASerie(String number, int size) {

        int max = 0;

        for (int index = 0; index < number.length() - size; index ++ ) {

            int mult = 1;
            char[] subString = number.substring(index, index + size).toCharArray();
            for ( int innerIndex = 0; innerIndex < size; innerIndex++ ) {
                int value = Integer.parseInt(Character.toString(subString[innerIndex]));
                mult = mult * value;
            }

            if ( max < mult ) {
                max = mult;
            }

        }

        return max;

    }

    /**
     * Project Euler #9: Special Pythagorean triplet
     * https://www.hackerrank.com/contests/projecteuler/challenges/euler009/problem
     *
     *
     * for _ in range(int(input())):
     *     n = int(input())
     *     m = -1
     *     for a in range(3, (n//3)+1):
     *         b = (n**2 - 2*a*n)//(2*n - 2*a)
     *         c = n - b - a
     *         if a**2 + b **2 == c**2:
     *             if a*b*c > m:
     *                 m = a*b*c
     *     print(m)
     *
     * @param N
     */
    public static int specialPythagoreanTriplet(int N) {

        int max = -1;
        int pythagoreanTriplet = 0;

        for ( int a = 3; a < (N / 3) + 1; a++ ) {

            int b = ((N * N) - (2 * a * N)) / ( (2 * N) - (2 * a));
            int c = N - b - a;

            if ( ( a * a + b * b ) == c * c ) {
                pythagoreanTriplet = a * b * c;
                if ( pythagoreanTriplet > max ) {
                    max = pythagoreanTriplet;
                }
            }

        }

        return max;

    }

    /**
     * Project Euler #10: Summation of primes
     * https://www.hackerrank.com/contests/projecteuler/challenges/euler010/problem
     *
     *
     *
     * @param number
     */
    public static long summationOfPrimes(int number) {

        // Initialize the array
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean[] primes = new boolean[10000000 + 1];

        for ( int index = 2; index <= 10000000; index++ ) {
            primes[index] = true;
        }

        for ( int index = 2; index * index <= 10000000; index++ ) {

            // If prime[p] is not changed, then it is a prime
            if ( primes[index] ) {

                // Update all multiples of p
                for ( int innerIndex = index * 2; innerIndex <= 10000000; innerIndex += index) {
                    primes[innerIndex] = false;
                }

            }

        }

        long sum = 0;
        // long[] sumPrimes = new long[1000000 + 1];

        for ( int index = 2; index <= number; index++ ) {

            if ( primes[index]) {
                sum += index;
            }
            // sumPrimes[index] = sum;

        }

        return sum;

    }

    /**
     * Project Euler #11: Largest product in a grid
     * https://www.hackerrank.com/contests/projecteuler/challenges/euler011/problem
     *
     * Q: What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20 X 20 grid?
     *
     * @param grid
     */
    public static long largestProductInAGrid(Integer[][] grid) {

        int max = 0;

        for (int y = 0; y < 20; y++ ) {

            for ( int x = 0; x < 20; x++ ) {

                int currentMult = 0;

                // mult horiz
                if ( x <= 16 ) {
                    currentMult = grid[x][y] * grid[x+1][y] * grid[x+2][y] * grid[x+3][y];
                    max = max < currentMult ? currentMult : max;
                }

                // mult vert
                if ( y <= 16 ) {
                    currentMult = grid[x][y] * grid[x][y+1] * grid[x][y+2] * grid[x][y+3];
                    max = max < currentMult ? currentMult : max;
                }

                // mult diag LtoR
                if ( x <= 16 && y <= 16 ) {
                    currentMult = grid[x][y] * grid[x+1][y+1] * grid[x+2][y+2] * grid[x+3][y+3];
                    max = max < currentMult ? currentMult : max;
                }

                // mult diag RtoL
                if ( x >= 3 && y <= 16 ) {
                    currentMult = grid[x][y] * grid[x-1][y+1] * grid[x-2][y+2] * grid[x-3][y+3];
                    max = max < currentMult ? currentMult : max;
                }

            }

        }

        return max;

    }


    private static Integer getAllFactorsVer(int n) {
        Set<Integer> factors = new HashSet<>();
        int step = n % 2 == 0 ? 1 : 2;
        for (int i = 1; i <= Math.sqrt(n); i += step) {
            if (n % i == 0) {
                factors.add(i);
                factors.add(n / i);
            }
        }
        return factors.size();
    }

    public static int highlyDivisibleTriangularNumber(int number) {

        if ( number == 1) {
            return 3;
        }

        int index = 1;

        while (index <= 1000) {

            // Triangle number calculation
            int triangleNumber = index * ( index + 1 )/ 2 ;
            if ( getAllFactorsVer(triangleNumber) > number ) {
                return triangleNumber;
            }

            index++;

        }

        return 0;

    }

    public static void main(String[] args) {

//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        for(int a0 = 0; a0 < t; a0++){
//            int n = in.nextInt();
//        }


        // Project Euler #3: Largest prime factor
        // System.out.println("getLargestPrimeFactor(17): " + getLargestPrimeFactor(44, 2));

        // Project Euler #4: Largest palindrome product
        // int result = largestPalindromeProduct(793397) ;
        //if ( result > 0 ) {
        //    System.out.println(result);
        // }

        // Project Euler #5: Smallest multiple
        // System.out.println(smallstMultiple(32));

        // Project Euler #6: Sum square difference
        // System.out.println(sumSquareDifference(3L));

        // Project Euler #7: 10001st prime
        // System.out.println(printNTHPrimeNumber(5000));

        // Project Euler #8: Largest product in a series
        // System.out.println(largeProductInASerie("3675356291", 5));

        // Project Euler #9: Special Pythagorean triplet
        // System.out.println(specialPythagoreanTriplet(12));

        // System.out.println(summationOfPrimes(100));

        // Project Euler #11: Largest product in a grid
//        JmllCore<Integer> jmllCore = new JmllCoreInteger();
//        Integer[][] matrixMinMax = jmllCore.generateMatrix(20,20, JmllConstants.Sign.NEUTRAL, 1, 50);
//        System.out.println("matrixMinMax: " + largestProductInAGrid(matrixMinMax));

        //
        // System.out.println(highlyDivisibleTriangularNumber(1));
        // System.out.println(highlyDivisibleTriangularNumber(2));
        // System.out.println(highlyDivisibleTriangularNumber(3));
        System.out.println(highlyDivisibleTriangularNumber(8));


    }

}
