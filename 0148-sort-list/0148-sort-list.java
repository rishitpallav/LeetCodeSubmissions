/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid (head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeLists(left, right);
    }

    public ListNode getMid (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        ListNode prev = null;

        while (fastPointer != null && fastPointer.next != null) {
            prev = slowPointer;
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        if (prev != null) {
            prev.next = null;
        }

        return slowPointer;
    }

    ListNode mergeLists (ListNode a, ListNode b) {
        ListNode head = new ListNode(0);
        ListNode temp = head;

        while (a != null || b != null) {
            if (a == null) {
                head.next = b;
                break;
            }
            if (b == null) {
                head.next = a;
                break;
            }

            if (a.val < b.val) {
                head.next = a;
                a = a.next;
                head = head.next;
            } else {
                head.next = b;
                b = b.next;
                head = head.next;
            }
        }

        return temp.next; 
    }
}