package com.app.questions.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class TextJustificationLeetcode68 {
	private static String formString(List<String> words, int maxWidth, boolean isLast) {
		int totalLen = 0;
		for (String word : words) {
			totalLen += word.length();
		}

		int remaining = maxWidth - totalLen;
		if (words.size() == 1) {
			StringBuilder sb = new StringBuilder();
			sb.append(words.get(0));
			while (remaining > 0) {
				sb.append(" ");
				remaining--;
			}
			return sb.toString();
		}
		Queue<String> q = new LinkedList<>();
		for (int i = 0; i < words.size() - 1; i++) {
			q.add(words.get(i));
		}
		StringBuilder sb = new StringBuilder();
		if (!isLast) {
			q.add(null);
			while (remaining > 0) {
				String item = q.poll();
				if (item == null) {
					q.add(null);
					continue;
				}
				q.add(item + " ");
				remaining--;
			}

			while (q.peek() != null) {
				q.add(q.poll());
			}
			q.poll();
			while (!q.isEmpty()) {
				sb.append(q.poll());
			}
			sb.append(words.get(words.size() - 1));
		} else {
			while (!q.isEmpty() && remaining > 0) {
				sb.append(q.poll() + " ");
				remaining--;
			}
			sb.append(words.get(words.size() - 1));
			while (remaining > 0) {
				sb.append(" ");
				remaining--;
			}
		}
		return sb.toString();
	}

	private static List<String> fullJustify(String[] words, int maxWidth) {
		List<List<String>> intermediate = new ArrayList<>();
		int n = words.length;

		int i = 0;
		while (i < n) {
			int len = maxWidth;
			List<String> wordList = new ArrayList<>();
			while (i < n && len >= 0) {
				if (words[i].length() <= len) {
					wordList.add(words[i]);
					len = len - words[i].length() - 1;
					i++;
				} else {
					break;
				}
			}
			intermediate.add(wordList);
		}

		System.out.println(intermediate);

		List<String> finalList = new ArrayList<>();
		int m = intermediate.size();
		for (i = 0; i < m - 1; i++) {
			List<String> wordList = intermediate.get(i);
			finalList.add(formString(wordList, maxWidth, false));
		}
		finalList.add(formString(intermediate.get(m - 1), maxWidth, true));
		return finalList;
	}

	public static void main(String[] args) {
		String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
		int maxWidth = 16;

		List<String> output = fullJustify(words, maxWidth);

		System.out.println(output);

		words = new String[] { "What", "must", "be", "acknowledgment", "shall", "be" };
		output = fullJustify(words, maxWidth);

		System.out.println(output);

		words = new String[] { "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to",
				"a", "computer.", "Art", "is", "everything", "else", "we", "do" };

		maxWidth = 20;
		output = fullJustify(words, maxWidth);

		System.out.println(output);
	}

}
