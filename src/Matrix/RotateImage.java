package Matrix;

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6},{7,8,9}};

        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                if(j >= i) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix.length-1;
            while(left <= right) {
                int temp = matrix[i][right];
                matrix[i][right] = matrix[i][left];
                matrix[i][left] = temp;
                left++;
                right--;
            }
        }
    }
}
