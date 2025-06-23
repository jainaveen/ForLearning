package Array.Easy;

public class ThirdLargest {
    public static void main(String[] args) {
        int[] arr = {2,4,1,3,5};
        thirdLargest(arr);
    }

    static void thirdLargest(int[] arr) {
        // selection sort
        int first=0;
        int second=0;
        int third=0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if(num > first) {
                third = second;
                second = first;
                first = num;
            } else if (first > num && num > second) {
                third = second;
                second = num;
            } else if (second > num && num > third) {
                third = num;
            }
        }
        System.out.println("Third largest " + third);
    }
}
