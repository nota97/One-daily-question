package oneDailyQuestion.Solution0006.java;


/**
 * 6. Z 字形变换
 * https://leetcode.cn/problems/zigzag-conversion/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(convert1("PAYPALISHIRING", 4));
    }

    public static String convert(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (n == 1 || r == 1 || r >= n) {
            return s;
        }
        int t = 2 * r - 2;
        //math.ceil() 向上取整 ，原式为n / t * (r - 1)，为了向上取整做调整
        int c = (n + t - 1) / t * (r - 1);
        char[][] chars = new char[r][c];
        for (int i = 0, x = 0, y = 0; i < n; i++) {
            chars[x][y] = s.charAt(i);
            if (i % t < r - 1) {
                x++;
            } else {
                x--;
                y++;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char[] item : chars) {
            for (char a : item) {
                if (a != 0) {
                    ans.append(a);
                }
            }
        }
        return ans.toString();
    }

    /**
     * 优化压缩矩阵空间
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert1(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (n == 1 || r == 1 || r >= n) {
            return s;
        }
        int t = 2 * r - 2;
        //math.ceil() 向上取整 ，原式为n / t * (r - 1)，为了向上取整做调整
        int c = (n + t - 1) / t * (r - 1);
        StringBuilder[] stringBuilder = new StringBuilder[r];
        for (int i = 0; i < r; i++) {
            stringBuilder[i] = new StringBuilder();
        }
        for (int i = 0, x = 0; i < n; i++) {
            stringBuilder[x].append(s.charAt(i));
            if (i % t < r - 1) {
                x++;
            } else {
                x--;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder item : stringBuilder) {
            ans.append(item);
        }
        return ans.toString();
    }

}
