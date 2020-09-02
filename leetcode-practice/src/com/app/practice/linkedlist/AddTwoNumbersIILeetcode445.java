package com.app.practice.linkedlist;

import java.util.Stack;

import com.app.practice.LinkedList.ListNode;

public class AddTwoNumbersIILeetcode445 {
	private static int length(ListNode l1) {
		int len = 0;
		ListNode tmp = l1;
		while(tmp != null) {
			tmp = tmp.next;
			len++;
		}
		return len;
	}
	
	private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		
		int m = length(l1);
		int n = length(l2);
		
		if(m < n) {
			ListNode tmp = l1;
			l1 = l2;
			l2 = tmp;
			
			int tmpLen = m;
			m = n;
			n = tmpLen;
		}
		
		
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		
		ListNode tmp1 = l1;
		ListNode tmp2 = l2;
		
		int diff = (m - n);
		while(diff > 0) {
			stack1.push(tmp1.val);
			stack2.push(0);
			tmp1 = tmp1.next;
			diff--;
		}
		
		while(tmp1 != null && tmp2 != null) {
			stack1.push(tmp1.val);
			stack2.push(tmp2.val);
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;
		}
		
		
		int carry = 0;
		ListNode res = null;
		while(!stack1.isEmpty() && !stack2.isEmpty()) {
			int num1 = stack1.pop();
			int num2 = stack2.pop();
			
			int sum = num1 + num2;
			if(carry > 0) {
				sum += carry;
			}
			
			if(sum > 9) {
				carry = sum / 10;
				sum %= 10;
			} else {
				carry = 0;
			}
			
			ListNode node = new ListNode(sum);
			node.next = res;
			res = node;
		}
		
		if(carry > 0) {
			ListNode node = new ListNode(carry);
			node.next = res;
			res = node;
		}
		
		return res;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode res = addTwoNumbers(l1, l2);
		
		ListNode tmp = res;
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
		
		System.out.println();
		

	}

}
