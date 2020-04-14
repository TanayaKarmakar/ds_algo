package com.app.greedy.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Triangle implements Comparable<Triangle> {
	int side1;
	int side2;
	int side3;
	int permeter;
	
	@Override
	public int compareTo(Triangle o) {
		if(this.permeter < o.permeter)
			return 1;
		else if(this.permeter > o.permeter)
			return -1;
		else {
			int longestSide1 = Integer.max(this.side1, Integer.max(this.side2, this.side3));
			int longestSide2 = Integer.max(o.side1, Integer.max(o.side2, o.side3));
			if(longestSide1 > longestSide2)
				return -1;
			else if(longestSide1 < longestSide2)
				return 1;
			else {
				int minimumSide1 = Integer.min(this.side1, Integer.min(this.side2, this.side3));
				int minimumSide2 = Integer.min(o.side1, Integer.min(o.side2, o.side3));
				if(minimumSide1 > minimumSide2)
					return -1;
				else if(minimumSide1 < minimumSide2)
					return 1;
				else
					return 0;
			}
		}
	}	
}

public class PerimeterWithConditions {
	private static void solve(int[] values) {
		if(values.length < 3) {
			System.out.println("-1");
			return;
		}
		Arrays.sort(values);
		int n = values.length;
		List<Triangle> triangles = new ArrayList<>();
		for(int i = 0; i < n - 2; i++) {
			if(values[i] + values[i + 1] > values[i + 2]) {
				Triangle obj = new Triangle();
				obj.side1 = values[i];
				obj.side2 = values[i + 1];
				obj.side3 = values[i + 2];
				obj.permeter = obj.side1 + obj.side2 + obj.side3;
				triangles.add(obj);
			}
		}
		Collections.sort(triangles);
		if(triangles.size() == 0)
			System.out.println("-1");
		else {
			Triangle obj = triangles.get(0);
			System.out.println(obj.side1 + " " + obj.side2 + " " + obj.side3);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}

		solve(nums);
		
		scanner.close();
	}

}
