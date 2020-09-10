package com.app.companywise.uber;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ValidateIPAddress {
	private static boolean isNumber(String s) {
		try {
			int n = Integer.parseInt(s);
			return true;
		} catch(NumberFormatException nfe) {
			return false;
		}
	}
	
	private static boolean isIPv4(String ip) {
		if(ip.indexOf('.') == -1 || ip.lastIndexOf('.') == ip.length() - 1)
			return false;
		String[] arr = ip.split("\\.");
		if(arr.length != 4)
			return false;
		for(String el: arr) {
			if(!isNumber(el) || (el.length() > 1 && el.charAt(0) == '0'))
				return false;
			int num = Integer.parseInt(el);
			if(num < 0 || num > 255)
				return false;
		}
		return true;
	}
	
	private static boolean isIPv6(String ip) {
		if(ip.indexOf(":") == -1 || ip.lastIndexOf(":") == ip.length() - 1)
			return false;
		String[] arr = ip.split(":");
		if(arr.length != 8)
			return false;
		Set<Character> charSet = new HashSet<>();
		for(char i = '1'; i <= '9'; i++) {
			charSet.add(i);
		}
		
		for(int i = 65; i <= 70; i++) {
			charSet.add((char)i);
		}
		
		for(int i = 97; i <= 102; i++) {
			charSet.add((char)i);
		}
		
		charSet.add('0');
		
		for(String el: arr) {
			if(el.length() < 1 || el.length() > 4)
				return false;
			for(int i = 0; i < el.length(); i++) {
				if(!charSet.contains(el.charAt(i)))
					return false;
			}
		}
		return true;
	}
	
	private static String validIPAddress(String IP) {
		if(IP.length() == 0)
			return "Neither";
		if(isIPv4(IP))
			return "IPv4";
		else if(isIPv6(IP))
			return "IPv6";
		else
			return "Neither";
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String text = scanner.next();
		
		System.out.println(validIPAddress(text));
		
		scanner.close();

	}

}
