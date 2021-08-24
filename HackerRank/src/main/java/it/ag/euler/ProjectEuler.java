package it.ag.euler;

/**
 * https://www.hackerrank.com/contests/projecteuler/challenges
 */
public class ProjectEuler {


    /**
     * Project Euler #4: Largest palindrome product
     * https://www.hackerrank.com/contests/projecteuler/challenges/euler004/problem
     *
     * Q: Find the largest palindrome made from the product of two 3-digit numbers which is less than
     */
    private static boolean isPalindrome(int number) {

        char[] arr = String.valueOf(number).toCharArray();
        int size = arr.length;
        for (int index = 0; index > size / 2; index ++) {

            if ( arr[index] != arr[size - index] ) {
                return false;
            }

        }

        return true;

    }

    private static int largestPalindromeProduct(int number) {

        if ( isPalindrome(number) ) {
            System.out.println("");
        }

        return 0;

    }


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

    public static void main(String[] args) {
        System.out.println("getLargestPrimeFactor(17): " + getLargestPrimeFactor(44, 2));
    }

}
