package String.Easy;

public class CountValidWords {
    public static void main(String[] args) {
        System.out.println(countValidWords("!this  1-s b8d!"));
    }
    public static int countValidWords(String sentence) {
        int count = 0;
        String[] s = sentence.split(" ");
        for(int i=0;i<s.length;i++) {
            if(!s[i].isEmpty()) {
                String v = s[i].replaceAll("\\d","");
                if(s[i].length() == v.length()) {
                    count ++;
                }
            }
        }
        return count;
    }
}
