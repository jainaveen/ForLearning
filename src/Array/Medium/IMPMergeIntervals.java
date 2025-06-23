package Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IMPMergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][] {{1,3},{20,22},{2,6},{8,10},{15,18}};
      //  int[][] intervals = new int[][] {{1,4},{2,3}};
       // int[][] intervals = new int[][] {{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
        int[][] res  = merge2(intervals);
        System.out.println("Merged Intervals:");
        for (int[] interval : res) {
            System.out.println(Arrays.toString(interval));
        }
    }
    public static  int[][] merge(int[][] arr) {
        int i = 0;
        int count = 0;
        while(i < arr.length-1) {
            if(arr[i][1] >= arr[i+1][0]) {
                arr[i+1][0] = arr[i][0];
                count ++;
            }
            i++;
        }
        int[][] res = new int[arr.length-count][2];
        int v =0;
        for (int j = 0; j < arr.length-1; j++) {
            if(arr[j][0] != arr[j+1][0]) {
                res[v][0] = arr[j][0];
                res[v][1] = arr[j][1];
                v++;
            }
            if(j == res.length-1 && res[j][1] != arr[j+1][1]) {
                res[v][0] = arr[j+1][0];
                res[v][1] = arr[j+1][1];
            }
        }
        return res;
    }

    public static  int[][] merge2(int[][] intervals) {
        // Sort intervals by the start time
        Arrays.sort(intervals, Comparator.comparingInt(c->c[0]));
        List<int[]> result = new ArrayList<>();

        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < currentInterval[1]) {
                currentInterval[1] = intervals[i][1];
            } else {
                result.add(currentInterval);
                currentInterval = intervals[i];
            }

        }
        result.add(currentInterval);

    return result.toArray(new int[result.size()][]);
    }
}
