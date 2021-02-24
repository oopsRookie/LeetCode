package LeetCode;

import java.util.HashSet;
import java.util.Set;

//leetcode 141 Linked List Cycle
//determine if the linked list has a cycle in it
public class A0002_141_linked_list_cycle {
    public static void main(String[] args) {
        ListNode head = ListNodeUtil.makeLinkedList(6);         //type 6 has a cycle
//        boolean cycle = new A0002_141_linked_list_cycle().hasCycleByTag(head);
//        boolean cycle = new A0002_141_linked_list_cycle().hasCycleByTagSelf(head);
        boolean cycle = new A0002_141_linked_list_cycle().hasCycleByTwoPointer(head);
        System.out.println("if linked list contains a cycle:【" + cycle + "】");
    }


    //if list has a cycle and two pointer move at different fixed rates,
    //they will finally meet together.
    boolean hasCycleByTwoPointer(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slowPointer = head, fastPointer = head;
        while (slowPointer != null
                && fastPointer != null
                && fastPointer.next != null) {          //make sure that <code> fastPointer = fastPointer.next.next; </code> is legal
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }

    //tag self by making pointer point to themselves
    //<em> this action will help break infinite loops when list has a cycle </em>
    //and the node meet <code> head.next == head </code> is just the junction
    // (the node both in cycle and non-cycle)
    boolean hasCycleByTagSelf(ListNode head) {
        while (head != null) {
            if (head.next == head) {          //if has cycle
                return true;
            }
            //reserve the next node
            ListNode nextNode = head.next;
            //make tag
            head.next = head;
            //traverse
            head = nextNode;
        }
        return false;
    }

    //implemented by tag
    boolean hasCycleByTag(ListNode head) {
        if (head == null) {
            return false;
        }
        //in some jvm,different object may have same hashcode.
        //but here we use hashcode for simplicity
        Set<Integer> hashCodeSet = new HashSet<Integer>();
        while (head != null) {
            if (!hashCodeSet.add(head.hashCode())) {          //already has this object in the set
                return true;
            }
            head = head.next;
        }
        return false;
    }

}