package com.app.bitmagic.classroom;

import java.util.Scanner;

//set a bit at nth position in number 'num'
public class SetBit {
	private static void setBitAtN(int num, int nVal) {
		int nValLeftShift = (1 << nVal);

		System.out.println("N value left shift - " + nValLeftShift);

		System.out.println("After setting " + nVal + "th bit in number " + num + " -> " + (num | nValLeftShift));
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		int nVal = scanner.nextInt();

		System.out.println("Number - " + number);
		System.out.println("NVal - " + nVal);

		setBitAtN(number, nVal);

		scanner.close();
	}

}
