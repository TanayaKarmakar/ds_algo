package com.app.practice.bitmagic;

public class HammingDistanceLeetcode461 {
	private static int hammingDistance(int x, int y) {
		int count = 0;
		while(x != 0 && y != 0) {
			int xVal = (x & 1);
			int yVal = (y & 1);
			if(xVal != yVal)
				count++;
			x = x >> 1;
			y = y >> 1;
		}
		
		while(x != 0) {
			count++;
			x = x & (x - 1);
		}
		
		while(y != 0) {
			count++;
			y = y & (y - 1);
		}
		
		return count;
	}

	public static void main(String[] args) {
		

	}

}
