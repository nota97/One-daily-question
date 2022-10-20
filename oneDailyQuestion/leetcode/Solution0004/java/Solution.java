package oneDailyQuestion.Solution0004.java;

/**
 * 4. 寻找两个正序数组的中位数
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 * 二分查找 时间复杂度应该为 O(log (m+n))
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        if(n%2==0){
            int k = n/2, k1 = n/2+1;
            double med = (getKthElement(nums1,nums2,k)+getKthElement(nums1,nums2,k1))/2.0;
            return med;
        }else {
            int k = n/2+1;
            System.out.println(5/2);
            double med = getKthElement(nums1,nums2,k);
            return med;
        }
    }

    public static int getKthElement(int[] nums1, int[] nums2, int k){
        int n1 = nums1.length, n2 = nums2.length;
        //数组初始化索引
        int index1 = 0, index2 = 0;
        while(true){
            //判断数组是否已经遍历完成
            if (index1 == n1){
                return nums2[index2+k-1];
            }
            if (index2 == n2){
                return nums1[index1+k-1];
            }
            //当k==1时，结束，比较数组当前索引大小值，返回小的
            if(k==1){
                return Math.min(nums1[index1],nums2[index2]);
            }
            int half = k/2;
            //判断k/2与数组长度大小
            int newIndex1 = Math.min(index1+half,n1)-1;
            int newIndex2 = Math.min(index2+half,n2)-1;
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];
            if (pivot1<=pivot2){
                //除去nums1 前newIndex+1 个元素，
                k -= (newIndex1-index1+1);
                index1 = newIndex1+1;
            }else{
                k -= (newIndex2-index2+1);
                index2 = newIndex2+1;
            }
        }
    }
}
