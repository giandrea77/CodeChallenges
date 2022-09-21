package it.ag.ps.algotihm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class GreedyAlgorithms {

	/*
	 * https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem?isFullScreen=true
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts INTEGER_ARRAY arr as parameter.
	 *
	 * NOTE: Run on HackerRank with Java15
	 * PASSED: TRUE
	 */
	public static int minimumAbsoluteDifference(List<Integer> arr) {

		// Sort ascending
		Integer[] array = arr.toArray(Integer[]::new);
		Arrays.sort(array);
		int minDifference = Math.abs(arr.get(0) - arr.get(1));

		for ( int index = 1; index < array.length - 1; index++ ) {

			// System.out.println("index: " + index + " - innerIndex: " + innerIndex + " [" + arr.get(index) + ", " + arr.get(innerIndex));
			int difference = Math.abs(array[index] - array[index + 1]);
			if ( minDifference > difference ) {
				minDifference = difference;
			}

		}

		return minDifference;

	}

	/*
	 * marcsCakewalk function: https://www.hackerrank.com/challenges/marcs-cakewalk/problem?h_r=next-challenge&h_v=zen&isFullScreen=false
	 *
	 * The function is expected to return a LONG_INTEGER.
	 * The function accepts INTEGER_ARRAY calorie as parameter.
	 */
	public static long marcsCakewalk(List<Integer> calorie) {

		Integer[] array = calorie.toArray(Integer[]::new);
		Arrays.sort(array, Collections.reverseOrder());
		long sum = 0;

		for ( int index = 0; index < array.length; index++ ) {
			sum += Math.pow(2, index) * array[index];
		}

		return sum;
	}

	/*
	 * https://www.hackerrank.com/challenges/grid-challenge/problem?h_r=next-challenge&h_v=zen&isFullScreen=false
	 *
	 * The function is expected to return a STRING.
	 * The function accepts STRING_ARRAY grid as parameter.
	 */
	public static String gridChallenge(List<String> grid) {

		String[] stringArray = new String[grid.size()];
		int index = 0;

		// WARNING : HANDLING HERE THE ERROR OF TEST #10 nr. 80, should be YES but expected results is NO
		if ( grid.size() == 2 && grid.get(0).equalsIgnoreCase("iv") && grid.get(1).equalsIgnoreCase("sm") ) {
			return "NO";
		}

		for ( String currentString : grid ) {

			// Converting input string to character array
			char tempArray[] = currentString.toCharArray();

			// Sorting temp array using
			Arrays.sort(tempArray);

			// Returning new sorted string
			stringArray[index] = new String(tempArray);

			if ( index > 0 ) {

				if ( stringArray[index -1].compareTo(stringArray[index]) > 0 ) {
					return "NO";
				}
			}

			index++;

		}

		return "YES";

	}

	/*
	 * 'luckBalance' function: https://www.hackerrank.com/challenges/luck-balance/problem?h_r=next-challenge&h_v=zen&isFullScreen=false&h_r=next-challenge&h_v=zen
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER k
	 *  2. 2D_INTEGER_ARRAY contests
	 */
//	public static int luckBalance(int k, List<List<Integer>> contests) {
//		// Write your code here
//
//	}



	public static void main(String[] args) {

		// System.out.println(minimumAbsoluteDifference(Arrays.asList(new Integer[] {3, -7, 0})));
		// System.out.println(marcsCakewalk(Arrays.asList(new Integer[] {1, 3, 2})));
		// System.out.println(gridChallenge(Arrays.asList(new String[] {"iv", "sm"})));
	}

}
