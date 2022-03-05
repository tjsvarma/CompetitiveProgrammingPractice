package easy.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * Constraints:
 *
 *     1 <= numRows <= 30
 *
 * Time Complexity O(n^2)
 */

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        int[][] pascalArray = new int[numRows][];

        for (int i = 0; i < numRows; i++) {
            int[] arr = new int[i+1];
            if (i == 0) {
                arr[0] = 1;
                pascalArray[0] = arr;
            } else if (i == 1) {
                arr[0] = 1;
                arr[1] = 1;
                pascalArray[1] = arr;
            } else {
                arr[0] = 1;
                arr[i] = 1;
                for (int j = 1; j <= arr.length/2; j++) {
                    arr[j] = pascalArray[i-1][j-1] + pascalArray[i-1][j];
                    arr[i-j] = arr[j];
                }
                pascalArray[i] = arr;
            }
        }

        List< List<Integer> > list = Arrays.stream(pascalArray).map(internalArray -> Arrays.stream(internalArray).boxed().collect(Collectors.toList())).collect(Collectors.toList());
        return list;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
