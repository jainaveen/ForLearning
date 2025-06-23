package String.Easy;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;

public class BalancedStringSplit {
    public static void main(String[] args) {

        String text = "BANCdfdf";
        String te = "ABC";
        System.out.println(text.substring(0,te.length()));

        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        dummy("RLRRLLRLRL");
    }
    public static int balancedStringSplit(String input) {
        int lCount=0;
        int rCount=0;
        int res =0;
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == 'R') {
                rCount = rCount+1;
            } else {
                lCount = lCount+1;
            }
            if(rCount == lCount) {
                res = res + 1;
            }
        }
        return res;


    }

    public static void dummy(String in) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < in.length(); i++) {
            char ch = in.charAt(i);
            map.put(ch, map.getOrDefault(ch,0) + 1);
            if(map.size() == 2) {
                int rvalue = map.get('R');
                int lvalue = map.get('L');
                if( rvalue == lvalue) {
                    res++;
                    map.clear();
                }
            }

        }
        System.out.println("out " + res);
    }
}
