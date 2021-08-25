package it.ag.euler;

/**
 * https://www.hackerrank.com/contests/projecteuler/challenges
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
        long sumOfEachAndSquare = (long)Math.pow( (number * (number + 1)) / 2, 2);
        return sumOfEachAndSquare - sumOfSquareEach;

    }

    /**
     * Project Euler #7: 10001st prime
     *
     * @param number
     */
    public static int prime10001th(int number) {

        return 0;

    }

    public static void main(String[] args) {

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
        System.out.println(sumSquareDifference(3L));

    }

}
