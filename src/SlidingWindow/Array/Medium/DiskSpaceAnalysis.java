package SlidingWindow.Array.Medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DiskSpaceAnalysis {

    public static void main(String[] args) {
       int[] diskSpace = {8, 2, 4, 6};
        int m = 2;

        //Brute force
        /*
        int maxValue =  Integer.MIN_VALUE;

        for (int i = 0; i <= diskSpace.length - m; i++) {
            int minVal = Integer.MAX_VALUE;

            // Iterate over the window of size m
            for (int j = i; j < i + m; j++) {
                minVal = Math.min(minVal, diskSpace[j]);
            }

            // Track the maximum of all min values
            maxValue = Math.max(maxValue, minVal);
        }

        System.out.println(maxValue);

         */
        int maxValue =  Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            minValue = Math.min(minValue, diskSpace[i]);
        }
        list.add(minValue);

        //maxValue = Math.max(minValue,maxValue);
        for (int i = m; i < diskSpace.length-1; i++) {
            minValue = Math.min(diskSpace[i], diskSpace[i+1]);
            list.add(minValue);
        }
        System.out.println(list.stream().mapToInt(c->c.intValue()).max().getAsInt());
    }

}
