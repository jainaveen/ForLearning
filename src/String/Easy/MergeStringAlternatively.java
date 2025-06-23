package String.Easy;

public class MergeStringAlternatively {
    public static void main(String[] args) {
        String word1 = "cdf", word2 = "a";
        System.out.println("After Merge " +  mergeAlternately(word1,word2));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int m =0;
        int n=0;
        while(m<word1.length() && n<word2.length()) {
            sb.append(word1.charAt(m++));
            sb.append(word2.charAt(n++));
        }

        sb.append(word1.substring(m,word1.length()));
        sb.append(word2.substring(n,word2.length()));
        return sb.toString();
    }
}
