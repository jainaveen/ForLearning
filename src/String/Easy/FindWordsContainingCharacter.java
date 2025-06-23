package String.Easy;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter {

    public static void main(String[] args) {
        String[] words = {"abc","bcd","aaaa","cbc"};
        System.out.println(findWordsContaining(words,'z'));
    }

    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int e = words[i].indexOf(x);
            if(e > -1) {
                list.add(i);
            }
        }
        return list;
    }
}
