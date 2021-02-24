package LeetCode;

import Basic.Test;

public class ListNodeTest {
    public static void main(String[] args) {
        ListNodeTest test = new ListNodeTest();
//        test.testMakeLinkedListNodeBetween(11, 10);
//        test.testMakeLinkedListNodeBetween(-1, 10);
        test.testMakeLinkedListNodeBetween(10, 10);
    }

    void testMakeLinkedListNodeBetween(int start, int end){
        ListNode head = ListNodeUtil.makeLinkedListBetween(start, end);
        if(head != null){
            head.print();
        }
    }
}