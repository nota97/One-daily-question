package oneDailyQuestion.Solution0026.java;


/**
 * 26. 删除有序数组中的重复项
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 */
public class Solution {
    public static void main(String[] args) {
        removeDuplicates(new int[]{1,2,2});
    }

    public static int removeDuplicates(int[] nums) {
        int slow = 1, fast = 1;
        while (fast < nums.length){
            // 快慢指针，slow用于保存不同值，保存后向前移动一位
            if (nums[fast] != nums[fast-1]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
