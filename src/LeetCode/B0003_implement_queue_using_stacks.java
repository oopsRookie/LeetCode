package LeetCode;

//232. Implement Queue using Stacks
//Implement a first in first out (FIFO) queue using only two stacks.
//The implemented queue should support all the functions of a normal queue
//(push, peek, pop, and empty).

import java.util.Stack;

//fellow-up:  tc: each operation is amortized O(1) time complexity
public class B0003_implement_queue_using_stacks {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> auxiliary = new Stack<>();

    public static void main(String[] args) {
        B0003_implement_queue_using_stacks obj = new B0003_implement_queue_using_stacks();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        int peek = obj.peek();
        int pop = obj.pop();
        System.out.println("peek: " + peek);            //1
        System.out.println("pop: " + pop);              //1

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
//        while (!stack.isEmpty()){
//            auxiliary.push(stack.pop());
//        }
//        stack.push(x);      //add to bottom
//        while (!auxiliary.isEmpty()){       //back to stack in original order
//            stack.push(auxiliary.pop());
//        }

        //method 2
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
//        if(stack.isEmpty()){
//            throw new RuntimeException("invalid pop operation on empty stack");
//        }
//        while (!stack.isEmpty()){
//            auxiliary.push(stack.pop());
//        }
//        int bottom = auxiliary.pop();            //remove it
//        while (!auxiliary.isEmpty()){
//            stack.push(auxiliary.pop());
//        }
//        return bottom;

        //method 2
        peek();
        return auxiliary.pop();
    }

    /** Get the front element. */
    public int peek() {
//        while (!stack.isEmpty()){
//            auxiliary.push(stack.pop());
//        }
//        int bottom = auxiliary.peek();            //get it but don't remove it
//        while (!auxiliary.isEmpty()){
//            stack.push(auxiliary.pop());
//        }
//        return bottom;

        //method 2
        if(auxiliary.isEmpty()){   //push all items into auxiliary only if auxiliary is empty
            while (!stack.isEmpty()){
                auxiliary.push(stack.pop());
            }
        }
        return auxiliary.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
//        return stack.isEmpty();

        //method 2
        return stack.isEmpty() && auxiliary.isEmpty();
    }
}

//stack: first in last out.
//queue: first in first out.
//operations: enqueue(from tail)、dequeue(from head)

//method 1:
//each upcoming element need to be added to the bottom of stack.
//so each push operation, we need to a auxiliary stack to reserve data.
//push(tc:O(n),sc:O(n))、pop(tc:O(n),sc:O(n))、peek(tc:O(n),sc:O(n))

//mothod 2:
//get inspired by https://leetcode.com/problems/implement-queue-using-stacks/discuss/64206/Short-O(1)-amortized-C%2B%2B-Java-Ruby
//similar to method 1, we need a input stack to reverse incoming data but not reverse them.
//util calling peek/pop, we will reverse them to output stack when needed.
//push(tc:O(1),sc:O(1))、pop(tc:O(1),sc:O(n))、peek(tc:O(1),sc:O(n))
//auxiliary stack reserve elements in correct order(FIFO).
//tips: peek() only transfer data from stack to auxiliary when auxiliary is empty,
// so it's time complexity is amortised O(1).

//why should we use two stacks to implement a queue? is it just a trick?
//https://leetcode.com/problems/implement-queue-using-stacks/discuss/64284/Do-you-know-when-we-should-use-two-stacks-to-implement-a-queue