package com.app.questions;

import java.util.Stack;

import com.app.questions.LinkedList.Node;

/**
 * 
 * @author tkarmaka
 * class Solution {
    int carry = 0;
    boolean d = false;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n = 0, m = 0;
        ListNode container = new ListNode(-1);
        ListNode x1 = l1, x2 = l2;
        ListNode result = container;
        while(l1 !=  null){
            n++;
            l1 = l1.next;
        }
        while(l2 !=  null){
            m++;
            l2 = l2.next;
        }
        boolean which = n >= m ? true : false;
        int diff = which ? n - m : m - n;
        ListNode helper = new ListNode(0);
        ListNode ptr = helper;
        while(diff > 0){
            helper.next = new ListNode(0);
            helper = helper.next;
            diff--;
        }
        if(which){
            helper.next = x2;
            addition(x1, ptr.next, container);
        }
        else{
            helper.next = x1;
            addition(ptr.next, x2, container);
        }
        if(d){
            result.val = carry;
            return result;
        }
        return  result.next;
    }
    
    private void addition(ListNode l1, ListNode l2, ListNode container){
        if(l1 == null && l2 == null){
            
            return;
        } 
        container.next = new ListNode(0);
        container = container.next;
        addition(l1.next, l2.next, container);
        int x = l1.val + l2.val + carry;
        carry = x/10;
        d = x > 9 ? true : false;
        container.val = (x%10);
    }
}
 *
 */

public class AddNumbers {
	private static Node addTwoNumbers(Node l1, Node l2) {
		if(l1 == null && l2 == null)
			return null;
		if(l2 == null)
			return l1;
		if(l1 == null)
			return l2;
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		Node p1 = l1;
		while(p1 != null) {
			stack1.push(p1.data);
			p1 = p1.next;
		}
		
		p1 = l2;
		while(p1 != null) {
			stack2.push(p1.data);
			p1 = p1.next;
		}
		
		Node res = null;
		Node tmp = null;
		int carry = 0;
		while(!stack1.isEmpty() && !stack2.isEmpty()) {
			int num1 = stack1.pop();
			int num2 = stack2.pop();
			int sum = num1 + num2;
			if(carry > 0) {
				sum += carry;
				carry = 0;
			} 
			if(sum > 9) {
				carry = sum/10;
				sum = sum % 10;
			} 
			if(res == null) {
				res = new Node(sum);
				tmp = res;
			} else {
				res = new Node(sum);
				res.next = tmp;
				tmp = res;
			}
		}
		
		while(!stack1.isEmpty()) {
			int sum = stack1.pop();
			if(carry > 0) {
				sum += carry;
				carry = 0;
			}
			if(sum > 9) {
				carry = sum / 10;
				sum = sum % 10;
			}
			res = new Node(sum);
			res.next = tmp;
			tmp = res;
		}
		
		while(!stack2.isEmpty()) {
			int sum = stack2.pop();
			if(carry > 0) {
				sum += carry;
				carry = 0;
			}
			if(sum > 9) {
				carry = sum / 10;
				sum = sum % 10;
			}
			res = new Node(sum);
			res.next = tmp;
			tmp = res;
		}
		
		if(carry > 0) {
			res = new Node(carry);
			res.next = tmp;
			tmp = res;
		}
		return tmp;
	}

	public static void main(String[] args) {
		LinkedList ll1 = new LinkedList();
		ll1.insertAtEnd(7);
		ll1.insertAtEnd(2);
		ll1.insertAtEnd(4);
		ll1.insertAtEnd(3);
		
		LinkedList ll2 = new LinkedList();
		ll2.insertAtEnd(5);
		ll2.insertAtEnd(6);
		ll2.insertAtEnd(4);
		
		Node tmp = addTwoNumbers(ll1.head, ll2.head);
		while(tmp != null) {
			System.out.print(tmp.data + "->");
			tmp = tmp.next;
		}
		

	}

}
