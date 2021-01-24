package com.app.practice.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class LetterLog implements Comparable<LetterLog> {
	String id;
	String text;

	public LetterLog(String id, String text) {
		this.id = id;
		this.text = text;
	}

	@Override
	public int compareTo(LetterLog o) {
		if(this.text.compareTo(o.text) == 0)
			return this.id.compareTo(o.id);
		return this.text.compareTo(o.text);
	}
}

public class ReorderDataInLogsFileLeetcode937 {
	private static boolean isDigit(String log) {
		char ch = log.split("\\s+")[1].charAt(0);
		return Character.isDigit(ch);
	}

	private static String[] reorderLogFiles(String[] logs) {
		List<LetterLog> letterLogs = new ArrayList<>();
		List<String> digitLogs = new ArrayList<>();

		for (String log : logs) {
			if (isDigit(log)) {
				digitLogs.add(log);
			} else {
				int spaceIndx = log.indexOf(' ');
				String id = log.substring(0, spaceIndx);
				String text = log.substring(spaceIndx + 1);
				letterLogs.add(new LetterLog(id, text));
			}
		}

		Collections.sort(letterLogs);

		String[] output = new String[logs.length];

		int i = 0;
		for (LetterLog letterLog : letterLogs) {
			output[i++] = letterLog.id + " " + letterLog.text;
		}

		for (String digitLog : digitLogs) {
			output[i++] = digitLog;
		}

		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
