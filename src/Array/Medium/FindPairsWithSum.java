package Array.Medium;

import java.util.*;

public class FindPairsWithSum {
    public static void main(String[] args) {
        int[] array = {2, 4, 3, 5, 7, 8, 1};
        int target = 9;

        List<int[]> output = findPairsWithSum(array, target);
        for (int[] pair : output) {
            System.out.println(Arrays.toString(pair));
        }
    }

    public static List<int[]> findPairsWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>(); ;
        Set<List<Integer>> pairs = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                // Add the pair in sorted order to ensure uniqueness
                pairs.add(Arrays.asList(Math.min(num, complement), Math.max(num, complement)));
            }
            seen.add(num);
        }
        List<int[]> result = new ArrayList<>();
        for (List<Integer> pair : pairs) {
            result.add(new int[]{pair.get(0), pair.get(1)});
        }
        return result;
    }
}
