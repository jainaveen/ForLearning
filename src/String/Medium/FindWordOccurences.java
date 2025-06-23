package String.Medium;

import java.util.ArrayList;
import java.util.List;

public class FindWordOccurences {

    public static List<Integer> findAllOccurrences(String s, String word) {
        List<Integer> indices = new ArrayList<>();
        int index = s.indexOf(word); // First occurrence

        while (index != -1) {
            indices.add(index); // Store the found index
            index = s.indexOf(word, index + 1); // Find next occurrence
        }

        return indices;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String word = "foo";
        System.out.println(findAllOccurrences(s, word)); // Output: [0, 4, 12]
    }
}
