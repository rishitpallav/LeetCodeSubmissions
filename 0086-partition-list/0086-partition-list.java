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
    public ListNode partition(ListNode head, int x) {
        ListNode lower = new ListNode(0);
        ListNode greater = new ListNode(0, head);

        ListNode lowerPointer = lower;
        ListNode greaterPointer = greater;

        while (greater != null && greater.next != null) {
            if (greater.next.val < x) {
                lower.next = greater.next;
                lower = lower.next;
                greater.next = greater.next.next;
            } else {
                greater = greater.next;
            }
        }

        lower.next = greaterPointer.next;

        return lowerPointer.next;
    }
}