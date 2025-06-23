package String.Hard;

public class isCircle {

    public static void main(String[] args) {
        String A[] = { "afovqrwkiu", "uixmfqpwkz", "zyfkmrrfpn" };
        System.out.println(isCircle(A.length,A));
    }

    static int isCircle(int N, String A[])
    {
        // code here

        for (int i = 0; i <A.length-1; i++) {
            boolean flag = false;
            String in = A[i];
            for (int j = i+1; j < A.length; j++) {
                if(in.substring(in.length()-1).startsWith(A[j].substring(0,1))) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                return 0;
            }
        }
        return 1;
    }
}
