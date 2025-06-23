package String.Easy;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));

        System.out.println(removeDuplicatesUsingCharacterArray("abbaca"));
    }

    public static String removeDuplicates(String str) {

        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(!stack.contains(c)) {
                stack.push(c);
            }
        }

        // Construct the result string
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static String removeDuplicatesUsingCharacterArray(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if(sb.indexOf(String.valueOf(c)) == -1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
