package com.app.array;

public class AddTwoBinaryNumbers {
	private static String addTwoNumbers(String a, String b) {
		if (a.length() < b.length())
			return addTwoNumbers(b, a);
		int m = a.length();
		int n = b.length();

		char[] aArr = a.toCharArray();
		char[] bArr = b.toCharArray();

		StringBuilder sb = new StringBuilder();
		int carry = 0;

		int i = 0;
		int j = 0;
		for (i = m - 1, j = n - 1; i >= 0 && j >= 0; i--, j--) {
			char ch1 = aArr[i];
			char ch2 = bArr[j];

			if (ch1 == '0' && ch2 == '0') {
				if (carry > 0) {
					sb.append("1");
					carry = 0;
				} else {
					sb.append("0");
				}
			} else if (ch1 == '1' && ch2 == '1') {
				if (carry > 0) {
					sb.append("1");
				} else {
					sb.append("0");
					carry = 1;
				}
			} else {
				if (carry > 0) {
					sb.append("0");
				} else {
					sb.append("1");
				}
			}
		}

		while (i >= 0) {
			char ch1 = aArr[i];
			if (carry > 0) {
				if (ch1 == '0') {
					ch1 = '1';
					carry = 0;
				} else {
					ch1 = '0';
				}
			}
			sb.append(ch1 + "");
			i--;
		}
		
		if(carry > 0)
			sb.append("1");

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		String a = "11";
		String b = "1";
		
		String ans = addTwoNumbers(a, b);
		
		System.out.println(ans);
	}

}
