package com.app.practice.strings;

public class MaximumNumberOfBalloonsLeetcode1189 {
	private static final String BALLOON = "balloon";
	
	private static int maxNumberOfBalloons(String str) {
		int[] freq = new int[256];
		
		int n = str.length();
		
		for(int i = 0; i < n; i++) {
			freq[str.charAt(i)]++;
		}
		
		
		int minOccurence = Integer.MAX_VALUE;
		for(int i = 0; i < 7; i++) {
			char ch = BALLOON.charAt(i);
			int currentOccurrence = freq[ch];
			if(ch == 'l' || ch == 'o') {
				if(currentOccurrence == 1)
					return 0;
				currentOccurrence = currentOccurrence / 2;
			}
			minOccurence = Integer.min(currentOccurrence, minOccurence);
		}
		return minOccurence;
	}

	public static void main(String[] args) {
		String text = "nlaebolko";
		
		int count = maxNumberOfBalloons(text);
		
		System.out.println(count);
		
		text = "loonbalxballpoon";
		
		count = maxNumberOfBalloons(text);
		
		System.out.println(count);

	}

}
