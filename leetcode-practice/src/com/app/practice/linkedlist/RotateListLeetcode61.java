package com.app.practice.linkedlist;



import com.app.practice.LinkedList;
import com.app.practice.LinkedList.ListNode;

public class RotateListLeetcode61 {
	private static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

	private static int len(ListNode head) {
		ListNode temp = head;
		int len = 0;
		while (temp != null) {
			len++;
			temp = temp.next;
		}

		return len;
	}

	private static ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;
		
		int n = len(head);
		if(k > n)
			k = k % n;
		if(k == 0)
			return head;
		head = reverseList(head);

		ListNode temp = head;

		while (k > 1) {
			temp = temp.next;
			k--;
		}

		ListNode part1 = head;
		ListNode part2 = temp.next;
		temp.next = null;

		part1 = reverseList(head);
		part2 = reverseList(part2);

		temp = part1;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = part2;
		head = part1;

		return head;
	}
	
	private static void display(ListNode head) {
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new ListNode(1);
		ll.head.next = new ListNode(2);
		ll.head.next.next = new ListNode(3);
		ll.head.next.next.next = new ListNode(4);
		ll.head.next.next.next.next = new ListNode(5);
		
		ll.head = rotateRight(ll.head, 10);
		
		display(ll.head);
	}

}
