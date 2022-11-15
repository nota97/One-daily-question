package oneDailyQuestion.Solution0034.java;


import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 7, 7, 8, 8, 10}, 7)));
    }

    public static int[] searchRange(int[] nums, int target) {
        //找到首个>= target的下标
        int lIndex = binarySearch(nums, target);
        //找到首个>target的下标
        int rIndex = binarySearch(nums, target + 1);
        if (lIndex == nums.length || nums[lIndex] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{lIndex, rIndex - 1};
    }

    public static int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
