package oneDailyQuestion.Solution0021.java;


/**
 * 21. 合并两个有序链表
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 */
public class Solution {
    public static void main(String[] args) {
        mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(1, new ListNode(3, new ListNode(4))));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(0);
        ListNode pre = ans;
        while (list1!=null && list2!=null){
            if (list1.val < list2.val){
                pre.next = list1;
                list1 = list1.next;
                pre = pre.next;
            }else{
                pre.next = list2;
                list2 = list2.next;
                pre = pre.next;
            }
        }
        pre.next = list1 == null ? list2 : list1;
        System.out.println(ListNode.getlist(ans.next));
        return ans.next;
    }
}