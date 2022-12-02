package oneDailyQuestion.Solution0039.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 39. 组合总和
 * https://leetcode.cn/problems/combination-sum/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);
        rollback(ans, tmp, candidates, target, 0, 0);
        return ans;
    }

    public static void rollback(List<List<Integer>> ans, List<Integer> tmp, int[] candidates, int target, int sum, int begin) {
        if (sum == target) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            int res = sum + candidates[i];
            if (res <= target) {
                tmp.add(candidates[i]);
                rollback(ans, tmp, candidates, target, res, i);
                tmp.remove(tmp.size() - 1);
            } else {
                break;
            }
        }
    }
}
