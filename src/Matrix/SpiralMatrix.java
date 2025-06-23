package Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        //https://leetcode.com/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-interview-150

        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));


        //Spiral matrix II problem -  https://leetcode.com/problems/spiral-matrix-ii/description/
        int n = 4;
        System.out.println(Arrays.deepToString(spiralMatrixII(n)));
    }

    public static int[][] spiralMatrixII(int n) {
        int rowBegin = 0;
        int rowEnd = n-1;
        int colBegin = 0;
        int colEnd = n-1;
        int[][] matrix = new int[n][n];
        int num = 1;

        while(rowBegin<=rowEnd && colBegin<=colEnd) {
            for(int i =colBegin; i<=colEnd;i++) {
                matrix[rowBegin][i] = num++;
            }
            rowBegin++;

            for (int i = rowBegin; i <= rowEnd ; i++) {
                matrix[i][colEnd] = num++;
            }
            colEnd--;

            //if(rowBegin<=rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    matrix[rowEnd][i] = num++;
                }
            //}
            rowEnd--;

        //    if(colBegin<=colEnd) {
                for (int i = rowEnd; i >=rowBegin ; i--) {
                    matrix[i][colBegin] = num++;
                }
        //    }
            colBegin++;
        }
        return matrix;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length-1;

        while(rowBegin<=rowEnd && colBegin<=colEnd) {
            // traverse right
            for (int i = colBegin; i <= colEnd; i++) {
                list.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            //traverse down
            for (int i = rowBegin; i <= rowEnd; i++) {
                list.add(matrix[i][colEnd]);
            }
            colEnd--;

            //traverse left
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    list.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            //traverse up
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    list.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        return list;

    }
}
