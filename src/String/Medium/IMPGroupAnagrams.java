package String.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class IMPGroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);

        // Print the result
        for (List<String> group : result) {
            System.out.println(group);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        // A map to group anagrams
        Map<String, List<String>> map = new HashMap<>();

        // Iterate through each string in the input array
        for (String str : strs) {
            // Sort the string and use it as the key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            /*
            // If the sorted string is already a key in the map, add the original string to its list
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }

             */

            map.putIfAbsent(sortedStr, new ArrayList<>());

            map.get(sortedStr).add(str);
        }

        // Return the grouped anagrams as a list of lists
        return new ArrayList<>(map.values());
    }
}
