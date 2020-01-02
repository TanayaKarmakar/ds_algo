package com.app.linkedlist.classroom;

import com.app.linkedlist.classroom.LinkedList.Node;

public class PairWiseSwap {
	private static Node pairWiseSwapExchangingLinks(Node head) {
		Node prev = head;
		Node curr = head.next;
		head = curr;
		
		while(true) {
			Node next = curr.next;
			curr.next = prev;
			if(next == null || next.next == null) {
				prev.next = next;
				break;
			}
			
			prev.next = next.next;
			prev = next;
			curr = prev.next;
		}
		return head;
	}
	private static void pairWiseSwap(Node head) {
		if(head == null || head.next == null)
			return;
		
		Node first = head;
		Node second = first.next;
		
		while(first != null && second != null) {
			int tmp = first.data;
			first.data = second.data;
			second.data = tmp;
			
			first = second.next;
			if(first == null)
				break;
			second = first.next;
		}
	}
	
	private static void displayList(Node head) {
		Node tmp = head;
		while(tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);
		
		pairWiseSwap(ll.head);
		displayList(ll.head);
		
		ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);
		ll.insertAtEnd(6);
		
		pairWiseSwap(ll.head);
		displayList(ll.head);
		
		//by exchanging links
		ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);
		
		System.out.println("Pair Wise swap by exchanging links");
		ll.head = pairWiseSwapExchangingLinks(ll.head);
		displayList(ll.head);
		
		ll = new LinkedList();
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);
		ll.insertAtEnd(6);
		
		System.out.println("Pair Wise swap by exchanging links");
		ll.head = pairWiseSwapExchangingLinks(ll.head);
		displayList(ll.head);
		
	}

}
