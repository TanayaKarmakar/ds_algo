package com.app.questions.practice;

import java.util.PriorityQueue;

import com.app.questions.practice.LinkedList.ListNode;

class ListItem implements Comparable<ListItem> {
	int listPos;
	int valuePos;
	ListNode head;
	
	@Override
	public int compareTo(ListItem o) {
		return this.head.val - o.head.val;
	}	
}

public class MergeKSortedListLeetcode23 {
	public static ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0)
			return null;
		if(lists.length == 1) {
			return lists[0];
		}
        int k = lists.length;
        
        PriorityQueue<ListItem> pQ = new PriorityQueue<>();
        for(int i = 0; i < k; i++) {
        	if(lists[i] != null) {
        		ListItem item = new ListItem();
            	item.listPos = i;
            	item.valuePos = 0;
            	item.head = lists[i];
            	pQ.add(item);
        	}
        }
        
        if(pQ.isEmpty())
        	return null;
        
        ListNode head = new ListNode(Integer.MAX_VALUE);
        ListNode temp = head;
        
        while(!pQ.isEmpty()) {
        	ListItem item = pQ.poll();
        	int listPos = item.listPos;
        	int valuePos = item.valuePos;
        	ListNode node = item.head;
        	ListNode curr = node;
        	node = node.next;
        	curr.next = null;
        	temp.next = curr;
        	temp = temp.next;
        	if(node != null) {
        		ListItem newItem = new ListItem();
            	newItem.head = node;
            	newItem.listPos = listPos;
            	newItem.valuePos = valuePos + 1;
            	pQ.add(newItem);
        	}	
        }
        
        head = head.next;
        return head;
    }

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		node1.next = new ListNode(4);
		node1.next.next = new ListNode(5);
		
		ListNode node2 = new ListNode(1);
		node2.next = new ListNode(3);
		node2.next.next = new ListNode(4);
		
		ListNode node3 = new ListNode(2);
		node3.next = new ListNode(6);
		
		ListNode[] nodes = new ListNode[3];
		nodes[0] = node1;
		nodes[1] = node2;
		nodes[2] = node3;
		
		ListNode head = mergeKLists(nodes);
		
		ListNode temp = head;
		
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		

	}

}
