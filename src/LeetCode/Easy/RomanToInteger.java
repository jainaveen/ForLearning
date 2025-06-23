package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        // 4 ms
      //  System.out.println(romanToInt( "MCMXCIV"));

        // 2ms
        System.out.println(romanToInt2("III"));
    }

    public static int romanToInt(String s) {
        int totalSum = 0;
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int prevValue = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            char ch = s.charAt(i);
            int currValue  = map.get(ch);
            if(currValue >= prevValue) {
                totalSum = totalSum + currValue;
            } else {
                totalSum = totalSum - currValue;
            }
            prevValue = currValue;
        }
        return totalSum;

    }

    public static int romanToInt2(String s) {
        int totalSum = 0;
        int prevValue = 0;

        for (int i = s.length()-1; i >=0; i--) {
            int curr = 0;

            switch (s.charAt(i)) {
                case 'I':
                    curr = 1;
                    break;

                case 'V':
                    curr = 5;
                    break;

                case 'X':
                    curr = 10;
                    break;

                case 'L':
                    curr = 50;
                    break;

                case 'C':
                    curr = 100;
                    break;

                case 'D':
                    curr = 500;
                    break;

                case 'M':
                    curr = 1000;
                    break;
            }

            if(curr >=   prevValue) {
                totalSum += curr;
            } else {
                totalSum -= curr;
            }
            prevValue = curr;
        }
        return totalSum;
    }
}


