package com.app.practice.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class TextLogComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		int spaceIndx1 = o1.indexOf(' ');
		String o1F = o1.substring(spaceIndx1 + 1);

		int spaceIndx2 = o2.indexOf(' ');
		String o2F = o2.substring(spaceIndx2 + 1);

		int val = o1F.compareTo(o2F);
		if (val == 0)
			return o1.compareTo(o2);
		return val;
	}

}

public class ReorderDataInLogFilesLeetcode937 {
	private static String[] reorderLogFiles(String[] logs) {
		List<String> digitLogs = new ArrayList<>();
		List<String> textLogs = new ArrayList<>();

		for (String log : logs) {
			String[] arr = log.split("\\s+");
			char ch = arr[1].charAt(0);

			if (Character.isDigit(ch)) {
				digitLogs.add(log);
			} else {
				textLogs.add(log);
			}
		}

		Collections.sort(textLogs, new TextLogComparator());

		int i = 0;
		for (String log : textLogs) {
			logs[i++] = log;
		}

		for (String log : digitLogs) {
			logs[i++] = log;
		}

		return logs;
	}

	public static void main(String[] args) {
		String[] logs = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", 
				"let2 own kit dig", "let3 art zero" };
		
		logs = reorderLogFiles(logs);
		System.out.println(Arrays.toString(logs));
	}

}
