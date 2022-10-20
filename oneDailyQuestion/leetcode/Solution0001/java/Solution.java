package oneDailyQuestion.Solution0001.java;

import java.util.*;

/**
 * 两数之和
 * https://leetcode.cn/problems/two-sum/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15},9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
