package Stack;

import java.util.Arrays;
import java.util.Stack;

public class    RemoveConsecutiveDuplicates {

    public static void main(String[] args) {

        Stack<Character> stack = new Stack<>();
        String text = "abbaca";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if(stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }


        System.out.println("After removing duplciates " + sb.reverse().toString());
    }
}
