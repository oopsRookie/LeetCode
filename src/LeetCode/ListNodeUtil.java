package LeetCode;

public class ListNodeUtil {
    //build linked list
    static ListNode makeLinkedList(int type) {
        switch (type) {
            case 0:             //empty
                return null;
            case 1:             //only one item   [1]
                return new ListNode(1, null);
            case 2:             //only two items  [1,2]
                ListNode n6 = new ListNode(2, null);
                ListNode n7 = new ListNode(1, n6);
                return n7;
            case 6:             //contains a cycle
                ListNode n9 = new ListNode();
                ListNode n8 = new ListNode(1, n9);
                n9.setAll(2, n8);
                return n9;
            default:            //have five items [1,2,3,4,5]
                ListNode n5 = new ListNode(5, null);
                ListNode n4 = new ListNode(4, n5);
                ListNode n3 = new ListNode(3, n4);
                ListNode n2 = new ListNode(2, n3);
                ListNode n1 = new ListNode(1, n2);
                return n1;
        }
    }

    /**
     * make linked list from start to end.
     * start must smaller than or equal to end.
     * @param start first number
     * @param end last number
     * @return head of Linked List
     */
    static ListNode makeLinkedListBetween(int start, int end) {
        if (start > end) {
            throw new RuntimeException("start must not be smaller than end");
        }
        ListNode head = new ListNode(start, null);
        start++;
        ListNode lastNode = head;
        while (start <= end) {
            ListNode newNode = new ListNode(start, null);
            lastNode.next = newNode;          //point to next node
            lastNode = newNode;
            start++;
        }
        return head;
    }

}