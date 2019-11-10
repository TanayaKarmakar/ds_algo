package com.app.bitmagic.practice;

public class BinaryToGrayCode {
	private static char xor(char a, char b) {
		return (a == b) ? '0' : '1';
	}

	private static int toGrayCode(int num) {
		String binaryStr = Integer.toBinaryString(num);
		StringBuilder sb = new StringBuilder();
		sb.append(binaryStr.charAt(0));
		for (int i = 1; i < binaryStr.length(); i++) {
			sb.append(xor(binaryStr.charAt(i - 1), binaryStr.charAt(i)));
		}
		
		return Integer.parseInt(sb.toString(), 2);
	}

	public static void main(String[] args) {
		System.out.println("Gray code - " + toGrayCode(7));

	}

}
