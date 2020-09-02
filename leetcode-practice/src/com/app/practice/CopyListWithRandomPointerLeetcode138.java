package com.app.practice;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointerLeetcode138 {
	private static Node copyRandomList(Node head) {
		//copy the next node
		Node curr = head;
		while(curr != null) {
			Node newNode = new Node(curr.val);
			newNode.next = curr.next;
			curr.next = newNode;
			curr = curr.next.next;
		}
		
		//copy the random pointer
		curr = head;
		while(curr != null) {
			if(curr.random != null) {
				curr.next.random = (curr.random.next != null) ? curr.random.next: null;
			}
			
			curr = curr.next.next;
		}
		
		//delete the actual nodes, keep the newly created clones
		head = head.next;
		curr = head;
		while(curr != null) {
			if(curr.next != null) {
				curr.next = curr.next.next;
			} else {
				break;
			}
			curr = curr.next;
		}
		return head;
	}

	public static void main(String[] args) {
		Node node7 = new Node(7);
		Node node13 = new Node(13);
		Node node11 = new Node(11);
		Node node10 = new Node(10);
		Node node1 = new Node(1);
		
		
		node7.next = node13;
		node13.next = node11;
		node11.next = node10;
		node10.next = node1;
		
		node7.random = null;
		node13.random = node7;
		node10.random = node11;
		node11.random = node1;
		
		
		node7 = copyRandomList(node7);
		/*Node node10 = new Node(10);
		Node node5 = new Node(5);
		Node node20 = new Node(20);
		Node node15 = new Node(15);
		Node node20_1 = new Node(20);
		
		
		node10.next = node5;
		node5.next = node20;
		node20.next = node15;
		node15.next = node20_1;
		
		node10.random = node20;
		node20.random = node10;
		node5.random = node15;
		node15.random = node20;
		node20_1.random = node15;
		
		node10 = copyRandomList(node10);
		
		Node tmp = node10;
		while(tmp != null) {
			System.out.print("Current Node - " + tmp.val);
			if(tmp.next != null) {
				System.out.print(": Next Node - " + tmp.next.val);
			} else {
				System.out.print(": Next Node - " + null);
			}
			if(tmp.random != null) {
				System.out.print(": Random Node - " + tmp.random.val);
			} else {
				System.out.print(": Random Node - " + null);
			}
			System.out.println();
			tmp = tmp.next;
		}*/

	}

}
