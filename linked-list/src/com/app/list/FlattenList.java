package com.app.list;

import java.util.Queue;
import java.util.LinkedList;

import com.app.list.LinkedList1.Node1;

class LinkedList1 {
	Node1 head;

	static class Node1 {
		int data;
		Node1 next;
		Node1 children;

		public Node1(int data) {
			this.data = data;
			this.next = null;
			this.children = null;
		}
	}
}

public class FlattenList {
	private static Node1 flattenGeeksForGeeks(Node1 head) {
		if(head == null)
			return head;
		Node1 curr = head;
		Node1 tail = curr;
		while(tail.next != null) {
			tail = tail.next;
		}
		
		while(curr != null) {
			if(curr.children != null) {
				tail.next = curr.children;
				Node1 tmp = curr.children;
				while(tmp.next != null) {
					tmp = tmp.next;
				}
				
				tail = tmp;
			}
			
			curr = curr.next;
		}
		return head;
	}
	
	private static void flatten(Node1 head) {
		Queue<Node1> q1 = new LinkedList<>();
		Node1 pNode = head;
		q1.add(pNode);
		while(!q1.isEmpty() || pNode != null) {
			if(!q1.isEmpty()) {
				pNode = q1.poll();
			}
			while (pNode != null) {
				System.out.print(pNode.data + "\t");
				if(pNode.children != null) {
					q1.add(pNode.children);
				} 
				pNode = pNode.next;
			}
		}
	}
	
	private static void display(Node1 head) {
		Node1 pNode = head;
		while(pNode != null) {
			System.out.print(pNode.data + "\t");
			pNode = pNode.next;
		}
	}

	public static void main(String[] args) {
		LinkedList1 list = new LinkedList1();
		list.head = new Node1(10);
		list.head.next = new Node1(5);
		list.head.next.next = new Node1(12);
		list.head.next.next.next = new Node1(7);
		list.head.next.next.next.next = new Node1(11);
		list.head.children = new Node1(4);
		list.head.children.next = new Node1(20);
		list.head.children.next.next = new Node1(13);
		list.head.next.next.next.children = new Node1(17);
		list.head.next.next.next.children.next = new Node1(6);
		list.head.children.next.children = new Node1(2);
		list.head.children.next.next.children = new Node1(16);
		list.head.next.next.next.children.children = new Node1(9);
		list.head.next.next.next.children.children.next = new Node1(8);
		list.head.children.next.next.children.children = new Node1(3);
		list.head.next.next.next.children.children.children = new Node1(19);
		list.head.next.next.next.children.children.children.next = new Node1(15);
		System.out.println("Flattening list method 1");
		flatten(list.head);
		
		System.out.println("\n\nFlattening list method 2");
		list.head = flattenGeeksForGeeks(list.head);
		display(list.head);
	}

}
