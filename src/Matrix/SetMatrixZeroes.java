package Matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SetMatrixZeroes {

    public static void main(String[] args) {
      //  int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
     //   int[][] matrix = {{0,1}};
      //  int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        setZeroes(matrix);
    }

    public static void setZeroes(int[][] matrix) {

        int n = matrix.length, m = matrix[0].length;
        boolean firstRowZero = false, firstColZero = false;

        // Step 1: Identify if first row or first column should be zero
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Step 2: Use first row and column as markers for zeroing rows and columns
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Mark row
                    matrix[0][j] = 0; // Mark column
                }
            }
        }

        // Step 3: Set rows to zero based on markers in the first column
        for (int i = 1; i < n; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 4: Set columns to zero based on markers in the first row
        for (int j = 1; j < m; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < n; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 5: Handle first row and first column separately
        if (firstColZero) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstRowZero) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

}
