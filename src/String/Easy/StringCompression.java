package String.Easy;

import java.util.Map;
import java.util.TreeMap;

public class StringCompression {
    public static void main(String[] args) {
    char[] arr = {'a','b','b','a','a','a'};
    char[] arr2 = {'a','b','b','a','a','a'};
    System.out.println("Compression " + compress(arr));
    System.out.println("Compression " + compress2(arr2));

        System.out.println(stringCompress("aaabbc"));

    }

    private static String stringCompress(String text) {
        int[] ch = new int[256];
        for(char c : text.toCharArray()) {
            ch[c]++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if(sb.indexOf(String.valueOf(c)) == -1) {
                sb.append(c).append(ch[c]);
            }
        }
        return sb.toString();
    }

    public static int compress(char[] chars) {

        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < chars.length; i++) {
                if(i+1 < chars.length && chars[i] == chars[i+1] ) {
                    count++;
                } else {
                    sb.append(chars[i]);
                    if(count > 1) {
                        sb.append(count);
                    }
                    count = 1;
                }

        }

        String str = sb.toString();
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        return str.length();

    }

    public static int compress2(char[] nums) {
        StringBuilder s= new StringBuilder();
        int cnt =1;
        for( int i=0;i<nums.length;i++){
            if (i+1<nums.length && nums[i]==nums[i+1]) cnt++;
            else {
                s.append(nums[i]);
                if (cnt>1) s.append(cnt);
                cnt =1;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            nums[i] = s.charAt(i);
        }
        return s.length();
    }

}
