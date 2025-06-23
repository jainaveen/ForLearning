package String.Medium;


public class ReverseWordsInAString {



    public static void main(String[] args) {
        reverseWords(" hello   world ");


    }




    public static void reverseWords(String s) {
        String[] t = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = t.length-1; i >=0 ; i--) {
            sb.append(t[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
