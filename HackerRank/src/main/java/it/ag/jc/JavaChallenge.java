package it.ag.jc;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.DatatypeConverter;

/**
 * @author Andrea
 * @implNote Hacker Rank Java practice implementations
 *
 * https://www.hackerrank.com/domains/java
 */
public class JavaChallenge {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING. The function accepts following
     * parameters: 1. INTEGER month 2. INTEGER day 3. INTEGER year
     */
    public static String findDay(int month, int day, int year) {

        String[] strDays = new String[] { "SUNDAY", "MONDAY", "TUESDAY", "WEDNSDAY", "THURSDAY", "FRIDAY", "SATURDAY" };
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month - 1, day);
        return strDays[cal.get(java.util.Calendar.DAY_OF_WEEK) - 1];

    }

    /*
     * Check if a BigInteger is probably a prime number
     * https://www.hackerrank.com/challenges/java-primality-test/problem
     */
    public static String isPrime(String number) {

        return new java.math.BigInteger(number).isProbablePrime(100) ? "prime" : "not prime";
    }

    /**
     * add and multiply huge numbers!
     * https://www.hackerrank.com/challenges/java-biginteger/problem
     */
    public static String calculateBigInteger(String numberOne, String numberTwo) {

        java.math.BigInteger one = new java.math.BigInteger(numberOne);
        java.math.BigInteger two = new java.math.BigInteger(numberTwo);

        return one.add(two) + "\n" + one.multiply(two);

    }

    public static final String regularExpression = "([a-zA-Z])(\\w){7,29}";

    /**
     * https://www.hackerrank.com/challenges/valid-username-checker/problem
     * @param s
     */
    public static String usernameValidator(String s) {

        if ( s.matches(regularExpression) ) {
            return "Valid";
        } else {
            return "Invalid";
        }

    }

    /**
     * https://www.hackerrank.com/challenges/tag-content-extractor/problem
     *
     * Code challenge day #2
     * @param line
     */
    public static void tagContentExtractor(String line) {

        boolean matchFound = false;
        Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
        Matcher m = r.matcher(line);

        while (m.find()) {
            System.out.println(m.group(2));
            matchFound = true;
        }

        if ( ! matchFound) {
            System.out.println("None");
        }

    }

    /**
     * https://www.hackerrank.com/challenges/java-exception-handling/problem
     */
    public static int power(int n, int p) throws Exception {

        if ( n < 0 || p < 0 ) {
            throw new Exception("n or p should not be negative.");
        } else if ( n == 0 && p == 0 ) {
            throw new Exception("n and p should not be zero.");
        } else {
            return (int) Math.pow(n, p);
        }

    }

    /**
     * https://www.hackerrank.com/challenges/java-bigdecimal/problem?isFullScreen=true
     */
    public static void javaBigDecimal(String[] set) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.next();
        }
        scanner.close();
        Arrays.sort(s, Collections.reverseOrder(Comparator.comparing(BigDecimal::new)));
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }

    }


    /**
     * https://www.hackerrank.com/challenges/java-md5/problem
     */
    public static void md5() throws NoSuchAlgorithmException {

        Scanner scan = new Scanner(System.in);
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(scan.nextLine().getBytes());
        System.out.print(DatatypeConverter.printHexBinary(md.digest()).toLowerCase());
        scan.close();

    }

    /**
     * https://www.hackerrank.com/challenges/sha-256/problem?h_r=next-challenge&h_v=zen
     */
    public static void sha256() throws NoSuchAlgorithmException {

        Scanner scan = new Scanner(System.in);
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(scan.nextLine().getBytes());
        System.out.print(DatatypeConverter.printHexBinary(digest.digest()).toLowerCase());
        scan.close();
    }




    public static void main(String[] args) throws NoSuchAlgorithmException {

        // System.out.println(findDay(10, 9, 2019));
        // System.out.println(isPrime("12312873127836127833"));
        // System.out.println(usernameValidator("aaaaaaa"));

        // tagContentExtractor("<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>");

        // md5();
        // sha256();


    }




    /**
     * Input

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];

     */



}
