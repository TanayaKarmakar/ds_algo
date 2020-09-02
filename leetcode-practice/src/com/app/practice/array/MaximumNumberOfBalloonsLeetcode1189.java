package com.app.practice.array;

import java.util.Scanner;

public class MaximumNumberOfBalloonsLeetcode1189 {
	private static int maxNumberOfBalloons(String text) {
		int[] chars = new int[256];

		for (int i = 0; i < text.length(); i++) {
			chars[text.charAt(i)]++;
		}
		
		String balloon = "balloon";
		int minOccuringChar = Integer.MAX_VALUE;
		
		for(int i = 0; i < balloon.length(); i++) {
			char ch = balloon.charAt(i);
			
			int currentOcc = chars[ch];
			if(ch == 'l' || ch == 'o') {
				if(currentOcc == 1)
					return 0;
				currentOcc = currentOcc / 2;
			}
			minOccuringChar = Integer.min(minOccuringChar, currentOcc);
		}
		return minOccuringChar;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String text = scanner.next();
		
		int ans = maxNumberOfBalloons(text);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
