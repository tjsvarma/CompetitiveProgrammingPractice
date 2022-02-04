package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 *     Each row must contain the digits 1-9 without repetition.
 *     Each column must contain the digits 1-9 without repetition.
 *     Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Note:
 *
 *     A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 *     Only the filled cells need to be validated according to the mentioned rules.
 *
 * Example 1:
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 *
 * Constraints:
 *
 *     board.length == 9
 *     board[i].length == 9
 *     board[i][j] is a digit 1-9 or '.'.
 *
 * Time Complexity O(n^4)
 *
 * External Link: https://www.geeksforgeeks.org/check-if-given-sudoku-board-configuration-is-valid-or-not/
 */

/**
 * Brute force approach
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        return checkRow(board) && checkColumn(board) && checkSubBlocks(board);
    }

    private boolean checkRow(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = j+1; k < 9; k++) {
                    if ((board[i][j] != '.') && (board[i][j] == board[i][k])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkColumn(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = j+1; k < 9; k++) {
                    if ((board[j][i] != '.') && (board[j][i] == board[k][i])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkSubBlocks(char[][] board) {
        for (int i = 3; i <= 9; i=i+3) {
            for (int j = 3; j <= 9; j=j+3) {
                Set<Character> set = new HashSet<>();
                for (int k = i-3; k < i; k++) {
                    for (int l = j-3; l < j; l++) {
                        if (board[k][l] != '.' && !set.add(board[k][l])) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

/**
 * Optimised approach
 */
class ValidSudokuOptimised {
    public boolean isValidSudoku(char[][] board) {
        return checkRowColumn(board) && checkSubBlocks(board);
    }

    private boolean checkRowColumn(char[][] board) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> columnSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (board[i][j] != '.' && !rowSet.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !columnSet.add(board[j][i])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkSubBlocks(char[][] board) {
        int size = board.length;
        for (int i = 3; i <= size; i=i+3) {
            for (int j = 3; j <= size; j=j+3) {
                Set<Character> set = new HashSet<>();
                for (int k = i-3; k < i; k++) {
                    for (int l = j-3; l < j; l++) {
                        if (board[k][l] != '.' && !set.add(board[k][l])) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
