package com.app.practice;

import com.app.practice.LinkedList.ListNode;

public class IntersectionOfTwoLinkedListLeetcode160 {
	private static int length(ListNode l) {
		int len = 0;
		ListNode temp = l;
		while(temp != null) {
			temp = temp.next;
			len++;
		}
		return len;
	}
	
	private static ListNode intersection(ListNode headA, ListNode headB) {
		if(headA == null || headB == null)
			return null;
		if(headA == headB)
			return headA;
		int m = length(headA);
		int n = length(headB);
		
		if(m < n) {
			ListNode tmp = headA;
			headA = headB;
			headB = tmp;
			int tmpInt = m;
			m = n;
			n = tmpInt;
		}
		
		int diff = m - n;
		ListNode tmp1 = headA;
		ListNode tmp2 = headB;
		
		int i = 0;
		while(i < diff && tmp1 != null) {
			tmp1 = tmp1.next;
			i++;
		}
		
		while(tmp1 != null && tmp2 != null) {
			if(tmp1 == tmp2)
				return tmp1;
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;
		}
		return null;
	}

	public static void main(String[] args) {
		

	}

}
