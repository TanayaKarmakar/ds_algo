package com.app.questions.linkedlist;

import com.app.questions.linkedlist.LinkedList1.Node;

public class MergeSortedList {
	private static Node mergeSortedList(Node head1, Node head2) {
		if(head1 == null && head2 == null)
			return null;
		if(head1 == null)
			return head2;
		if(head2 == null)
			return head1;
		Node dummy = new Node(Integer.MAX_VALUE);
		Node res = dummy;
		Node temp1 = head1;
		Node temp2 = head2;
		Node tmp3 = res;
		
		while(temp1 != null && temp2 != null) {
			Node curr;
			if(temp1.data <= temp2.data) {
				curr = temp1;
				temp1 = temp1.next;
				curr.next = null;
			} else {
				curr = temp2;
				temp2 = temp2.next;
				curr.next = null;
			}
			if(res == dummy) {
				res.next = curr;
				res = res.next;
				tmp3 = res;
			} else {
				tmp3.next = curr;
				tmp3 = tmp3.next;
			}
		}
		
		if(temp1 != null) {
			tmp3.next = temp1;
		}
		
		if(temp2 != null) {
			tmp3.next = temp2;
		}
		
		return res;
	}

	public static void main(String[] args) {
		LinkedList1 ll = new LinkedList1();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(4);
		
		LinkedList1 ll2 = new LinkedList1();
		ll2.insertAtEnd(1);
		ll2.insertAtEnd(3);
		ll2.insertAtEnd(4);
		
		Node res = mergeSortedList(ll.head, ll2.head);
		
		while(res != null) {
			System.out.print(res.data + " ");
			res = res.next;
		}
		
		System.out.println();
	}

}
