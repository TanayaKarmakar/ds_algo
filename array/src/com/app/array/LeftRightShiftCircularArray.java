package com.app.array;

public class LeftRightShiftCircularArray {
	//right rotation
	private static int queryType1(int toRotate, int times, int n) {
		toRotate = (toRotate - times) % n;
		return toRotate;
	}
	
	private static int queryType2(int toRotate, int times, int n) {
		toRotate = (toRotate + times) % n;
		return toRotate;
	}
	
	private static int queryType3(int[] presum, int toRotate, int left, int right, int n) {
		left = (left + toRotate + n) % n;
		right = (right + toRotate + n) % n;
		
		if(left <= right) {
			return presum[right + 1] - presum[left];
		} else {
			return presum[n] + presum[right + 1] - presum[left];
		}
	}

	private static void wrapper(int[] arr) {
		int n = arr.length;
		int[] presum = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			presum[i] = presum[i - 1] + arr[i - 1];
		}
		//System.out.println(Arrays.toString(presum));
		int toRotate = 0;
		toRotate = queryType1(toRotate, 3, n);
		System.out.println("toRotate - " + toRotate);
		int sum = queryType3(presum, toRotate, 0, 2, n);
		System.out.println("Sum - " + sum);
		toRotate = queryType2(toRotate, 1, n);
		System.out.println("toRotate - " + toRotate);
		sum = queryType3(presum, toRotate, 1, 4, n);
		System.out.println("Sum - " + sum);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		wrapper(arr);
	}

}
