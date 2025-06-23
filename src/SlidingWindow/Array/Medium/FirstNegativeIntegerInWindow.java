package SlidingWindow.Array.Medium;

import java.util.*;

public class FirstNegativeIntegerInWindow {
    public static void main(String[] args) {
        int N = 5, K = 2;
        long A[] = {-8, 2, 3, -6, 10};

        long B[] = printFirstNegativeInteger(A,N,K);
        for (int i = 0; i < B.length; i++) {
            System.out.print(" "+B[i]);
        }
        System.out.println();

    }
    /*
    public static long[] printFirstNegativeInteger(long A[], int N, int K) {
        List<Long> list = new ArrayList<>();
        Map<Integer,Long> map = new HashMap<>();
        int j=0;
        for (int i = 0; i < K; i++) {
            map.put(i,A[i]);
        }
        Optional<Map.Entry<Integer, Long>> res =  map.entrySet().stream()
                .filter(h->h.getValue() < 0).findFirst();
        if(res.isPresent()) {
            list.add(res.get().getValue());
        } else {
            list.add(0l);
        }
        j++;
        int left =0;
        for (int i = K; i < A.length; i++) {
            map.remove(left);
            map.put(i,A[i]);
            left++;
            if(map.size() == K) {
                Optional<Map.Entry<Integer, Long>> res1 =  map.entrySet().stream()
                        .filter(h->h.getValue() < 0).findFirst();
                if(res1.isPresent()) {
                    list.add(res1.get().getValue());
                } else {
                    list.add(0l);
                }
                j++;
            }
        }
        long[] l = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            l[i] = list.get(i);
        }
        return l;
    }


     */
    public static long[] printFirstNegativeInteger(long A[], int N, int K) {
        List<Long> window = new ArrayList<>();
        long[] lo = new long[A.length - K + 1];

        // Fill the initial window
        for (int i = 0; i < K; i++) {
            window.add(A[i]);
        }
        int start = 0;
        lo[start] = window.stream().filter(n -> n < 0).findAny().orElse(0L);
        // Find the first negative element in the window and add it to the result
        for (int i = K; i < A.length; i++) {

            // Slide the window by removing the first element and adding the next element

            window.remove(0);
            window.add(A[i]);
            start++;
            lo[start] = window.stream().filter(n -> n < 0).findAny().orElse(0L);
        }

        return lo;

    }
}
