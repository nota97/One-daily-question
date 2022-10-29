package oneDailyQuestion.Solution0018.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 18. 四数之和
 * https://leetcode.cn/problems/4sum/
 * 排序+双指针
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int a = 0; a < len - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            //当数组前4位之和都大于目标值，对升序数组既都大于目标值，故直接结束
            if ((long) nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) {
                break;
            }
            //当数组首位和最后三位之和都小于目标值，移动首位
            if ((long) nums[a] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }
            for (int b = a + 1; b < len - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                if ((long) nums[a] + nums[b] + nums[b + 1] + nums[b + 2] > target) {
                    break;
                }
                if ((long) nums[a] + nums[b] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }
                //定义c,d指针
                int d = len - 1;
                int c = b + 1;
                while (c < d) {
                    //大于目标值，则移动d指针
                    if ((long) nums[a] + nums[b] + nums[c] + nums[d] > target) {
                        d--;
                    } else if ((long) nums[a] + nums[b] + nums[c] + nums[d] < target) {
                        c++;
                    } else {
                        ans.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        c++;
                        //排除重复值
                        while (c < d && nums[c] == nums[c - 1]) {
                            c++;
                        }
                        d--;
                        while (c < d && nums[d] == nums[d + 1]) {
                            d--;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
