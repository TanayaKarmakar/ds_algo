package com.app.practice.heap;

import java.util.PriorityQueue;

import com.app.practice.LinkedList.ListNode;

class VNode implements Comparable<VNode> {
	ListNode node;
	int aPos;
	int vPos;

	public VNode(ListNode node, int aPos, int vPos) {
		this.node = node;
		this.aPos = aPos;
		this.vPos = vPos;
	}

	@Override
	public int compareTo(VNode o) {
		return this.node.val - o.node.val;
	}
}

public class MergeKSortedListLeetcode23 {
	private static ListNode mergeKLists(ListNode[] lists) {
		ListNode result = new ListNode(Integer.MIN_VALUE);
		ListNode tmp = result;

		PriorityQueue<VNode> pQ = new PriorityQueue<>();
		for (int i = 0; i < lists.length; i++) {
			if(lists[i] != null)
				pQ.add(new VNode(lists[i], i, 0));
		}

		while (!pQ.isEmpty()) {
			VNode vNode = pQ.poll();
			ListNode node = vNode.node;
			int aPos = vNode.aPos;
			int vPos = vNode.vPos;

			vNode.node = vNode.node.next;
			node.next = null;
			tmp.next = node;
			tmp = tmp.next;

			if (vNode.node != null)
				pQ.add(new VNode(vNode.node, aPos, vPos + 1));

		}

		result = result.next;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
