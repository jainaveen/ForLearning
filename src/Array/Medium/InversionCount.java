package Array.Medium;

public class InversionCount {
    public static void main(String[] args) {

        long[] arr = {2, 3, 4, 5, 6};
        System.out.println(inversionCount(arr,arr.length));

        // best approach should be use Merge Sort

    }

    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        long count=0;
        for(long i=0;i<N;i++) {
            for(long j=i+1;j<N;j++) {
                if(arr[(int) i] > arr[(int)j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
