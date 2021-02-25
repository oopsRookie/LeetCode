package LeetCode;

import java.util.Arrays;

//leetcode 155 min stack
//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//Methods pop, top and getMin operations will always be called on non-empty stacks.
public class B0002_155_min_stack {
    int DEFAULT_SIZE = 10;
    //    element stack
    int[] stack;
    int index;
    int size;

    //     minstack
    int[] minstack;             //minstack share same index and size with element stack


    //3ms 100%
    //40.4MB 91.48%
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
        //initial minstack
        minstack = new int[DEFAULT_SIZE];
    }

    public void push(int x) {
        if (index == size) {      //if it is full, scale up
            size = size << 1;
            stack = Arrays.copyOf(stack, size);
            minstack = Arrays.copyOf(minstack, size);
        }
        stack[index] = x;
        if (index == 0) {               //push the newest minimum into stack
            minstack[index] = x;
        } else {
            minstack[index] = Math.min(x, minstack[index - 1]);
        }
        index++;
    }

    //just remove
    public void pop() {
        if (index != 0) {
            index--;
        }
    }

    public int top() {
        if (index != 0) {
            return stack[index - 1];
        } else {
            throw new RuntimeException("no element in stack!");
        }
    }

    //the minimum changes as the upcoming element
    //so we need a stack to keep the last minimum
    public int getMin() {
        if (index != 0) {
            return minstack[index - 1];
        } else {
            throw new RuntimeException("no element in stack!");
        }
    }


}

//there two types of stack:
//one is made up of array
//another is made up of linked list