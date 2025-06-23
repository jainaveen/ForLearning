package String.Medium;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RepeatedCharactersWithoutHashMap {

    public static void main(String[] args) {
        String text = "geeksforgeeks";

        int[] ch = new int[26];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            ch[c - 'a']++;
        }

        //below logic is not required
        /*

        String dis = text.chars()
                .distinct()
                .mapToObj(m->String.valueOf((char) m))
                .collect(Collectors.joining());

        for (int i = 0; i < dis.length(); i++) {
            char c = dis.charAt(i);
            System.out.println(c + "-" + ch[c-'a']);
        }

         */

        for (int i = 0; i < ch.length; i++) {
            if(ch[i] > 1) {
                System.out.println((char) (i+'a') + "-" + ch[i]);
            }
        }
    }
}
