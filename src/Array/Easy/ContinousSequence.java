package Array.Easy;

import java.util.*;

public class ContinousSequence {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "5", "9",  "6", "7", "8", "0", "-8", "-5", "-7", "-3", "-2", "-1"};
        Set<Integer> list = new HashSet<>();

        int next = 0;

        for (int i = 0; i < arr.length; i++) {
            int curr = Integer.valueOf(arr[i]);
            next = Integer.valueOf(arr[i+1]);
            if(next - curr > 1) {
                list.add(curr);
                if(list.size() > 1) {
                    System.out.println(list);
                    list.clear();
                    continue;
                } else {
                    list.clear();
                    continue;
                }
            }
            list.add(curr);

        }
    }
}
