package com.MaxSubArray;


public class MaxSubArray {
	/**
	 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]//
		Output: 6
		Explanation: [4,-1,2,1] has the largest sum = 6.
	 * 
	 * 
	 * @author shaiama
	 *
	 */
	private static int maxSubArray(int[] nums) {
		int sum = 0, max = 0, i = 0;
		while (i < nums.length) {
			sum = sum + nums[i];
			max = Integer.max(max, sum);
			if (sum < 0) {
				sum = 0;
			}
			i++;
		}
		return max;
	}
	
	/**
	 * 	Input: nums = [2,3,-2,4]
		Output: 6
		Explanation: [2,3] has the largest product 6.
	 * 
	 * 
	 * [-3,-1,-1]
	 */
	private static int maxProductSubArray(int[] nums) {
		int product = 1, max = 0, i = 0;
		if (nums.length > 0) {
			while (i < nums.length) {
				product = product * nums[i];
				max = Integer.max(max, product);
				if (product == 0 || product < 0) {
					product = 1;
				}
				i++;
			}
		} 
		if(max == 0 ) {
			
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(MaxSubArray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
		System.out.println(MaxSubArray.maxProductSubArray(new int[] {-2,0,-1}));
	}

}
