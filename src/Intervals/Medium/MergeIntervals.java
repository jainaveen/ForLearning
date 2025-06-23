package Intervals.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
     //   int[][] intervals = {{1,3},{15,18},{8,10},{2,6}};
        int[][] intervals = {{1,4},{2,3}};
        merge(intervals);
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(m->m[0]));
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1])
                // Overlapping intervals,
                // update the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {
                // Disjoint intervals,
                // add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
