package LeetCode;

//21. Merge Two Sorted Lists
//Both l1 and l2 are sorted in non-decreasing order.
//Input: l1 = [1,2,4], l2 = [1,3,4]
//Output: [1,1,2,3,4,4]
public class A0003_21_merge_two_sorted_lists {
    public static void main(String[] args) {
        ListNode l1 = ListNodeUtil.makeLinkedListBetween(1, 3);
        ListNode l3 = ListNodeUtil.makeLinkedListBetween(2, 7);
//        ListNode head = new A0003_21_merge_two_sorted_lists()
//                .mergeTwoListsByRecursive(l1, l3);
        ListNode head = new A0003_21_merge_two_sorted_lists()
                .mergeTwoLists(l1, l3);
        if (head != null) {
            head.print();
        }
    }

    //merge by iteration
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode();
        ListNode head = dummy;
        //iterate and splice the next smallest to linked list
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                head.next = l2;         //pointer to the next smallest
                l2 = l2.next;
            } else {
                head.next = l1;         //pointer to the next smallest
                l1 = l1.next;
            }
            head = head.next;
        }
        //splice the remaining list
        head.next = l1 == null
                ? l2
                : l1;
        return dummy.next;
    }

    //merge by recursive call
    ListNode mergeTwoListsByRecursive(ListNode l1, ListNode l2) {
        //base case
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        //general case
        if (l1.val >= l2.val) {       //value of l2 smaller than the l1
            l2.next = mergeTwoListsByRecursive(l1, l2.next);        //point to the next smallest
            return l2;
        } else {
            l1.next = mergeTwoListsByRecursive(l1.next, l2);        //point to the next smallest
            return l1;
        }
    }

}