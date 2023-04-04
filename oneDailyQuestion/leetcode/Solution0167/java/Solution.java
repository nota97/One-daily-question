package oneDailyQuestion.Solution0167.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 167. 两数之和 II - 输入有序数组
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 */
public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(twoSum(new int[]{2, 7, 11, 15}, 9));
        int a = 3;
        String z = "";
        for (int i = 0; i < a-1; i++) {
            z+= "0";
        }
        z+="1";
        System.out.println(z);
        String currentDay = new SimpleDateFormat("yyyy").format(new Date());
        Date date = null;
        date = new SimpleDateFormat("yyyy").parse(currentDay);
        System.out.println(date);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int s = numbers[left] + numbers[right];
            if (s == target) {
                return new int[]{left + 1, right + 1};
            }
            if (s < target) {
                left++;
            }
            if (s > target) {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
