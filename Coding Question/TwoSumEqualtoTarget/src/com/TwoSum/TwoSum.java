package com.TwoSum;

import java.util.Arrays;

/**
 *Input: nums = [2,7,11,15], target = 9
	Output: [0,1]
	Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * @author shaiama
 *
 */
public class TwoSum {

	private static int[] twoSum(int[] array, int target) {

		int[] result = new int[2];
		if (array.length > 1) {
			int i = 0, j = 1;
			while (i < array.length) {

				if (j == array.length) {
					i++;
					j = 0;
				}
					
				if (i!=j && array[i] + array[j] == target) {
					result[0] = i;
					result[1] = j;
					break;
				}
				j++;
			}

		} else {
			return array;
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString( TwoSum.twoSum(new int[]{2,5,5,11},10)));

	}

}
