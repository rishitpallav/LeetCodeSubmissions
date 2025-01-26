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
        if (head == null ) {
            return null;
        }
        ListNode temp = head;
        ListNode headTemp = head;
        while (temp != null && temp.next != null) {
            if (head.val == temp.val) {
                temp = temp.next;
                head.next = temp;
            } else {
                temp = temp.next;
                head = head.next;
            }
        }
        if (temp != null && temp.val == head.val) {
            head.next = null;
        }
        return headTemp;
    }
}