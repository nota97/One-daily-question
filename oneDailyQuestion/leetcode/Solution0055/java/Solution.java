package oneDailyQuestion.Solution0055.java;

/**
 * 55. 跳跃游戏
 * https://leetcode.cn/problems/jump-game/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int right = 0;
        for (int i = 0; i < n; i++) {
            if (i <= right) {
                right = Math.max(right, nums[i] + i);
                if (right >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
