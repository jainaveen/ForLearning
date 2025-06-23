package Backtracking.Recursion.Easy;

import java.util.ArrayList;
import java.util.List;

public class PrintPattern {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(pattern(16));
        System.out.println(pattern2(16));
    }
    public static List<Integer> pattern(int N){
        List<Integer> list = new ArrayList<>();
        list.add(N);
        if(N < 0) {
            return list;
        }
        List<Integer> list2 = pattern(N-5);
        if(N > 0) {
            list2.add(N);
        }
        list.addAll(list2);
        return list;
    }

    public static List<Integer> pattern2(int N) {
        if(N>0) {
            list.add(N);
            pattern2(N-5);
        }
        list.add(N);
        return list;
    }
}
