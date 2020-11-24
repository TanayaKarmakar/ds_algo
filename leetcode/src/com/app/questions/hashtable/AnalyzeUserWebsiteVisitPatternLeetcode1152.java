package com.app.questions.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class SiteItem implements Comparable<SiteItem> {
	String url;
	int timestamp;
	
	public SiteItem(String url, int timestamp) {
		this.url = url;
		this.timestamp = timestamp;
	}

	@Override
	public int compareTo(SiteItem o) {
		return this.timestamp - o.timestamp;
	}
}

public class AnalyzeUserWebsiteVisitPatternLeetcode1152 {
	private static void getAllThreeLenSeq(List<SiteItem> websites, TreeMap<String, Integer> visitCountMap) {
		int n = websites.size();
		getAllThreeLenSeq(websites, "", 0, n, visitCountMap, 3);
	}

	private static void getAllThreeLenSeq(List<SiteItem> websites, String prefix, int start, int len,
			TreeMap<String, Integer> visitCountMap, int lenCount) {
		if (lenCount == 0) {
			visitCountMap.put(prefix, visitCountMap.getOrDefault(prefix, 1) + 1);
			return;
		}

		for (int i = start; i < len; i++) {
			String newPrefix = "";
			if (prefix.equals(""))
				newPrefix = prefix + websites.get(i).url;
			else
				newPrefix = prefix + "-" + websites.get(i).url;
			getAllThreeLenSeq(websites, newPrefix, i + 1, len, visitCountMap, lenCount - 1);
		}
	}

	private static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
		Map<String, List<SiteItem>> visitMap = new HashMap<>();

		int n = username.length;

		for (int i = 0; i < n; i++) {
			if (!visitMap.containsKey(username[i]))
				visitMap.put(username[i], new ArrayList<>());
			SiteItem sItem = new SiteItem(website[i], timestamp[i]);
			visitMap.get(username[i]).add(sItem);
		}

		TreeMap<String, Integer> visitCountMap = new TreeMap<>();
		for (Map.Entry<String, List<SiteItem>> entry : visitMap.entrySet()) {
			Collections.sort(entry.getValue());
			if (entry.getValue().size() == 3) {
				
				String str = entry.getValue().get(0).url + "-" + entry.getValue().get(1).url + "-" + entry.getValue().get(2).url;

				visitCountMap.put(str, visitCountMap.getOrDefault(str, 1) + 1);
			} else {
				if (entry.getValue().size() > 3)
					getAllThreeLenSeq(entry.getValue(), visitCountMap);
			}
		}
		
		System.out.println(visitCountMap);

		String maxVisitedSite = "";
		int maxVisitCount = 0;
		for(Map.Entry<String, Integer> entry: visitCountMap.entrySet()) {
			if(entry.getValue() > maxVisitCount) {
				maxVisitedSite = entry.getKey();
				maxVisitCount = entry.getValue();
			} else if(maxVisitCount == entry.getValue()) {
				if(entry.getKey().compareTo(maxVisitedSite) < 0) {
					maxVisitedSite = entry.getKey();
				}
			}
		}
		
		return Arrays.asList(maxVisitedSite.split("-"));
	}

	public static void main(String[] args) {
		String[] username = { "joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary" };
		int[] timestamp = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		String[] website = { "home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career" };
	
		List<String> result = mostVisitedPattern(username, timestamp, website);
		
		System.out.println(result);
	}

}
