package String.Easy;

import java.util.HashMap;
import java.util.Map;

public class Reverse {
    public static void main(String[] args) {
        String text = "how";
        System.out.println("Before reverse " + text);
        //Approach 1
        System.out.println("After reverse " + reverseString(text));

        //Approach 2
        System.out.println("After reverse using while " + reverseWhile(text));

        dummy();
    }

    private static String reverseWhile(String text) {
        char[] arr = text.toCharArray();
        int left = 0;
        int right = arr.length-1;
        while(left < right) {
            char c = arr[right];
            arr[right--] = arr[left];
            arr[left++] = c;

        }
        return String.copyValueOf(arr);
    }

    private static String reverseString(String text) {
        char[] ch = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = ch.length-1; i >=0; i--) {
            sb.append(ch[i]);
        }
        return sb.toString();
    }

    private static void dummy() {
        String str1 = new String("abc");
        String str2 = new String("abc");
        String str3 = new String("abc");

        Map<String, String> map = new HashMap<>();
        map.put(str1, "a1");
        map.put(str2, "a2");
        System.out.println(map.get((str1)));
        System.out.println(map.get((str2)));

        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));
    }
}
