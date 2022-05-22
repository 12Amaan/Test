package com.FindDuplicates;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {

	/**
	 * Input: nums = [1,2,3,1]
		Output: true
	 * @param array
	 * @return
	 */
	//This Approach is Slow
	private static boolean findDuplicate(int[] array) {
		
		int i=0,j=0;
		if(array.length == 1)
			return false;
		else {
			while(i < array.length) {
				
				if(j == array.length) {
					j=0;
					i++;
				}
				if(i == array.length)
					break;
				
				if(i!=j && array[i] == array[j]) {
					return true;
				}else {
					j++;
				}
			}
			return false;
		}
		
	}
	
	private static boolean findModifiedDuplicate(int[] array) {
		
		Set<Integer> intSet = new HashSet<>();
		for(int i=0;i < array.length ; i++) {
			if(intSet.contains(array[i])) {
				return true;
			}else {
				intSet.add(array[i]);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(findDuplicate(new int[] {1,2,3,4}));
		System.out.println(findModifiedDuplicate(new int[] {1,2,3,4}));
	}

}
