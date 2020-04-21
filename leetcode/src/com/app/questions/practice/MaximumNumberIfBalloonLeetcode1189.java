package com.app.questions.practice;

public class MaximumNumberIfBalloonLeetcode1189 {
	private static int maxNumberOfBalloons(String text) {
		int[] chars = new int[256];
		int n = text.length();
		
		for(int i = 0; i < n; i++) {
			chars[text.charAt(i)]++;
		}
		
		String balloon = "balloon";
		
		int minOccurenceOfChar = Integer.MAX_VALUE;
		for(int i = 0; i < balloon.length(); i++) {
			char ch = balloon.charAt(i);
			int currentOcc = chars[ch];
			if(ch == 'l' || ch == 'o') {
				if(currentOcc == 1)
					return 0;
				currentOcc = currentOcc / 2;
			}
			minOccurenceOfChar = Integer.min(minOccurenceOfChar, currentOcc);
		}
		return minOccurenceOfChar;
	}

	public static void main(String[] args) {
		String str = "nlaebolko";
		
		System.out.println(maxNumberOfBalloons(str));
		
		str = "loonbalxballpoon";
		
		System.out.println(maxNumberOfBalloons(str));
		
		str = "balon";
		
		System.out.println(maxNumberOfBalloons(str));

	}

}
