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
        ListNode greater = new ListNode(0);

        ListNode lowerPointer = lower;
        ListNode greaterPointer = greater;

        while (head != null) {
            if (head.val < x) {
                lower.next = new ListNode(head.val);
                lower = lower.next;
            } else {
                greater.next = new ListNode(head.val);
                greater = greater.next;
            }
            head = head.next;
        }

        lower.next = greaterPointer.next;

        return lowerPointer.next;
    }
}