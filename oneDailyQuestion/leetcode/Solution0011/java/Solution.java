package oneDailyQuestion.Solution0011.java;


/**
 * 11. 盛最多水的容器
 * https://leetcode.cn/problems/container-with-most-water/
 * 双指针，从左右边界开始判断
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height) {
        int s = 0;
        int left = 0, right = height.length-1;
        while(right>left){
            s = Math.max(s,(right-left)*Math.min(height[left],height[right]));
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return s;
    }
}
