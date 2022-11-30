package oneDailyQuestion.Solution0042.java;


/**
 * 42. 接雨水
 * https://leetcode.cn/problems/trapping-rain-water/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int trap(int[] height) {
        int ans = 0;
        int leftMax = 0, rightMax = 0, left = 0, right = height.length-1;
        while( left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]){
                ans += leftMax - height[left];
                left++;
            }else{
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
