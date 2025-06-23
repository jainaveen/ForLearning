package Array.Easy;

import java.util.Arrays;

import static java.util.Collections.swap;

public class ArrayOfZeros {

    public static void main(String[] args) {
        Integer array[] = {1,1,0,1,0 };
        ///-> output : [0,0,1,1,1]
      //  Arrays.sort(array);
       // System.out.println(Arrays.asList(array));
        //Traditional approach
       System.out.println(Arrays.toString(swap(array)));
       System.out.println(swap2(array));


    }

    private static String swap2(Integer[] array) {
        int a = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == 0) {
                int temp = array[i];
                array[i] = array[a];
                array[a] = temp;
                a++;
            }
        }
        return Arrays.toString(array);
    }

    private static int[] swap(Integer array[]) {
        int[] arr = new int[array.length];
        int i =0;
        int k = array.length-1;
        for (int j = 0; j < array.length; j++) {
            if(array[j] == 1) {
                arr[k] = 1;
                k--;
            } else{
                arr[i++] = 0;
            }

        }
        return arr;
    }
}
