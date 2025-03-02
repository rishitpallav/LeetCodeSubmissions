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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode temp = new ListNode(0, head);
        ListNode prev = temp;

        int i = 1;
        for (; i < left; i++ ) {
            prev = prev.next;
        }

        prev.next = reverse(prev.next, right-left);

        return temp.next;
    }

    ListNode reverse(ListNode head, int current) {
        if (head == null || head.next == null || current == 0) {
            return head;
        }

        ListNode temp = reverse(head.next, current-1);
        ListNode nextNode = head.next.next;
        head.next.next = head;
        head.next = nextNode;

        return temp;
    }
}