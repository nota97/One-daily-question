package oneDailyQuestion.Solution0322.java;


import java.util.Arrays;

/**
 * 322. 零钱兑换
 * https://leetcode.cn/problems/coin-change/
 */
public class Solution {
    public static int[] demo;
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        demo = new int[amount+1];
        Arrays.fill(demo, -666);
        return dp(coins, amount);
    }

    public static int dp(int[] coins, int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        if (demo[n]!=-666){
            return demo[n];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = dp(coins, n - coin);
            if (sub == -1) {
                continue;
            }
            res = Math.min(res, sub + 1);
        }
        demo[n] = res == Integer.MAX_VALUE ? -1 : res;
        return demo[n];
    }
}
