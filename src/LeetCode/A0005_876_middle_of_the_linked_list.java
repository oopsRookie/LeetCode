package LeetCode;

//leetcode 876. Middle of the Linked List
//If there are two middle nodes, return the second middle node.
//Input: [1,2,3,4,5]
//Output: Node 3 from this list (Serialization: [3,4,5])
public class A0005_876_middle_of_the_linked_list {
    public static void main(String[] args) {
        A0005_876_middle_of_the_linked_list obj = new A0005_876_middle_of_the_linked_list();
        ListNode list1 = ListNodeUtil.makeLinkedListBetween(1, 1);
        ListNode list2 = ListNodeUtil.makeLinkedListBetween(1, 2);
        ListNode list3 = ListNodeUtil.makeLinkedListBetween(1, 3);
        ListNode list4 = ListNodeUtil.makeLinkedListBetween(1, 4);

//        ListNode head = obj.middleNodeByTwoPointer(list4);      //list1 list2 list3 list4
//        ListNode head = obj.middleNodeByArray(list4);      //list1 list2 list3 list4
        ListNode head = obj.middleNodeByRecursive(list4);      //list1 list2 list3 list4
        if (head != null) {
            head.print();
        }
    }

    ListNode middleNodeByRecursive(ListNode head){
        if(head == null){
            return null;
        }
        return findNode(head, head);
    }
    ListNode findNode(ListNode slow,ListNode fast){
        if(fast == null || fast.next == null){
            return slow;
        }
        return findNode(slow.next, fast.next.next);
    }

    //find middle by array or stack
    ListNode middleNodeByArray(ListNode head) {
        ListNode[] nodes = new ListNode[100];
        int index = 0;
        while (head != null) {
            nodes[index] = head;
            head = head.next;
            index++;
        }
        return nodes[index / 2];
    }

    //find middle by two Pointer
    ListNode middleNodeByTwoPointer(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //if total number is odd(like 3),the fast eventually point to the last node and the slow point to middle node.
            //if it is even(like 4),the fast eventually point to null and the slow point to the second middle.
        }
        return slow;
    }
}