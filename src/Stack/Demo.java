package Stack;

import java.util.Stack;

public class Demo {
    public static void main(String[] args) {

        StackImpl stack = new StackImpl(3);

        stack.push(4);
        stack.push(5);
        stack.push(7);

        System.out.println("current popped element " + stack.pop());
        System.out.println("current top element " + stack.peek());

        Stack stack1 = new Stack();
        stack1.push(4);
        stack1.push(5);
        stack1.push(7);
        System.out.println("Reverse stack " + stack.reverseStack(stack1));

        System.out.println("Balanced paranthesis " + stack.ispar("{}"));

        StackImpl.MinStack minStack = new StackImpl.MinStack();
        minStack.push(-10);
        minStack.push(14);
        System.out.println("Minimum " + minStack.getMin());
        System.out.println("Minimum " + minStack.getMin());
        minStack.push(-20);
        System.out.println("Minimum " + minStack.getMin());
        System.out.println("Minimum " + minStack.getMin());

        System.out.println("Top " + minStack.top());
        System.out.println("Minimum " + minStack.getMin());
        System.out.println("pop out " + minStack.pop());
        minStack.push(10);
        minStack.push(-7);
        System.out.println("Minimum " + minStack.getMin());
        minStack.push(-7);
        System.out.println("pop out " + minStack.pop());
        System.out.println("Top " + minStack.top());
        System.out.println("Minimum " + minStack.getMin());
        System.out.println("pop out " + minStack.pop());
    }
}
