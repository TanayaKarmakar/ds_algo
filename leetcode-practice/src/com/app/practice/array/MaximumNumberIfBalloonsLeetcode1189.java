package com.app.practice.array;

public class MaximumNumberIfBalloonsLeetcode1189 {
	private static int maxNumberOfBalloons(String text) {
		int[] charFreq = new int[256];
		
		int n = text.length();
		for(int i = 0; i < n; i++) {
			charFreq[text.charAt(i)]++;
		}
		
		int minOccChar = Integer.MAX_VALUE;
		String balloon = "balloon";
		for(int i = 0; i < balloon.length(); i++) {
			char ch = balloon.charAt(i);
			int currentOcc = charFreq[ch];
			if(ch == 'l' || ch == 'o') {
				if(currentOcc == 1)
					return 0;
				
				currentOcc = currentOcc / 2;
			}
			minOccChar = Integer.min(minOccChar, currentOcc);
		}
		
		return minOccChar;
	}

	public static void main(String[] args) {
		String text = "loonbalxballpoon";
		
		int ans = maxNumberOfBalloons(text);
		
		System.out.println(ans);

	}

}
