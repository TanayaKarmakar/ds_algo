package com.app.questions.linkedlist;

class Node {
	public int val;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _next) {
		val = _val;
		next = _next;
	}
};

public class InsertIntoSortedCircularLinkedListLeetcode708 {
	private static boolean canInsert(Node curr, int insertVal) {
		if(curr.val <= insertVal && curr.next.val > insertVal)
			return true;
		if(curr.val <= insertVal && curr.val > curr.next.val)
			return true;
		if(curr.val > insertVal && curr.next.val > insertVal && curr.val > curr.next.val)
			return true;
		return false;
	}
	
	private static void insertNode(Node curr, int insertVal) {
		Node temp = curr.next;
		curr.next = new Node(insertVal, temp);
	}
	
	private static Node insert(Node head, int insertVal) {
		if(head == null) {
			head = new Node(insertVal);
			head.next = head;
			return head;
		}
		
		if(head.next == head) {
			Node newNode = new Node(insertVal);
			newNode.next = head;
			head.next = newNode;
			return head;
		}
		
		Node curr = head;
		while(true) {
			if(canInsert(curr, insertVal)) {
				insertNode(curr, insertVal);
				return head;
			}
			if(curr.next == head) {
				insertNode(curr, insertVal);
				return head;
			}
			curr = curr.next;
		}
	}

	private static void display(Node head) {
		Node tmp = head;
		boolean reachedEnd = false;
		while (!reachedEnd) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
			if(tmp == head)
				reachedEnd = true;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(3);
		head.next = new Node(4);
		head.next.next = new Node(1);
		head.next.next.next = head;

		head = insert(head, 2);

		display(head);

	}

}
