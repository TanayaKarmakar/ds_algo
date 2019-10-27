package com.app.list;

import com.app.list.PointsList.Node;

class PointsList {
	Node head;

	static class Node {
		int x;
		int y;
		Node next;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
			this.next = null;
		}
	}
}

public class MiddlePointsRemoval {

	private static PointsList insert(PointsList list, int x, int y) {
		if (list.head == null) {
			list.head = new Node(x, y);
		} else {
			Node pNode = list.head;
			while (pNode.next != null) {
				pNode = pNode.next;
			}
			pNode.next = new Node(x, y);
		}
		return list;
	}

	private static Node deleteMiddleElement(Node head) {
		if (head == null || head.next == null || head.next.next == null)
			return head;
		Node next = head.next;
		Node nextNext = next.next;

		if (head.x == next.x) {
			while (nextNext != null && next.x == nextNext.x) {
				head.next = next.next;
				next.next = null;
				next = nextNext;
				nextNext = nextNext.next;
			}
		} else if (head.y == next.y) {
			while (nextNext != null && next.y == nextNext.y) {
				head.next = next.next;
				next.next = null;
				next = nextNext;
				nextNext = nextNext.next;
			}
		} else {
			System.out.println("Error");
		}
		
		Node temp = head;
		head = head.next;
		
		deleteMiddleElement(head);
		
		head = temp;
		return head;
	}
	
	private static void print(Node head) {
		Node pNode = head;
		while(pNode != null) {
			System.out.println("x - " + pNode.x + " : y - " + pNode.y);
			pNode = pNode.next;
		}
	}

	public static void main(String[] args) {
		PointsList list = new PointsList();
		list = insert(list, 0, 10);
		list = insert(list, 1, 10);
		list = insert(list, 5, 10);
		list = insert(list, 7, 10);
		list = insert(list, 7, 5);
		list = insert(list, 20, 5);
		list = insert(list, 40, 5);

		list.head = deleteMiddleElement(list.head);
		print(list.head);

	}

}
