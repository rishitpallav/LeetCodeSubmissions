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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode temp = head;

        while (true) {
            ListNode smallest = null;
            int smallestIndex = -1;

            for (int i = 0; i < lists.length; i++ ) {
                if (lists[i] != null) {
                    if (smallest == null || smallest.val > lists[i].val) {
                        smallest = lists[i];
                        smallestIndex = i;
                    }
                }
            }

            if (smallest == null) break;

            temp.next = smallest;
            temp = temp.next;
            lists[smallestIndex] = lists[smallestIndex].next;
        }

        return head.next;
    }
}