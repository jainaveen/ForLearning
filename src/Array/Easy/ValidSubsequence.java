package Array.Easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ValidSubsequence {

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(5, 1, 22);
        List<Integer> sequence = Arrays.asList(5, 6, 1, 22);

        System.out.println("Valid subsequence using array " + isValidSubsequence(array,sequence));

        String s = "ace";
        String t = "abecd";

        System.out.println("Valid subsequence using string " + isValidSubsequenceString(s,t));
    }

    private static boolean isValidSubsequenceString(String s, String t) {
        int j =0 ;
        for(int i=0;i<=t.length()-1;i++) {
            if(t.charAt(i) == s.charAt(j)) {
                j++;
            }
            if(j == s.length()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    // using two pointer approach
        int seqIdx = 0;

        for (int value : sequence) {

            if (array.get(seqIdx).equals(value)) {
                seqIdx++;
            }

            if (seqIdx == array.size()) {
                return true;
            }
        }

        return false;
    }

}
