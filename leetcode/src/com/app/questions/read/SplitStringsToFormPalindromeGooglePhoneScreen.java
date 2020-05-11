package com.app.questions.read;

public class SplitStringsToFormPalindromeGooglePhoneScreen {
	private static boolean isPal(String a, String b) {
		boolean aSwitch = false;
		int i = 0;
		int j = b.length() - 1;
		while(i < j) {
			if(aSwitch) {
				if(a.charAt(i) != a.charAt(j))
					return false;
			} else if(a.charAt(i) != b.charAt(j)){
				if(a.charAt(i) == a.charAt(j))
					aSwitch = true;
				else
					return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		String str1 = "abcbbbb";
		String str2 = "xxxbcba";
		
		boolean isPossible = isPal(str1, str2) || isPal(str2, str1);
		
		System.out.println(isPossible);

	}

}
