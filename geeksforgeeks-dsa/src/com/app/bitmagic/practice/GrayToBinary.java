package com.app.bitmagic.practice;

public class GrayToBinary {
	private static char flip(char ch) {
		return ch == '0' ? '1' : '0';
	}

	private static int grayToBinary(int num) {
		String grayCodeStr = Integer.toBinaryString(num);
		StringBuilder binaryCodeSb = new StringBuilder();
		binaryCodeSb.append(grayCodeStr.charAt(0));

		for (int i = 1; i < grayCodeStr.length(); i++) {
			if (grayCodeStr.charAt(i) == '0') {
				binaryCodeSb.append(binaryCodeSb.toString().charAt(i - 1));
			} else {
				binaryCodeSb.append(flip(binaryCodeSb.toString().charAt(i - 1)));
			}
		}
		return Integer.parseInt(binaryCodeSb.toString(), 2);
	}

	public static void main(String[] args) {
		System.out.println("Gray to Binary - " + grayToBinary(6));

	}

}
