/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        HashMap<Node, Node> nodeMap = new HashMap<>();

        Node newHead = new Node(head.val);
        nodeMap.put(head, newHead);
        Node headPointer = head.next;
        Node newHeadPointer = newHead;

        while (headPointer != null) {
            newHeadPointer.next = new Node(headPointer.val);
            newHeadPointer = newHeadPointer.next;
            nodeMap.put(headPointer, newHeadPointer);
            headPointer = headPointer.next;
        }

        headPointer = head;
        newHeadPointer = newHead;

        while (newHeadPointer != null) {
            newHeadPointer.random = nodeMap.get(headPointer.random);
            headPointer = headPointer.next;
            newHeadPointer = newHeadPointer.next;
        }

        return newHead;
    }
}