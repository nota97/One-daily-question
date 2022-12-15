package oneDailyQuestion.Solution0045.java;


/**
 * 45. 跳跃游戏 II
 * https://leetcode.cn/problems/jump-game-ii/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }

    public static int jump(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int rightMax = 0;
        int end = 0;
        for (int i = 0; i < n-1; i++) {
            // 获取单次可跳最远距离
            rightMax = Math.max(rightMax, nums[i]+i);
            if (i == end){
                end = rightMax;
                ans++;
            }
        }
        return ans;
    }
}
