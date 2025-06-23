package Backtracking.Recursion.Strings;

public class SkipCharacter {

    public static void main(String[] args) {
        skip("","fbcaad",'a');
    }

    static void skip(String p, String up, char target) {

        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        if(ch == target) {
            skip(p, up.substring(1), target);
        } else {
            skip(p+ch,up.substring(1),target);
        }
    }
}
