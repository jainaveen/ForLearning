package Array.Easy;

public class IMPSecondSmallestValue {

    public static void main(String[] args) {
        int[] arr = {2,3,1,5 };
        int first_num = Integer.MAX_VALUE;
        int sec_num = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < first_num) {
                sec_num = first_num;
                first_num = arr[i];
            } else if (arr[i] > first_num && arr[i] < sec_num) {
                sec_num = arr[i];
            }
        }
        System.out.println((sec_num == Integer.MAX_VALUE) ? -1 : sec_num);
    }
}
