package oneDailyQuestion.Solution0015.java;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 15. 三数之和
 * https://leetcode.cn/problems/3sum/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        //对数组排序
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < n; first++) {
            // 枚举first，重复则直接跳过
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int target = -nums[first];
            int third = n - 1;
            for (int second = first + 1; second < n - 1; second++) {
                //枚举second，重复则跳过
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 保持second指针小于third指针
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third]==target) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[first]);
                    tmp.add(nums[second]);
                    tmp.add(nums[third]);
                    ans.add(tmp);
                }
            }
        }
        return ans;
    }
}
