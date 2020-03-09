package com.app.languagetools.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class RollMarks implements Comparable<RollMarks> {
	String name;
	int roll;
	int marks;

	public RollMarks(String name, int roll, int marks) {
		this.name = name;
		this.roll = roll;
		this.marks = marks;
	}

	@Override
	public int compareTo(RollMarks o) {
		if(this.marks == o.marks) {
			if(this.roll < o.roll)
				return -1;
			else if(this.roll > o.roll)
				return 1;
			else
				return 0;
		} else if(this.marks < o.marks)
			return 1;
		else
			return -1;
	}
}

public class TellThePosition {
	private static void getPositions(String[] data) {
		List<RollMarks> studentData = new ArrayList<>();
		int i = 0;
		for (i = 0; i < data.length; i++) {
			String[] item = data[i].split("\\s+");
			int marks = Integer.parseInt(item[1]) + Integer.parseInt(item[2])
			+ Integer.parseInt(item[3]);
			RollMarks obj = new RollMarks(item[0], i + 1, marks);
			studentData.add(obj);
		}
		Collections.sort(studentData);
		
		int indx = 1;
		for(RollMarks obj: studentData) {
			System.out.println(indx + " " + obj.name);
			indx++;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nDim = Integer.parseInt(scanner.nextLine());
		String[] data = new String[nDim];
		int i = 0;
		while (nDim > 0) {
			data[i++] = scanner.nextLine();
			nDim--;
		}
		getPositions(data);
		scanner.close();
	}

}
