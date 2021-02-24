package LeetCode;

import java.util.Stack;

//19. Remove Nth Node From End of List
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
public class A0004_19_remove_nth_node_from_end_of_list {
    public static void main(String[] args) {
        A0004_19_remove_nth_node_from_end_of_list obj = new A0004_19_remove_nth_node_from_end_of_list();
        ListNode list = ListNodeUtil.makeLinkedListBetween(1, 5);
        ListNode list1 = ListNodeUtil.makeLinkedListBetween(1, 2);
//        ListNode head = obj.removeNthFromEndByStack(list1, 1);         //try 1 instead of 5
//        ListNode head = obj.removeNthFromEndByArray(list, 5);         //try 1 ...
        ListNode head = obj.removeNthFromEnd(list1, 1);               //try 1 ...
        if (head != null) {
            head.print();
        }
    }

    //inspired by https://leetcode.com/problems/remove-nth-node-from-end-of-list/discuss/9000/A-simple-2ms-C-solution
    ListNode removeNthFromEnd(ListNode head, int n){
        ListNode ret = head;
        ListNode nPlus1thNode = head;
        ListNode fast = head;
        while(fast != null){
            fast = fast.next;
            if(n < 0){                  //make sure the slow is n steps slower than the fast
                nPlus1thNode = nPlus1thNode.next;
            }
            n--;
        }
        if(n == 0){           //if remove the first node, explanation: when n is equal to length of list,it's zero.
            return ret.next;
        }else{
            nPlus1thNode.next = nPlus1thNode.next.next;             //delete nth node
            return ret;
        }
    }

    //Constraints: the number of nodes in the list is sz, sz in [1,30]
    ListNode removeNthFromEndByArray(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n <= 0) {
            throw new RuntimeException("n must be positive int");
        }
        ListNode ret = head;
        ListNode[] nodes = new ListNode[30];
        int index = 0;
        //push all in array
        while (head != null) {
            nodes[index] = head;
            index++;
            head = head.next;
        }
        if(n == index){                 //if remove the first node
            return ret.next;
        }else{
            ListNode nthNode = nodes[index - n];            //last nth node
            ListNode nPlus1Node = nodes[index - n - 1];     //last (n+1) node
            nPlus1Node.next = nthNode.next;                 //delete the last nth node
            return ret;
        }


    }


    ListNode removeNthFromEndByStack(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n <= 0) {
            throw new RuntimeException("n must be positive int");
        }
        ListNode ret = head;
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode nthNode = null;
        //stack.elementAt() can replace pop and it's more efficient too.
        while (n > 0) {
            nthNode = stack.pop();              //last nth node
            n--;
        }
        //if remove the first node, stack will be empty and stack.pop() will throw exception
        if (stack.isEmpty()) {
            return nthNode.next;
        } else {
            ListNode nPlus1thNode = stack.pop();    //last (n+1)th node
            //make (n+1)th node's next pointer point to (n-1)th node
            nPlus1thNode.next = nthNode.next;       //it's already promises nthNode not be null

            return ret;
        }
    }
    //make a loop
    //stop on the last n node
    //Q: how to identify the last n node, we don't know the length of linked list
    //remove it

    //idea1: could we convert n to some number that we count from head to tail?
    //A: yes,but we need calculate the length of linked list first. it's not efficient.

    //idea2: use stack? when pop last (n+1)th node, make it's next point to last (n-1)th node to delete the nth node

    //idea3: stack is too heavy. could we change to use some light thing like array?


    //ideas come out after finishing,
    //1、maybe we don't need to pop element out, stack has <code> elementAt </code> to
    //get element at some position.
    //2、i find some other methods on leetcode, includes:
    //   ①double pointer(the fast and the slow are both 1 pace/time, but fast need move n paces in advance)
    //   ②recursive call
}