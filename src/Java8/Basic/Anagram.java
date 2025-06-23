package Java8.Basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagram {

    public static void main(String[] args) {
        String s1 ="rat";
        String s2 ="art";


       // Best approach
        System.out.println("IsAnagram " + isAnagram(s1,s2));

        System.out.println(isAnagram2(s1,s2));

        System.out.println("Java 8-Is Anagram " + isAnagram3(s1,s2));
    }

    private static boolean isAnagram3(String s1, String s2) {
       String s3
               = Stream.of(s1.split(" "))
                    .map(m->m.toLowerCase())
                    .sorted()
                    .collect(Collectors.joining());
       String s4 = Stream.of(s2.split(" ")).map(m->m.toLowerCase())
               .sorted().collect(Collectors.joining());
       if(s3 == s4) {
           return true;
       } else {
           return false;
       }
    }



    public static boolean isAnagram(String s, String t) {
       int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < alphabet.length; i++) {
            if(alphabet[i] !=0) {
                return false;
            }
        }
        return true;
    }


    public static boolean isAnagram2(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        if (Arrays.equals(c1, c2)) {
            return true;
        } else {
            return false;
        }
    }
}
