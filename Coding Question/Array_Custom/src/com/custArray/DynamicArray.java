package com.custArray;

import java.util.Arrays;

/**
 * Creating an Custom Dynamic Array
 * @author shaiama
 * 
 * Fields to be considered
 * 1)Storing Object
 * 2)Size initial
 * 3)Length
 * 
 * Methods
 * push->At the end,pop->At the end,delete->Based on Index,getlength
 *
 */
public class DynamicArray {
	
	private String[] value;
	
	int size;
	
	int length;

	public DynamicArray(int size) {
		super();
		//this.value = value;
		this.length = 0;
		this.size = size;
		value = new String[size];
	}

	public DynamicArray() {
		super();
		size=1;
		length=0;
		value = new String[size];
	}
	
	/**
	 * Resize Logic For our Dynamic Array
	 * @param currentSize
	 * @return
	 */
	private int getResizedLength(int currentSize) {
		return currentSize*2;
	}
	
	/**
	 * Push Logic at the end if Size is 10 then max lenght will be 9 ie (It starts from 0 to 9) thus if length == size then array is full
	 * @param insertionValue
	 */
	private void push(String insertionValue) {
		
		if (length == size) {
			
			String[] tempArray = new String[getResizedLength(size)];// New Array
			for (int i = 0; i < this.value.length; i++) {// Copied Value
				tempArray[i] = this.value[i];
			}
			
			this.value = tempArray;
			this.value[length] = insertionValue;
			this.size = getResizedLength(size);
			
		}else {
			this.value[length] = insertionValue;
		}
		
		this.length++;
	}
	
	private String get(int index) {
		if (index > -1 && index <= length) {
			return this.value[index];
		} else
			return "Index Out Of Bound";
	}
	
	private String replace(int index,String value) { 
		
		if(index >-1 && index < length) {
			for(int i=index;i< this.value.length;i++) {
				this.value[i]=value;
			}
			return value;
		}else
			return "Index Out Of Bound";
	}
	
	private void delete(int index) {
		if (index > -1 && index <= length-1) {
			if (index == length-1) {
				 pop();
			} else {
				for (int i = index; i < this.value.length-1; i++) {
					this.value[i]=this.value[i+1];
				}
			}
			this.length --;
		}
	}
	
	/**
	 * Deleting Last Element of Array
	 * @return
	 */
	private String pop() {
		if(length > 0) {
		String lastElement = this.value[length-1];
		this.length--;
		return lastElement;
		}else 
			return "Index out of Bound";
	}
	
	private String[] getArray() {
		String[] tempArray = new String[length];
		for (int i = 0; i < length; i++) {
			tempArray[i]=this.value[i];
		}
		return tempArray;
	}
	
	@Override
	public String toString() {
		return "DynamicArray [value=" + Arrays.toString(value) + ", size=" + size + ", length=" + length + "]";
	}

	public static void main(String[] args) {
		DynamicArray array = new DynamicArray();
		array.push("1");
		array.push("2");
		array.push("3");
		array.push("4");
		array.get(2);
		array.pop();
		array.replace(2, "30");
		array.delete(1);
		System.out.println(Arrays.toString(array.getArray()));
	}
}
