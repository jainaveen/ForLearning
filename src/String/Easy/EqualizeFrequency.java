package String.Easy;

import java.util.HashMap;
import java.util.Map;

public class EqualizeFrequency {

    public static void main(String[] args) {
        System.out.println(equalFrequency("abbcc"));

        dummy("abbcc");

    }

    public static boolean equalFrequency(String word) {
        Map<Character,Integer> map = new HashMap<>();
        int maxFrequency = 1;
        int frequency = 0;
        for (int i = 0; i < word.length(); i++) {
            if(map.containsKey(word.charAt(i))) {
                map.put(word.charAt(i) , map.get(word.charAt(i)) + 1);
                maxFrequency = map.get(word.charAt(i));
            } else {
                map.put(word.charAt(i) , 1);
                frequency = 1;
            }
            if(maxFrequency > frequency) {
                frequency = maxFrequency;
            }
        }


        for (int i = 0; i < word.length(); i++) {
            if((map.get(word.charAt(i)) == frequency) && frequency >1) {
                map.put(word.charAt(i) , map.get(word.charAt(i)) - 1);
                frequency--;
                break;
            }
        }
        for (int i = 0; i < word.length(); i++) {
            if(map.get(word.charAt(i)) != frequency) {
                return false;
            }
        }

        return true;

    }

    public static void dummy(String text) {
        int[] arr = new int[128];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            arr[ch]++;
        }
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if(arr[ch] > 1) {
                arr[ch]--;
                break;
            }
        }
        int valueCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if(valueCount == 0) {
                valueCount = arr[ch];
            } else if(valueCount != arr[ch]) {
                System.out.println(false);;
            }
        }
    }
}
