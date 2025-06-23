package Intervals.Medium;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{15,18}};
        int[] newInterval = {4,8};
        insert(intervals,newInterval);
    }

    public static  int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> res = new ArrayList<>();
        int start = newInterval[0], end = newInterval[1];

        for (int[] interval : intervals) {
            if (interval[1] < start || start == -1) {
                // No overlap, add directly
                res.add(interval);
            } else if (interval[0] > end) {
                // New interval goes before this one
                res.add(new int[]{start, end});
                res.add(interval);
                start = -1;
            } else {
                // Merge overlapping intervals
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }

        if (start != -1) {
            // If newInterval was never added, add it now
            res.add(new int[]{start, end});
        }

        return res.toArray(new int[res.size()][]);
    }
}
