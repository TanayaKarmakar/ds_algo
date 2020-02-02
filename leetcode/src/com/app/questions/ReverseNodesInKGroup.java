package com.app.questions;

import com.app.questions.LinkedList.Node;

class NodePair {
	Node start;
	Node end;
	
	public NodePair(Node start, Node end) {
		this.start = start;
		this.end = end;
	}
}

public class ReverseNodesInKGroup {
	private static int length(Node head) {
		Node tmp = head;
		int cnt = 0;
		while(tmp != null) {
			cnt++;
			tmp = tmp.next;
		}
		return cnt;
	}
	
	private static int isReversible(Node head, int k) {
		if(head == null || k <= 1 || (head.next == null && k > 1))
			return -1;
		int len = length(head);
		if(len < k)
			return -1;
		return len;	
	}
	
	private static NodePair reverseList(Node head) {
		Node prev = head;
		Node curr = prev.next;
		Node next = curr.next;
		Node last = null;
		while(curr != null && curr.next != null) {
			curr.next = prev;
			if(prev == head) {
				last = head;
				prev.next = null;
			}
			prev = curr;
			curr = next;
			next = curr.next;
		}
		if(last == null) {
			last = prev;
			last.next = null;
		}
			
		curr.next = prev;
		prev = curr;
		head = prev;
		return new NodePair(head, last);
	}
	
	private static Node reverseNodeInKGroup(Node head, int k) {
		int reversible = isReversible(head, k);
		if(reversible == -1)
			return head;
		NodePair p = null;
		if(reversible == k) {
			p = reverseList(head);
			return p.start;
		}
		
		Node tmp = head;
		Node start = head;
		Node end = start;
		Node prevEnd = null;
		while(tmp != null) {
			start = tmp;
			end = start;
			int j = k - 1;
			while(j > 0 && end.next != null) {
				end = end.next;
				j--;
			}
			if(end.next!= null) {
				tmp = end.next;
				end.next = null;
				p = reverseList(start);
				if(start == head)
					head = p.start;
				if(prevEnd != null)
					prevEnd.next = p.start;
				p.end.next = tmp;
				prevEnd = p.end;
			} else {
				tmp = null;
				if(j > 0) {
					return head;
				} else {
					p = reverseList(start);
					prevEnd.next = p.start;
				}
			}
		}
		return head;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
				
		/*ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		
		ll.head = reverseList(ll.head);
		ll.display();
		
		ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		
		ll.head = reverseList(ll.head);
		ll.display();
		
		ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		
		ll.head = reverseList(ll.head);
		ll.display();*/
		
		
		ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);
		ll.insertAtEnd(6);
		
		ll.display();
		
		ll.head = reverseNodeInKGroup(ll.head, 4);
		//reverseNodeInKGroup(ll.head, 3);
		ll.display();

	}

}
