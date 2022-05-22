package com.ReverseCode;

public class ReverseString {
	
	private static String reverseString1(String value) {
		
		char[] charArray = value.toCharArray();
		char[] reverseString = new char[charArray.length];
		int lenght = charArray.length - 1;
		for (int i = 0; i < value.length(); i++) {
			reverseString[i] = charArray[lenght];
			lenght--;
		}
		return new String(reverseString);
	}
	
	private static String reverseString2(String value) {
		
		StringBuilder builder = new StringBuilder();
		for(int i=value.length()-1;i>=0;i--) {
			builder.append(value.charAt(i));
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		String word = "Hi My name is Andrei";
		
		System.out.println(ReverseString.reverseString1(word));
		System.out.println(ReverseString.reverseString2(word));
	}

}
