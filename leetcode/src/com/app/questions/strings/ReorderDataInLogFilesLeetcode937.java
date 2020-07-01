package com.app.questions.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//class Pair implements Comparable<Pair> {
//	String first;
//	String second;
//
//	@Override
//	public int compareTo(Pair o) {
//		int val = this.first.compareTo(o.first);
//		if (val == 0)
//			return this.second.compareTo(o.second);
//		return val;
//	}
//}

class LogComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		int space1 = o1.indexOf(' ');
		int space2 = o2.indexOf(' ');
		
		int val = o1.substring(space1 + 1).compareTo(o2.substring(space2 + 1));
		if(val == 0)
			return o1.substring(0, space1).compareTo(o2.substring(0, space2));
		return val;
	}
	
}

public class ReorderDataInLogFilesLeetcode937 {
	private static boolean isDigit(String part) {
		try {
			int val = Integer.parseInt(part.charAt(0) + "");
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	private static String[] reorderLogFiles(String[] logs) {
		int n = logs.length;

		List<String> textLogs = new ArrayList<>();
		List<String> digitLogs = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String part = logs[i].split("\\s+")[1];
			if (isDigit(part)) {
				digitLogs.add(logs[i]);
			} else {
				textLogs.add(logs[i]);
//				int indx = logs[i].indexOf(' ');
//				Pair pair = new Pair();
//				pair.first = logs[i].substring(indx + 1);
//				pair.second = logs[i];
//				textLogs.add(pair);
			}
		}

		Collections.sort(textLogs, new LogComparator());
		int j = 0;
		for (String str : textLogs) {
			logs[j++] = str;
		}

		for (String str : digitLogs) {
			logs[j++] = str;
		}

		return logs;
	}

	public static void main(String[] args) {
		String[] logs = { "dig1 8 1 5 1", "let1 art can", 
				"dig2 3 6", "let2 own kit dig", "let3 art zero" };
		
		logs = reorderLogFiles(logs);
		
		System.out.println(Arrays.toString(logs));

	}

}
