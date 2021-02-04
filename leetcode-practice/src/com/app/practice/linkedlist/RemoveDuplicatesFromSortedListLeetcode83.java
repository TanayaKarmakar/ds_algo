package com.app.practice.linkedlist;

import com.app.practice.LinkedList;
import com.app.practice.LinkedList.ListNode;

public class RemoveDuplicatesFromSortedListLeetcode83 {
    private static ListNode deleteDuplicates(ListNode head) {
        if(head ==null || head.next == null)
            return head;
        ListNode p = head;
        while(p != null) {
            ListNode q = p.next;
            while(q != null && p.val == q.val) {
                q = q.next;
            }
            p.next = q;
            p = q;
        }

        return head;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = new ListNode(1);
        ll.head.next = new ListNode(1);
        ll.head.next.next = new ListNode(2);
        ll.head.next.next.next = new ListNode(3);
        ll.head.next.next.next.next = new ListNode(3);

        ll.head = deleteDuplicates(ll.head);

        ListNode tmp = ll.head;

        while(tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }

        System.out.println();
    }
}
