package String.Easy;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatElement {

    public static void main(String[] args) {
        String str = "malayalam";
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i),1);
            }
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                System.out.println("First non repeat element " + entry.getKey());
                break;
            }
        }
        int[] arr = new int[26];
        int[] charCount = new int[256]; // Supports ASCII characters

        // First pass: Count occurrences
        for (char c : str.toCharArray()) {
            charCount[c]++;
        }

        // Second pass: Find the first non-repeating character
        for (char c : str.toCharArray()) {
            if (charCount[c] == 1) {
                System.out.println("result " + c);
                break;
            }
        }
    }
}
