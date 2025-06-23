package Stack;

import java.util.*;

public class StackImpl<T> {

    int top = -1;
    int max;
    T[] arr;

    public StackImpl(int max) {
        this.max = max;
        arr = (T[])new Object[max];
    }
    public void push(T val) {
        if(top == max-1) {
            System.out.println("Stack full!!!! We cannot insert the value " + val);
            return;
        }
        arr[++top] = val;
    }

    public T pop() {
        if(top <= -1) {
            System.out.println("Stack is empty");
        }
       return  arr[top--];
    }

    public T peek() {
        return arr[top];
    }



    public boolean ispar(String x) {
        char[] arr = x.toCharArray();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case '{' :
                    stack.push('{');
                    break;
                case '[' :
                    stack.push('{');
                    break;
                case '(' :
                    stack.push('{');
                    break;
                case ']' :
                    if(!stack.empty() && stack.peek() == '['){
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '}' :
                    if(!stack.empty() && stack.peek() == '{'){
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ')' :
                    if(!stack.empty() && stack.peek() == '('){
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }
        if(!stack.empty()) {
            return false;
        }

        return true;
    }

    public Stack<Integer> reverseStack(Stack<Integer> s) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < s.size()) {
            list.add(s.pop());
        }

        for (int val : list) {
            s.add(val);
        }
        return s;
    }

  public static class MinStack {
        Stack allValues = new Stack();
        Stack minStack = new Stack();
      public void push(int val) {
          allValues.push(val);
          if(minStack.isEmpty() || val <= (int) minStack.peek()) {
              minStack.push(val);
          }
      }
      public int pop() {
        if(allValues.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return(int)allValues.pop();
      }

      public int top() {
          return (int) allValues.peek();
      }

      public int getMin() {
          return (int) minStack.peek();
      }
    }
}
