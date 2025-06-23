package String.Medium;

import java.util.HashMap;
import java.util.Map;

public class CountReversals {

    public static void main(String[] args) {
        System.out.println(countRev("}}}}}}{}{}}}{{}}}}{}}{{{}{}{}{}}{{{{}}}{}}"));
        //System.out.println(countRev("}{{}}{{{"));
        //{}{{}{{{{{}}{}
    }

    static int countRev(String s) {
        if(s.length() % 2 != 0) {
            return -1;
        }
        int i = 0;
        while(i<s.length()-1) {
            if (s.charAt(i) == '{' && s.charAt(i + 1) == '}') {
                s = s.replace(s.substring(i,i+2),"");
                if(i != 0) {
                    i--;
                }
            } else {
                i++;
            }
        }
        int finalCount =0;
        int j = 0;
        while(j < s.length()-1) {
            if (s.charAt(j) == '}' && s.charAt(j + 1) == '{') {
                finalCount += 2;

            } else if (s.charAt(j) == '{' && s.charAt(j + 1) == '{') {
                finalCount += 1;

            } else if (s.charAt(j) == '}' && s.charAt(j + 1) == '}') {
                finalCount += 1;

            }
            j=j+2;
        }
        return finalCount;
    }
}
