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
    public void reorderList(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        ListNode secondHead = null, temp;

        while (slowPointer != null) {
            temp = slowPointer.next;
            slowPointer.next = secondHead;
            secondHead = slowPointer;
            slowPointer = temp;
        }

        ListNode start = head;

        while (secondHead != null) {
            ListNode firstNext = start.next;
            ListNode secondNext = secondHead.next;

            start.next = secondHead;
            secondHead.next = firstNext;
            
            secondHead = secondNext;
            start = firstNext;
        }
        if (start != null) {
            start.next = null;
        }

    }
}
