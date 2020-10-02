package com.app.questions.strings;

public class AddStringsLeetcode415 {
	private static String addStrings(String num1, String num2) {
		char[] num1Arr = num1.toCharArray();
		char[] num2Arr = num2.toCharArray();

		int m = num1Arr.length;
		int n = num2Arr.length;

		int carry = 0;
		StringBuilder sb = new StringBuilder();

		int i = m - 1;
		int j = n - 1;

		while (i >= 0 && j >= 0) {
			int sum = (num1Arr[i] - '0') + (num2Arr[j] - '0');

			if (carry > 0) {
				sum += carry;
			}

			if (sum > 9) {
				carry = sum / 10;
				sum = sum % 10;
			} else {
				carry = 0;
			}

			sb.insert(0, (char)(sum + '0'));
			i--;
			j--;

		}

		while (i >= 0) {
			int sum = num1Arr[i] - '0';

			if (carry > 0)
				sum = sum + carry;
			if (sum > 9) {
				carry = sum / 10;
				sum = sum % 10;
			} else {
				carry = 0;
			}
			sb.insert(0, (char)(sum + '0'));
			i--;
		}

		while (j >= 0) {
			int sum = num2Arr[j] - '0';

			if (carry > 0) {
				sum = sum + carry;
			}
			if (sum > 9) {
				carry = sum / 10;
				sum = sum % 10;
			} else {
				carry = 0;
			}
			sb.insert(0, (char)(sum + '0'));
			j--;
		}

		if (carry > 0) {
			sb.insert(0, (char)(carry + '0'));
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String num1 = "100";
		String num2 = "1";
		
		String result = addStrings(num1, num2);
		
		System.out.println(result);

	}

}
