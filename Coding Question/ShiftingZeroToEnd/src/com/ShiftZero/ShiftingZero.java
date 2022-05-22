package com.ShiftZero;

import java.util.Arrays;

public class ShiftingZero {

	/**
	 * 
	 * Input: nums = [0,1,0,3,12] Output: [1,3,12,0,0]
	 *1,0,0,3,12->1,0,3,0,12->
	 * @param nums
	 * @return
	 */
	private static int[] shiftingZeroToEnd(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			for(int j=0;j < nums.length-1 ;j++) {
				if(nums[j] == 0) {
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
					}
			}
		}
		return nums;
	}
	
	//Above Code is o(n2) while this is o(a+b)
	private static int[] modifiedLogic(int[] nums) {

		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[count++] = nums[i];
			}
		}
		
		while(count < nums.length) {
			nums[count] = 0;
			count++;
		}
		
		return nums;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(ShiftingZero.shiftingZeroToEnd(new int[] {0,1,0,3,12})));
		System.out.println(Arrays.toString(ShiftingZero.modifiedLogic(new int[] {0,1,0,3,12})));
	}
	
}
