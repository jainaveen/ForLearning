package String.Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ShortestPalindrome {
    public static void main(String[] args) {
        System.out.println("Shortest Palindrome " + shortestPalindrome("aabba"));
    }

    public static String shortestPalindrome(String s) {
        final String t = new StringBuilder(s).reverse().toString();

        for (int i = 0; i < t.length(); ++i)
            if (s.startsWith(t.substring(i)))
                return t.substring(0, i) + s;

        return t + s;
    }
}
