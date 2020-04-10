package com.app.questions;

import com.app.questions.LinkedList.Node;

public class PalindromeLinkedList234 {
	private static Node getMiddleNode(Node head) {
		Node fast = head;
		Node slow = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;	
	}
	
	private static Node reverse(Node head) {
		if(head == null || head.next == null)
			return head;
		Node curr = head;
		Node next = curr.next;
		Node nextNext = null;
		
		while(next != null) {
			nextNext = next.next;
			next.next = curr;
			if(curr == head) {
				curr.next = null;
			}
			curr = next;
			next = nextNext;	
		}
		
		head = curr;
		return head;
	}

	private static boolean isPalindrome(Node head) {
		if(head == null)
			return false;
		if(head.next == null)
			return true;
		Node middle = getMiddleNode(head);
		Node midNext = middle.next;
		middle.next = null;
		
		midNext = reverse(midNext);
		Node temp1 = head;
		Node temp2 = midNext;
		
		while(temp1 != null && temp2 != null) {
			if(temp1.data != temp2.data)
				return false;
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		
		int l = 0;
		while(temp1 != null) {
			l++;
			temp1 = temp1.next;
		}
		
		return l <= 1;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.head = new Node(1);
		ll.head.next = new Node(2);
		
		System.out.println(isPalindrome(ll.head));
		
		ll = new LinkedList();
		ll.head = new Node(1);
		ll.head.next = new Node(2);
		ll.head.next.next = new Node(2);
		ll.head.next.next.next = new Node(1);
		
		System.out.println(isPalindrome(ll.head));

	}

}
