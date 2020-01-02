package com.app.string.practice;

public class NthNumberMadeOfPrimeDigit {
	private static void nThNumberApproach1(int n) {
		StringBuilder sb = new StringBuilder();

		while (n > 0) {
			int rem = n % 4;
			if (rem == 1) {
				sb.append("2");
			} else if (rem == 2) {
				sb.append("3");
			} else if (rem == 3) {
				sb.append("5");
			} else if (rem == 0) {
				n--;
				sb.append("7");
			}
			n = n / 4;
		}

		System.out.println(sb.toString());
	}

	private static void nThNumber(int n) {
		long len = 1;
		long prevCount = 0;

		while (true) {
			long currentCount = prevCount + (long) Math.pow(4, len);
			if (prevCount < n && currentCount >= n)
				break;
			len++;
			prevCount = currentCount;
		}

		for (int i = 1; i <= len; i++) {
			for (int j = 1; j <= 4; j++) {
				if (prevCount + (long) Math.pow(4, len - i) < n) {
					prevCount += (long) Math.pow(4, len - i);
				} else {
					if (j == 1) {
						System.out.print("2");
					} else if (j == 2) {
						System.out.print("3");
					} else if (j == 3) {
						System.out.print("5");
					} else if (j == 4) {
						System.out.print("7");
					}
					break;
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		nThNumber(10);
		nThNumberApproach1(10);
	}

}
