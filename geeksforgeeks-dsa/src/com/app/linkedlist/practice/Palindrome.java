package com.app.linkedlist.practice;

import com.app.linkedlist.classroom.LinkedList;
import com.app.linkedlist.classroom.LinkedList.Node;

public class Palindrome {
	private static Node reverseList(Node node) {
		Node prev = node;
		Node curr = prev.next;
		
		while(curr != null) {
			Node next = curr.next;
			
			curr.next = prev;
			
			if(prev == node)
				prev.next = null;
			
			prev = curr;
			curr = next;
		}
		
		node = prev;
		return node;
	}
	
	private static boolean isPalindrome(Node head) {
		if(head == null)
			return false;
		if(head.next == null || (head.data == head.next.data && head.next.next == null))
			return true;
		Node slow = head;
		Node fast = head;
		Node prev = slow;
		Node prevStart = slow;
		
		while(fast != null && fast.next != null) {
			prev = slow;
			fast = fast.next.next;
			slow = slow.next;
		}
		
		Node prevNext = prev.next;
		prev.next = null;
		
		prevStart = reverseList(prevStart);
		
		Node targetStart = null;
		if(fast == null) {
			targetStart = slow;
		}
		else if(fast.next == null) {
			targetStart = slow.next;
		}
		
		if(targetStart != null) {
			Node temp1 = targetStart;
			Node temp2 = prevStart;
			
			while(temp1 != null && temp2 != null) {
				if(temp1.data != temp2.data)
					return false;
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
			return true;
		}
		return false;
		
	}

	public static void main(String[] args) {
//		LinkedList ll = new LinkedList();
//		ll.insertAtEnd(1);
//		ll.insertAtEnd(2);
//		ll.insertAtEnd(1);
//		
//		System.out.println("Is Palindrome - " + isPalindrome(ll.head));
//		
//		ll = new LinkedList();
//		ll.insertAtEnd(1);
//		ll.insertAtEnd(2);
//		ll.insertAtEnd(3);
//		ll.insertAtEnd(4);
//		
//		System.out.println("Is Palindrome - " + isPalindrome(ll.head));
		
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(5);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(1);
		ll.insertAtEnd(4);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);
		ll.insertAtEnd(3);
		ll.insertAtEnd(3);
		ll.insertAtEnd(5);
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(5);
		ll.insertAtEnd(5);
		ll.insertAtEnd(1);
		ll.insertAtEnd(4);
		ll.insertAtEnd(2);
		ll.insertAtEnd(4);
		ll.insertAtEnd(2);
		ll.insertAtEnd(2);
		ll.insertAtEnd(1);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);
		
		System.out.println("Is Palindrome - " + isPalindrome(ll.head));

	}

}
