package LeetCode;

import java.util.Arrays;

//leetcode 155 min stack
//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//Methods pop, top and getMin operations will always be called on non-empty stacks.
public class B0002_155_min_stack {
    int DEFAULT_SIZE = 10;
    int[] stack;
    int index;
    int size;
    int min;

//     minstack

    public static void main(String[] args) {
        B0002_155_min_stack obj = new B0002_155_min_stack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.pop();                      //remove 4
        int top = obj.top();            //3
        int min = obj.getMin();         //1
        System.out.println("top: " + top);
        System.out.println("min: " + min);
    }

    B0002_155_min_stack() {
        index = 0;
        size = DEFAULT_SIZE;
        stack = new int[DEFAULT_SIZE];
        min = Integer.MIN_VALUE;
    }

    public void push(int x) {
        if (index == size) {      //if it is full, scale up
            stack = Arrays.copyOf(stack, size >> 1);
            size = size >> 1;
        }
        stack[index++] = x;
        if (x > min) {
            min = x;
        }
    }

    public void pop() {
        if (index != 0) {
            index--;
        }

        if (index == 0) {
            min = Integer.MIN_VALUE;
        }
    }

    public int top() {
        if (index != 0) {
            return stack[index - 1];
        } else {
            throw new RuntimeException("no element in stack!");
        }
    }

    public int getMin() {
        if (index != 0) {
            return min;
        } else {
            throw new RuntimeException("no element in stack!");
        }
    }


}

//there two types of stack:
//one is made up with array
//another is made up with linked list