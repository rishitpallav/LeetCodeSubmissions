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
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode evenHead = new ListNode(0);
        ListNode headHolder = head;
        ListNode evenHeadHolder = evenHead;

        while (headHolder.next != null && headHolder.next.next != null) {
            evenHeadHolder.next = headHolder.next;
            headHolder.next = headHolder.next.next;
            headHolder = headHolder.next;
            evenHeadHolder = evenHeadHolder.next;
        }

        evenHeadHolder.next = headHolder.next;

        headHolder.next = evenHead.next;
        return head;
    }
}