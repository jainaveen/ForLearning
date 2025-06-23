package Backtracking.Recursion.Medium;

public class MatrixDiagonalSum {
    public static void main(String[] args) {
        System.out.println(diagonalSum(new int[][] {{1,1,1,1}, {1,1,1,1}, {1,1,1,1},{1,1,1,1}}));

        transpose(new int[][] {{1,2,3}, {4,5,6}});
        maxi();
    }
    public static int diagonalSum(int[][] mat) {
        int len = mat.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += mat[i][i];
            sum += mat[i][len - 1 - i];
        }
        if (len % 2 != 0) {
            sum -= mat[len / 2][len / 2];
        }
        return sum;
    }

    public static int[][] transpose(int[][] matrix) {
        int[][] res = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                res[i][j] = matrix[j][i];
            }
        }
        return res;
    }

    public static void maxi() {
        int[][] logs = new int[][]{{193,199}, {200,201}};
        int[] years = new int[500];
        for(int[] log: logs) {
            years[log[0]]++;
            years[log[1]]--;
        }
    }
}
