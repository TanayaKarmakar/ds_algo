package com.app.practice.strings;

import java.util.HashSet;
import java.util.Set;

public class ValidateIPAddressLeetcode468 {
	private static boolean isNumber(String str) {
		try {
			int el = Integer.parseInt(str);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	private static boolean isIPv4(String IP) {
		if (IP.contains(".") && IP.lastIndexOf('.') == IP.length() - 1)
			return false;

		String[] strs = IP.split("\\.");

		if (strs.length != 4)
			return false;

		for (String str : strs) {
			if (!isNumber(str) || (str.length() > 1 && str.charAt(0) == '0'))
				return false;
			int num = Integer.parseInt(str);
			if (num < 0 || num > 255)
				return false;
		}
		return true;
	}

	private static boolean isIPv6(String IP) {
		if (IP.contains(":") && IP.lastIndexOf(':') == IP.length() - 1)
			return false;
		String[] strs = IP.split(":");
		if (strs.length != 8)
			return false;
		Set<Character> charSet = new HashSet<>();

		for (char i = '0'; i <= '9'; i++) {
			charSet.add(i);
		}

		for (int i = 65; i <= 70; i++) {
			charSet.add((char)i);
		}
		
		for(int i = 97; i <= 102; i++) {
			charSet.add((char)i);
		}
		
		
		for(String str: strs) {
			if(str.length() < 1 || str.length() > 4)
				return false;
			for(int i = 0; i < str.length(); i++) {
				if(!charSet.contains(str.charAt(i)))
					return false;
			}
		}

		return true;
	}

	private static String validIPAddress(String IP) {
		if (IP.length() == 0)
			return "Neither";
		else if (isIPv4(IP))
			return "IPv4";
		else if (isIPv6(IP))
			return "IPv6";
		return "Neither";
	}

	public static void main(String[] args) {
		String str = "12..33.4";

		System.out.println(validIPAddress(str));

//		String str = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
//
//		System.out.println(validIPAddress(str));
	}

}
