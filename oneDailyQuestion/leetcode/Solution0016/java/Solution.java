package oneDailyQuestion.Solution0016.java;


import java.util.Arrays;
import java.util.Map;

/**
 * 16. 最接近的三数之和
 * https://leetcode.cn/problems/3sum-closest/
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0, 0, 0}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int first = 0; first < n - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1, third = n - 1;
            while (second < third) {
                int s = nums[first] + nums[second] + nums[third];
                if (s == target) {
                    return s;
                }
                if (Math.abs(s - target) < Math.abs(ans - target)) {
                    ans = s;
                }
                if (s >target){
                    third--;
                    while (second<third && nums[third]==nums[third+1]){
                        third--;
                    }
                }else{
                    second++;
                    while (second<third && nums[second]==nums[second-1]){
                        second++;
                    }
                }

            }
        }
        return ans;
    }
}