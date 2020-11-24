package com.app.questions.strings;

public class StrongPasswordCheckerLeetcode420 {
	private static int strongPasswordChecker(String s) {
		int option1 = 0;
		if(s.length() < 6) {
			//option1 = 6 - s.length();
			return 6 - s.length();// number of insertion
		}
		if(s.length() > 20) {
			option1 = s.length() - 20; //number of deletion
		}
		
		int option2 = 0;
		int upperCaseCount = 0;
		int lowerCaseCount = 0;
		int digitCount = 0;
		
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(Character.isDigit(ch)) {
				digitCount++;
			}
			if(ch >= 'a' && ch <= 'z')
				lowerCaseCount++;
			if(ch >= 'A' && ch <= 'Z')
				upperCaseCount++;
		}
		
		// here insertionCount = replacementCount
		if(digitCount < 1)
			option2++;
		if(lowerCaseCount < 1)
			option2++;
		if(upperCaseCount < 1)
			option2++;
		
		int i = 0;
		int option3 = 0;
		
		while(i < s.length()) {
			int j = i + 1;
			while(j < s.length() && s.charAt(i) == s.charAt(j)) {
				j++;
			}
			if((j - i) >= 3) {
				int ans = (j - i) / 3;
				option3 += ans;
			}
			
			i = j;
		}
		
		if(option1 == 0 && option2 == 0 && option3 == 0)
			return 0; // strong password
		
		if(option1 > 0) {
			int ans = 0;
			if(option2 > 0) {
				ans = option2;
			}
			
			if(option3 > 0) {
				if((s.length() - option3) <= 20) {
					option1 = option3;
				}
			}
			option1 += ans;
			return option1;
		}
		
		if(option3 > 0) {
			return option3;
		}
		
		return option2;
		
	}

	public static void main(String[] args) {
		String password = "ABABABABABABABABABAB1";
		
		int minChange = strongPasswordChecker(password);
		
		System.out.println(minChange);
		
		password = "bbaaaaaaaaaaaaaaacccccc";
		
		minChange = strongPasswordChecker(password);
		
		System.out.println(minChange);


	}

}
