package com.app.string.practice;

/*Given a binary string S. The task is to count the 
number of substrings that start and end with 1. 
For example, if the input string is “00100101”, 
then there are three substrings “1001”, “100101” and “101”.*/

public class BinaryString {
	private static int countEfficient(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				count++;
			}
		}

		return (count * (count - 1)) / 2;
	}

	private static int count(String str) {
		int num = Integer.parseInt(str, 2);

		int count = 0;
		while (num > 0) {
			num = (num & (num - 1));
			count++;
		}

		return (count * (count - 1)) / 2;
	}

	public static void main(String[] args) {
		String str = "00100101";
		System.out.println("Count - " + count(str));
		System.out.println("Count Efficient- " + countEfficient(str));

		str = "1111";
		System.out.println("Count - " + count(str));
		System.out.println("Count Efiicient - " + countEfficient(str));

	}

}
