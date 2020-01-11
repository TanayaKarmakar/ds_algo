package com.app.linkedlist.practice;

import com.app.linkedlist.classroom.LinkedList;
import com.app.linkedlist.classroom.LinkedList.Node;

public class AddTwoNumbers {
	private static Node reverseList(Node head) {
		if(head == null || head.next == null)
			return head;
		Node prev = head;
		Node curr = prev.next;

		Node next = curr.next;

		while (curr != null) {
			curr.next = prev;
			if(prev == head) {
				prev.next = null;
			}
			prev = curr;
			curr = next;
			if(curr != null) {
				next = curr.next;
			}
				
		}

		head = prev;

		return head;
	}

	private static Node addTwoNumbers(Node head1, Node head2) {
		head1 = reverseList(head1);
		head2 = reverseList(head2);

		int carry = 0;
		Node res = null;
		Node tmp = null;
		while (head1 != null && head2 != null) {
			int val = head1.data + head2.data;
			if (carry > 0) {
				val += carry;
			}
			if (val > 9) {
				carry = val / 10;
				val = val % 10;
			} else {
				carry = 0;
			}
			if (res == null) {
				res = new Node(val);
				tmp = res;
			} else {
				tmp.next = new Node(val);
				tmp = tmp.next;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		
		int val = 0;
		
		while(head1!= null) {
		    val = head1.data;
			if(carry > 0) {
				val += carry;
			}
			if (val > 9) {
				carry = val / 10;
				val = val % 10;
			} else {
				carry = 0;
			}
			tmp.next = new Node(val);
			tmp = tmp.next;
			head1 = head1.next;
		}
		
		while(head2!= null) {
		    val = head2.data;
			if(carry > 0) {
				val += carry;
			}
			if (val > 9) {
				carry = val / 10;
				val = val % 10;
			} else {
				carry = 0;
			}
			tmp.next = new Node(val);
			tmp = tmp.next;
			head2 = head2.next;
		}
		
		if(carry > 0) {
		    tmp.next = new Node(carry);
		    tmp = tmp.next;
		}
		
		return res;
		
		//return res;

	}

	public static void main(String[] args) {
		LinkedList ll1 = new LinkedList();
		ll1.insertAtEnd(3);
		ll1.insertAtEnd(4);
		ll1.insertAtEnd(5);
		
		LinkedList ll2 = new LinkedList();
		ll2.insertAtEnd(4);
		ll2.insertAtEnd(5);
		
		Node res = addTwoNumbers(ll1.head, ll2.head);
		
		Node tmp = res;
		while(tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		
		System.out.println();
		
		ll1 = new LinkedList();
		ll1.insertAtEnd(6);
		ll1.insertAtEnd(3);
		
		ll2 = new LinkedList();
		ll2.insertAtEnd(7);
		
		res = addTwoNumbers(ll1.head, ll2.head);
		
		tmp = res;
		while(tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}

	}

}
