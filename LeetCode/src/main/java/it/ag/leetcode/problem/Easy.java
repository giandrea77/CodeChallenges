package it.ag.leetcode.problem;

import java.util.Arrays;

public class Easy {

	// https://leetcode.com/problems/two-sum/
	public static int[] twoSum(int[] nums, int target) {

		boolean found = false;
		int leftAddend = 0;
		int[] result = new int[2];

		while (!found && leftAddend < nums.length) {

			for ( int index = 0; leftAddend < nums.length; index ++ ) {

				if ( leftAddend != index && nums[leftAddend] + nums[index] == target ) {
					found = true;
					result[0] = leftAddend;
					result[1] = index;
					break;
				}

			}

			leftAddend++;

		}

		return result;

	}

	public static void main(String[] args) {

		System.out.println(Arrays.toString(twoSum(new int [] {2,7,11,15}, 9)));

	}


}
