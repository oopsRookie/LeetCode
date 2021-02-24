package LeetCode;

public class B0002_155_min_stack_by_linked_list {
    Node head;

    public static void main(String[] args) {
        B0002_155_min_stack_by_linked_list obj = new B0002_155_min_stack_by_linked_list();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);

        obj.pop();
        int top = obj.top();
        int min = obj.getMin();
        System.out.println("top: " + top);              //3
        System.out.println("min: " + min);              //1
    }

    //inspired by https://leetcode.com/problems/min-stack/discuss/49010/Clean-6ms-Java-solution

    void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            head = new Node(x, Math.min(head.min, x), head);        //add new node to head
        }
    }

    void pop() {
        head = head.next;
    }

    int top() {
        return head.val;
    }

    int getMin() {
        return head.min;
    }

    static class Node {
        int val;
        int min;
        Node next;

        Node(int val, int min) {
            this(val, min, null);
        }

        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}


//this is really beautiful code.

//conclude:
//detail 1: each val along with a min.
//          just because each state(different elements in stack) may have different min.
//          min is affected by upcoming element
//detail 2: new element is added to head of the linked list
//          bec stack need be last in first out
//          and this linked list is single direction(called by next pointer)