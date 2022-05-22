package com.MergeSortedArray;

import java.util.Arrays;

public class MergeSortedArray {
	/*.............. Merge Sorted Arrays ..............*/
	// merge two sorted arrays so that final result is a merged sorted array.
	// example: [0,3,4,31] and [4,6,30] when merged gives output:
	// [0, 3, 4, 4, 6, 30, 31]
	
	private static int[] mergeSortedArray(int[] array1, int[] array2) {

		if (array1.length > 0 && array2.length > 0) {
			int i = 0, j = 0, k = 0;
			int[] mergedSortedArray = new int[array1.length + array2.length];

			while (i < array1.length && j < array2.length) {
				if (array1[i] < array2[j]) {
					mergedSortedArray[k] = array1[i];
					i++;
					k++;
				} else {
					mergedSortedArray[k] = array2[j];
					j++;
					k++;
				}
			}

			while (i < array1.length) {
				mergedSortedArray[k] = array1[i];
				i++;
				k++;
			}
			while (j < array2.length) {
				mergedSortedArray[k] = array1[j];
				j++;
				k++;
			}
			
			return mergedSortedArray;
		}else {
			return array1.length > 0? array1:array2;
		}
		
		
	}
	
	// example: [0,3,4,31] and [4,6,30] when merged gives output:
		// [0, 3, 4, 6, 30, 31]
	private static int[] mergeSortedArrayRemovingDublicate(int[] array1,int[] array2) {
		
		if (array1.length > 0 && array2.length > 0) {
			int i = 0, j = 0, k = 0;
			int[] mergedSortedArray = new int[array1.length + array2.length];

			while (i < array1.length && j < array2.length) {
				if (array1[i] < array2[j]) {
					mergedSortedArray[k] = array1[i];
					i++;
					k++;
				} else if(array1[i] == array2[j]){
					mergedSortedArray[k] = array2[j];
					j++;
					i++;
					k++;
				}else {
					mergedSortedArray[k] = array2[j];
					j++;
					k++;
				}
			}

			while (i < array1.length) {
				mergedSortedArray[k] = array1[i];
				i++;
				k++;
			}
			while (j < array2.length) {
				mergedSortedArray[k] = array1[j];
				j++;
				k++;
			}
			
			if(k<mergedSortedArray.length) {
				
				int[] removedDublicate = new int[k];
				
				for(int f=0;f<k;f++) {
					removedDublicate[f]=mergedSortedArray[f];
				}
				return removedDublicate;
			}
			return mergedSortedArray;
		}else {
			return array1.length > 0? array1:array2;
		}
		
	}

	public static void main(String[] args) {
		
			System.out.println(Arrays.toString( MergeSortedArray.mergeSortedArray(new int[]{0, 3, 4, 31}, new int[]{4, 6, 30})));
			System.out.println(Arrays.toString( MergeSortedArray.mergeSortedArrayRemovingDublicate(new int[]{0, 3, 4, 31}, new int[]{4, 6, 30})));
	}

}
