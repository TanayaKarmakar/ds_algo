package com.app.julychallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PlusOne {
	private static int[] plusOne(int[] digits) {
		int n = digits.length;
		int carry = 0;
		List<Integer> res = new ArrayList<>();
		int sum = digits[n - 1] + 1;
		if (sum > 9) {
			carry = 1;
			sum = sum % 10;
		}
		res.add(0, sum);

		for (int i = n - 2; i >= 0; i--) {
			sum = digits[i];
			if (carry > 0) {
				sum += carry;
			}

			if (sum > 9) {
				carry = 1;
				sum = sum % 10;
			} else {
				carry = 0;
			}
			res.add(0, sum);
		}

		if (carry > 0)
			res.add(0, carry);

		int[] output = new int[res.size()];

		int i = 0;
		for (Integer el : res) {
			output[i++] = el;
		}

		return output;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int[] digits = new int[n];

		for (int i = 0; i < n; i++) {
			digits[i] = scanner.nextInt();
		}
		
		int[] output = plusOne(digits);
		
		System.out.println(Arrays.toString(output));
		
		scanner.close();
	}

}
