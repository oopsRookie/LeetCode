package LeetCode;

//leetcode 206 reverse linked list
//input：1->2->3->4->5->NULL
//output：5->4->3->2->1->NULL
public class A0001_206_reverse_linked_list {
    public static void main(String[] args) {
//        ListNode head = new A0001_206_reverse_linked_list().reverseList(ListNodeUtil.makeLinkedList(5));
        ListNode head = new A0001_206_reverse_linked_list()
                .reverseListByRecursive(null, ListNodeUtil.makeLinkedList(5));
        if (head != null) {
            head.print();
        }
    }

    //reverse by recursive call
    //tc(time consume): O(n)   n - length of linked list
    //sc(space consume): O(n)
    public ListNode reverseListByRecursive(ListNode prevNode, ListNode head) {
        //base case
        if (head == null) {
            return prevNode;
        }

        //general case
        ListNode nextNode = head.next;          //reserve the next node
        //reverse
        head.next = prevNode;
        //recursive call
        return reverseListByRecursive(head, nextNode);
    }

    //reverse by traverse/loop
    //tc: O(n)
    //sc: O(1)
    public ListNode reverseList(ListNode head) {
        if (head == null) {   //when it's empty
            return null;
        }

        ListNode prevPoint = null, curPoint = head, nextPoint = null;
        while (curPoint != null) {
            nextPoint = curPoint.next;
            //reverse
            curPoint.next = prevPoint;
            //shift to the next
            prevPoint = curPoint;
            curPoint = nextPoint;
        }
        return prevPoint;
    }



}