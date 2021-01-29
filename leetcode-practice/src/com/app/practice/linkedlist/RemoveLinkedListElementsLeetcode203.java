package com.app.practice.linkedlist;

import com.app.practice.LinkedList;
import com.app.practice.LinkedList.ListNode;

public class RemoveLinkedListElementsLeetcode203 {
    private static ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;

        ListNode tmp = head;
        ListNode result = new ListNode(Integer.MAX_VALUE);
        ListNode tmp1 = result;

        while(tmp != null) {
            if(tmp.val != val) {
                ListNode curr = tmp;
                tmp1.next = curr;
                tmp1 = tmp1.next;
            }
            tmp = tmp.next;
            tmp1.next = null;
        }

        result = result.next;
        return result;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = new ListNode(1);
        ll.head.next = new ListNode(2);
        ll.head.next.next = new ListNode(6);
        ll.head.next.next.next = new ListNode(3);
        ll.head.next.next.next.next = new ListNode(4);
        ll.head.next.next.next.next.next = new ListNode(5);
        ll.head.next.next.next.next.next.next = new ListNode(6);
        
        int val = 6;

        ListNode res = removeElements(ll.head, val);
        
        ListNode temp = res;
        while(temp != null) {
            System.out.println(temp.val + " ");
            temp = temp.next;
        }

        System.out.println();

    }
}
