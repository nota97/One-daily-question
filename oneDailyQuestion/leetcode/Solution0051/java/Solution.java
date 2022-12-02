package oneDailyQuestion.Solution0051.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] str : board) {
            Arrays.fill(str, '.');
        }
        rollback(ans, board, 0);
        return ans;
    }

    public static void rollback(List<List<String>> ans, char[][] board, int row) {
        if (row == board.length) {
            ans.add(Arrays.stream(board).map(String::valueOf).collect(Collectors.toList()));
            return;
        }
        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            rollback(ans, board, row + 1);
            board[row][col] = '.';
        }
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
