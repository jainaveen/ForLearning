package SlidingWindow.Array.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountDistinctElementInWindow {
    public static void main(String[] args) {
        int N = 7, K = 4;
        int A[] = {1,2,1,3,4,2,3};
        System.out.println(countDistinct(A,N,K));
    }
    static ArrayList<Integer> countDistinct(int A[], int n, int k) {
        // code here
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0;i < k; i++) {
            map.put(A[i],map.getOrDefault(A[i],0)+1);
        }
        res.add(map.size());
        int left =0;
        for(int i = k; i < A.length; i++) {
            map.put(A[left],map.get(A[left])-1);
            if(map.get(A[left]) == 0){
                map.remove(A[left]);
            }
            map.put(A[i],map.getOrDefault(A[i],0)+1);
            left++;

            res.add(map.size());

        }
        return res;
    }
}
