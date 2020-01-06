package com.app.string.practice;

public class RabinKarpPatternMatchingAlgo {
	private static void searchPattern(String txt, String patt, int q) {
		int n = txt.length();
		int m = patt.length();

		int h = 1;
		int d = 256;

		int i = 0;
		int j = 0;

		// hash function calculation
		for (i = 0; i < m - 1; i++) {
			h = (h * d) % q;
		}

		int txtHash = 0;
		int pattHash = 0;

		for (i = 0; i < m; i++) {
			txtHash = (txtHash * d + txt.charAt(i)) % q;
			pattHash = (pattHash * d + patt.charAt(i)) % q;
		}

		for (i = 0; i <= (n - m); i++) {
			if (txtHash == pattHash) {
				for (j = 0; j < m; j++) {
					if (txt.charAt(i + j) != patt.charAt(j))
						break;
				}

				if (j == m) {
					System.out.println("Pattern found at index - " + i);
				}
			}
			if (i < n - m) {
				txtHash = (d * (txtHash - txt.charAt(i) * h) + txt.charAt(i + m)) % q;
				if (txtHash < 0) {
					txtHash += q;
				}
			}
		}
	}

	public static void main(String[] args) {
		String txt = "this is a test string";
		String pattern = "test";
		
		int q = 101;
		searchPattern(txt, pattern, q);

	}

}
