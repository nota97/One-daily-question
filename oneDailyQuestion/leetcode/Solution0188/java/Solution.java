package oneDailyQuestion.Solution0188.java;


/**
 * 188. 买卖股票的最佳时机 IV
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[]{3,2,6,5,0,3}));
    }

    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        //买入，卖出即为一次，当交易次数大于此，就无限制意义
        if (k > n/2){
            return maxProfit_k_inf(prices);
        }
        int dp_i_0[] = new int[k+1], dp_i_1[] = new int[k+1];
        dp_i_0[0] = 0;
        dp_i_1[0] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = k; j >=1 ; j--) {
                if (i -1 == -1){
                    dp_i_0[j] = 0;
                    dp_i_1[j] = -prices[i];
                }
                dp_i_0[j] = Math.max(dp_i_0[j], dp_i_1[j] + prices[i]);
                dp_i_1[j] = Math.max(dp_i_1[j], dp_i_0[j - 1] - prices[i]);
            }
        }
        return dp_i_0[k];
    }

    public static int maxProfit_k_inf(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i]);
        }
        return dp_i_0;
    }
}
