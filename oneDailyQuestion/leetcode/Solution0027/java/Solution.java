package oneDailyQuestion.Solution0027.java;


import java.util.Arrays;

/**
 * 27. 移除元素
 * https://leetcode.cn/problems/remove-element/
 */
public class Solution {
    public static void main(String[] args) {
        removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
    }

    public static int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(slow);
        return slow;
    }
}
