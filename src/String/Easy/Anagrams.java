package String.Easy;

public class Anagrams {
    public static void main(String[] args) {
        checkAnagrams("listen", "silent", 26);
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
