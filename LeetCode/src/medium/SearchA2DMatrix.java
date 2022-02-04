package medium;

/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 *     Integers in each row are sorted from left to right.
 *     The first integer of each row is greater than the last integer of the previous row.
 *
 * Example 1:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 *
 * Constraints:
 *
 *     m == matrix.length
 *     n == matrix[i].length
 *     1 <= m, n <= 100
 *     -10^4 <= matrix[i][j], target <= 10^4
 */

public class SearchA2DMatrix {

    /**
     * Brute force solution
     * Can be optimised using binarySearch on the row in which the potential value may be present
     *
     * Time Complexity before optimization O(n^2)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int mSize = matrix.length;
        int nSize = matrix[0].length;
        for (int i = 0; i < mSize; i++) {
            for (int j = 0; j < nSize; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
