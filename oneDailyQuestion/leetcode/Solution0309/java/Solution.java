package oneDailyQuestion.Solution0309.java;


/**
 * 309. 最佳买卖股票时机含冷冻期
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,0,2}));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int d_i_0 = 0, d_i_1 = Integer.MIN_VALUE;
        int d_pre = 0;
        for (int i = 0; i < n; i++) {
            int tmp = d_i_0;
            d_i_0 = Math.max(d_i_0, d_i_1 + prices[i]);
            d_i_1 = Math.max(d_i_1, d_pre - prices[i]);
            d_pre = tmp;
        }
        return d_i_0;
    }
}
