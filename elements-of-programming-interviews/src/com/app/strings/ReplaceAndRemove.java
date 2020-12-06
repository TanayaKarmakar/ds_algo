package com.app.strings;

public class ReplaceAndRemove {
	private static void replaceAndRemove(int size, char[] chars) {
		int writeIndx = 0;
		int aCount = 0;
		for (int i = 0; i < size; i++) {
			if (chars[i] != 'b')
				chars[writeIndx++] = chars[i];
			if (chars[i] == 'a')
				aCount++;
		}

		int currIndx = writeIndx - 1;
		int finalIndx = writeIndx + aCount - 1;

		for (int i = currIndx; i >= 0; i--) {
			if (chars[i] == 'a') {
				chars[finalIndx--] = 'd';
				chars[finalIndx--] = 'd';
			} else {
				chars[finalIndx--] = chars[i];
			}
		}
	}

	public static void main(String[] args) {
		char[] arr = new char[7];
		arr[0] = 'a';
		arr[1] = 'c';
		arr[2] = 'd';
		arr[3] = 'b';
		arr[4] = 'b';
		arr[5] = 'c';
		arr[6] = 'a';

		int size = 7;

		replaceAndRemove(size, arr);

		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}

}
