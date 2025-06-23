package String.Easy;

public class StringToInteger {
    public static void main(String[] args) {
        String t ="java is a fun";
        System.out.println(t.split(" ").length);
        String str = "12345";
        int prev = 0;
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int curr = ch - '0';
            res = (prev * 10) + curr;
            prev = res;
        }
        System.out.println(res);
    }
}
