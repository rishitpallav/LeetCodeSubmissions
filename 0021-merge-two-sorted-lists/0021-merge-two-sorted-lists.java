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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list3 = new ListNode();
        ListNode temp = list3;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ListNode nextList1 = list1.next;
                temp.next = list1;
                temp = temp.next;
                temp.next = null;
                list1 = nextList1;
            } else {
                ListNode nextList2 = list2.next;
                temp.next = list2;
                temp = temp.next;
                temp.next = null;
                list2 = nextList2;
            }
        }

        while (list1 != null) {
            ListNode nextList1 = list1.next;
            temp.next = list1;
            temp = temp.next;
            temp.next = null;
            list1 = nextList1;
        }

        while (list2 != null) {
            ListNode nextList2 = list2.next;
            temp.next = list2;
            temp = temp.next;
            temp.next = null;
            list2 = nextList2;
        }

        return list3.next;
    }
}