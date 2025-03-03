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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tempHead = new ListNode(0, head);
        
        ListNode prev = tempHead;
        ListNode start = head;

        while (start != null) {
            ListNode end = prev;
            
            for (int i = 0; i < k; i++ ) {
                end = end.next;
                if (end == null) {
                    return tempHead.next;
                }
            }

            ListNode nextGroup = end.next;
            end.next = null;

            prev.next = reverse(start);
            start.next = nextGroup;

            prev = start;
            start = nextGroup;
        }

        return tempHead.next;
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return temp;
    }
}
