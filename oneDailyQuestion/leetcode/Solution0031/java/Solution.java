package oneDailyQuestion.Solution0031.java;


import java.util.Arrays;

/**
 * 31. 下一个排列
 * https://leetcode.cn/problems/next-permutation/
 */
public class Solution {
    public static void main(String[] args) {
        nextPermutation(new int[]{6, 5, 3, 2, 1});
    }

    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        //倒序遍历找到首个nums[i]<nums[i+1]
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) break;
            i--;
        }
        //倒序遍历，找到首个比上面i大的数
        if (i >= 0) {
            int j = len - 1;
            while (j >= 0) {
                if (nums[j] > nums[i]) break;
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, len - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums, int left, int right) {
        int tmp = nums[right];
        nums[right] = nums[left];
        nums[left] = tmp;
    }

    public static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
