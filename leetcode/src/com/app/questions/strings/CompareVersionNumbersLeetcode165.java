package com.app.questions.strings;

public class CompareVersionNumbersLeetcode165 {
	private static int compareVersion(String version1, String version2) {
		String[] revisions1 = version1.split("\\.");
		String[] revisions2 = version2.split("\\.");

		int i = 0;
		int j = 0;
		int v1Count = 0;
		int v2Count = 0;

		while (i < revisions1.length && j < revisions2.length) {
			if(v1Count != v2Count)
				break;
			int r1 = Integer.parseInt(revisions1[i]);
			int r2 = Integer.parseInt(revisions2[j]);

			if (r1 > r2)
				v1Count++;
			else if (r2 > r1)
				v2Count++;
			else {
				v1Count++;
				v2Count++;
			}
			i++;
			j++;
		}
		
		if(v1Count == v2Count) {
			while(i < revisions1.length) {
				int r1 = Integer.parseInt(revisions1[i]);
				if(r1 > 0)
					v1Count++;
				i++;
			}
			
			while(j < revisions2.length) {
				int r2 = Integer.parseInt(revisions2[j]);
				if(r2 > 0)
					v2Count++;
				j++;
			}
		}
		
		if(v1Count < v2Count)
			return -1;
		else if(v1Count > v2Count)
			return 1;
		else
			return 0;
	}

	public static void main(String[] args) {
		String s1 = "7.5.2.3";
		String s2 = "7.5.3";

		System.out.println(compareVersion(s1, s2));
		
		s1 = "1.0";
		s2 = "1.0.0";
		
		System.out.println(compareVersion(s1, s2));
		
		s1 = "0.1";
		s2 = "1.1";
		
		System.out.println(compareVersion(s1, s2));
		
		

	}

}
