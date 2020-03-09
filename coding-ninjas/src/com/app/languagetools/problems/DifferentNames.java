package com.app.languagetools.problems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class DifferentNames {
	private static void printOccurences(String[] names) {
		Map<String, Integer> freqMap = new LinkedHashMap<>();
		for(String str: names) {
			if(!freqMap.containsKey(str)){
				freqMap.put(str, 1);
			} else {
				int tmp = freqMap.get(str);
				freqMap.put(str, ++tmp);
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String, Integer> entry: freqMap.entrySet()) {
			if(entry.getValue() > 1) {
				sb.append(entry.getKey() + " " + entry.getValue() + "\n");
			}
		}
		
		if(sb.toString().isEmpty()) {
			System.out.println("-1");
		} else {
			System.out.println(sb.toString());
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputStr = scanner.nextLine();
		printOccurences(inputStr.split("\\s+"));
		scanner.close();

	}

}
