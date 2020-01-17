package com.app.linkedlist.practice;

import com.app.linkedlist.classroom.LinkedList;
import com.app.linkedlist.classroom.LinkedList.Node;

public class Sort012 {
	private static Node sortNode(Node head) {
		if(head == null || head.next == null)
			return head;
		Node tmp = head;
		Node dummy = new Node(3);
		Node zeroPtr = dummy;
		Node onePtr = dummy;
		Node twoPtr = dummy;
		Node tmpZeroPtr = zeroPtr;
		Node tmpOnePtr = onePtr;
		Node tmpTwoPtr = twoPtr;

		while (tmp != null) {
			
			switch (tmp.data) {
			case 0:
				if (zeroPtr == dummy) {
					zeroPtr = new Node(0);
					tmpZeroPtr = zeroPtr;
				} else {
					tmpZeroPtr.next = new Node(0);
					tmpZeroPtr = tmpZeroPtr.next;
				}
				break;
			case 1:
				if (onePtr == dummy) {
					onePtr = new Node(1);
					tmpOnePtr = onePtr;
				} else {
					tmpOnePtr.next = new Node(1);
					tmpOnePtr = tmpOnePtr.next;
				}
				break;
			case 2:
				if (twoPtr == dummy) {
					twoPtr = new Node(2);
					tmpTwoPtr = twoPtr;
				} else {
					tmpTwoPtr.next = new Node(2);
					tmpTwoPtr = tmpTwoPtr.next;
				}
				break;
			}
			tmp = tmp.next;
		}
		
		
		if(zeroPtr != dummy && onePtr != dummy && twoPtr != dummy) {
			tmpZeroPtr.next = onePtr;
			tmpOnePtr.next = twoPtr;
		} else {
			if(zeroPtr == dummy) {
				if(onePtr == dummy) {
					zeroPtr = twoPtr;
				} else {
					zeroPtr = onePtr;
					if(twoPtr != dummy) {
						tmpOnePtr.next = twoPtr;
					}
				}
			} else if(onePtr == dummy) {
				if(twoPtr != dummy) {
					tmpZeroPtr.next = twoPtr;
				}
			} else {
			    tmpZeroPtr.next = onePtr;
			}
		}
		
		return zeroPtr;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(2);
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(0);
		ll.insertAtEnd(2);
		ll.insertAtEnd(2);

		Node head1 = sortNode(ll.head);
		Node tmp = head1;

		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}
}
