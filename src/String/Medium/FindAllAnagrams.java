package String.Medium;

import String.Easy.Anagrams;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {

    public static void main(String[] args) {
        findAllAnagram();
    }

    public static void findAllAnagram() {
        List<Integer> list = new ArrayList<>();
        String s = "cbaebabacd", p = "abc";
        int k = p.length();
        boolean val = Anagrams.checkAnagrams(s.substring(0,p.length()),p,k);
        if(val) {
            list.add(0);
        }
        int start = 0;
        for (int i = k; i < s.length(); i++) {
            String n = s.substring(start+1,k+start+1);
            boolean val1 = Anagrams.checkAnagrams(n,p,k);
            if(val1) {
                list.add(start+1);
            }
            start++;
        }
        System.out.println(list);
    }

    public static boolean checkAnagrams(String  str1, String str2 ,int k) {
        int[] ch1 = new int[26];
        int[] ch2 = new int[26];
        for(int i=0; i< k;i++) {
            char c1 = str1.charAt(i);
            ch1[c1 - 'a']++;

            char c2 = str2.charAt(i);
            ch2[c2 - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if(ch1[i] != ch2[i]) {
                return false;
            }
        }
        return true;
    }
}
