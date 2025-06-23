package Array.Easy;

public class MinAndMax {
    public static void main(String[] args) {
        int[] arr = {-3, -2, 1, 56, 10000, 167};
        findMinMax(arr);
    }
    static void findMinMax(int[] arr) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if(minValue > arr[i]) {
                minValue = arr[i];
            }
            if(maxValue < arr[i]) {
                maxValue = arr[i];
            }
        }
        System.out.println("Min value " +minValue);
        System.out.println("Max value " + maxValue);
    }
}
