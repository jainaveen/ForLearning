package Array.Medium;

import java.util.Arrays;

public class TwoSumThreeSumFourSum {
    public static void main(String[] args) {
        int[] arr = {557,217,627,358,527,358,338,272,870,362,897,23,618,113,718,697,586,42,424,130,230,566,560,933
        };
        //1,4,45,6,10,8
        System.out.println(hasArrayTwoCandidates(arr,5, 4));
        System.out.println(hasArrayTriplet(arr,5,986));
    }

    static boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        Arrays.sort(arr);
        int m=0;
        int k=arr.length-1;
        while(m<k) {
            int sum = arr[m] + arr[k];
            if(sum == x) {
                return true;
            } else if(sum < x) {
                m++;
            } else if( sum > x){
                k--;
            } else {
                return false;
            }
        }
        return false;
    }

    static boolean hasArrayTriplet(int arr[], int n, int x) {
        Arrays.sort(arr);
        for(int i = 0 ; i < n-2 ; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == x) {
                    return true;
                } else if (sum < x) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        return false;
    }
}
