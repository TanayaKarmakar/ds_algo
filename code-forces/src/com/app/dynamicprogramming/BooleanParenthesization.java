package com.app.dynamicprogramming;

public class BooleanParenthesization {
	private static int countNumWays(String str1, String str2) {
		int n = str1.length();
		int[][] dpt = new int[n][n];
		int[][] dpf = new int[n][n];

		for (int g = 0; g < n; g++) {
			for (int i = 0, j = g; j < n; i++, j++) {
				if (g == 0) {
					if (str1.charAt(i) == 'T') {
						dpt[i][j] = 1;
						dpf[i][j] = 0;
					} else {
						dpt[i][j] = 0;
						dpf[i][j] = 1;
					}
				} else {
					for (int k = i; k < j; k++) {
						int ltc = dpt[i][k];
						int rtc = dpt[k + 1][j];
						int lfc = dpf[i][k];
						int rfc = dpf[k + 1][j];

						if (str2.charAt(k) == '&') {
							dpt[i][j] += ltc * rtc;
							dpf[i][j] += ltc * rfc + lfc * rtc + lfc * rfc;
						} else if (str2.charAt(k) == '|') {
							dpt[i][j] += ltc * rfc + lfc * rtc + ltc * rtc;
							dpf[i][j] += lfc * rfc;
						} else { // XOR
							dpt[i][j] += ltc * rfc + lfc * rtc;
							dpf[i][j] += lfc * rfc + ltc * rtc;
						}
					}
				}
			}
		}
		return dpt[0][n - 1];
	}

	public static void main(String[] args) {
		String str1 = "TFTF";
		String str2 = "&|^";
		
		int ans = countNumWays(str1, str2);
		
		System.out.println(ans);

	}

}
