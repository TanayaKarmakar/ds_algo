package com.app.practice;

public class AddBinaryLeetcode67 {

	private static String addBinary(String a, String b) {
		if (a.length() < b.length()) {
			String tmp = a;
			a = b;
			b = tmp;
		}
		char[] aNum = a.toCharArray();
		char[] bNum = b.toCharArray();

		StringBuilder sb = new StringBuilder();
		int carry = 0;
		int m = aNum.length;
		int n = bNum.length;

		int i = 0;
		int j = 0;

		for (i = m - 1, j = n - 1; i >= 0 && j >= 0; i--, j--) {
			if (aNum[i] == '0' && bNum[j] == '0') {
				if (carry != 0) {
					sb.append("1");
					carry = 0;
				} else {
					sb.append("0");
				}
			} else if (aNum[i] == '0' || bNum[j] == '0') {
				if (carry != 0) {
					sb.append("0");
				} else {
					sb.append("1");
				}
			} else {
				if (carry != 0) {
					sb.append("1");
				} else {
					sb.append("0");
					carry = 1;
				}
			}
		}

		while (i >= 0) {
			if (carry != 0) {
				if (aNum[i] == '0') {
					sb.append("1");
					carry = 0;
				} else {
					sb.append("0");
				}
			} else {
				sb.append(aNum[i]);
			}
			i--;
		}

		if (carry != 0) {
			sb.append(carry);
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		String a = "111";
		String b = "1";

		String res = addBinary(a, b);

		System.out.println(res);

	}

}
