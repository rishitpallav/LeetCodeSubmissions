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
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode tempNode = new ListNode(0, head);

        ListNode fp = tempNode;
        ListNode sp = fp.next;
        

        while (sp != null) {
            if (sp.next != null && sp.val == sp.next.val) {
                while (sp.next != null && sp.val == sp.next.val) {
                    sp = sp.next;
                }
                fp.next = sp.next;
            } else {
                fp = fp.next;
            }
            sp = fp.next;
        }

        return tempNode.next;
    }
}