package oneDailyQuestion.Solution0040.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 40. 组合总和 II
 * https://leetcode.cn/problems/combination-sum-ii/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);
        rollback(ans, tmp, candidates, target, 0, 0);
        return ans;
    }

    public static void rollback(List<List<Integer>> ans, List<Integer> tmp, int[] candidates, int target, int sum, int begin){
        int n = candidates.length;
        if (target == sum){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = begin; i < n; i++) {
            if (i > begin && candidates[i] == candidates[i-1]){
                continue;
            }
            int res = sum+ candidates[i];
            if (res <= target){
                tmp.add(candidates[i]);
                rollback(ans, tmp, candidates, target, res, i+1);
                tmp.remove(tmp.size()-1);
            }else{
                break;
            }
        }
    }
}
