package com.app.questions.slidingwindow;

public class MinimumWindowSubsequenceLeetcode727 {
	private static String minWindow(String S, String T) {
		String minWindow = "";
		int min = S.length() + 1;
		int m = S.length();
		int n = T.length();
		
		int i = 0;
		int j = 0;
		for(i = 0; i < m; i++) {
			if(S.charAt(i) == T.charAt(j)) {
				j++;
				if(j == n) {
					int end = i + 1;
					j--;
					while(j >= 0) {
						if(S.charAt(i) == T.charAt(j))
							j--;
						i--;
					}
					i++;
					j++;
					if(min > end - i) {
						min = end - i;
						minWindow = S.substring(i, end);
					}
				}
			}
		}
		return minWindow;
	}

	public static void main(String[] args) {
		String S = "ffynmlzesdshlvugsigobut"
				+ "gaetsnjlizvqjdpccdylclqcb"
				+ "ghhixpjihximvhapymfkjxyyx"
				+ "fwvsfyctmhwmfjyjidnfryiyaj"
				+ "mtakisaxwglwpqaxaicuprrvxy"
				+ "bzdxunypzofhpclqiybgniqzsd"
				+ "eqwrdsfjyfkgmejxfqjkmukvgy"
				+ "gafwokeoeglanevavyrpduigitm"
				+ "rimtaslzboauwbluvlfqquocxrz"
				+ "rbvvplsivujojscytmeyjolvvyz"
				+ "wizpuhejsdzkfwgqdbwinkxqypa"
				+ "phktonqwwanapouqyjdbptqfowhe"
				+ "msnsl";
		String T = "michmznait";
		
		System.out.println(minWindow(S, T));

	}

}
