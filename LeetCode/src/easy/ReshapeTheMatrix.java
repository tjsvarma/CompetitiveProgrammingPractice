package easy;

/**
 * In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
 * You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.
 * The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 *
 * Example 1:
 * Input: mat = [[1,2],[3,4]], r = 1, c = 4
 * Output: [[1,2,3,4]]
 *
 * Constraints:
 *
 *     m == mat.length
 *     n == mat[i].length
 *     1 <= m, n <= 100
 *     -1000 <= mat[i][j] <= 1000
 *     1 <= r, c <= 300
 *
 * Time Complexity O(n^2)
 */

public class ReshapeTheMatrix {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        if ((m*n) == (r*c)) {
            int[][] newMat= new int[r][c];
            int k = 0;
            int l = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (k == r) {
                        k = 0;
                    }
                    if (l == c) {
                        l = 0;
                        k++;
                    }
                    newMat[k][l++] = mat[i][j];
                }
            }
            return newMat;
        } else {
            return mat;
        }
    }

    public static void main(String[] args) {
        int[][] mat = new int[][] {{1,2},{3,4}};
        int r = 1;
        int c = 4;
        System.out.println(matrixReshape(mat, r, c));
    }
}
