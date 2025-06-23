package String.Easy;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicateCharacters {
    public static void main(String[] args) {
        System.out.println(findDuplicates("programming"));
    }

    public static List<Character> findDuplicates(String text) {
        List<Character> list = new ArrayList<>();
        int[] ch = new int[26];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(ch[c - 'a'] == 0) {
                ch[c - 'a'] = 1;
            } else {
                list.add(c);
            }
        }
        return list;
    }
}
