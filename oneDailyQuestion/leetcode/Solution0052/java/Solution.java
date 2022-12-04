package oneDailyQuestion.Solution0052.java;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 52. N皇后 II
 * https://leetcode.cn/problems/n-queens-ii/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }

    public static int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] str : board) {
            Arrays.fill(str, '.');
        }
        return rollback(board, 0);
    }

    public static int rollback(char[][] board, int row) {
        if (row == board.length) {
            return 1;
        }
        int n = board[row].length;
        int count = 0;
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            count+=rollback(board, row + 1);
            board[row][col] = '.';
        }
        return count;
    }

    public static boolean isValid(char[][] board, int row, int col) {
        int n = board[row].length;
        //判断列是否存在Q
        for (int i = 0; i <= row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //判断左上方是存在Q
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //判断右上方是否存在Q
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
