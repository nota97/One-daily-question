package oneDailyQuestion.Solution0086.java;


/**
 * 86. 分隔链表
 * https://leetcode.cn/problems/partition-list/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(partition(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2,
                new ListNode(5, new ListNode(2)))))),3));
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode smallList = new ListNode(0);
        ListNode largeList = new ListNode(0);
        ListNode smallTmp = smallList;
        ListNode largeTmp = largeList;
        while (head != null){
            if (head.val < x){
                smallTmp.next = head;
                smallTmp = smallTmp.next;
            }else{
                largeTmp.next = head;
                largeTmp = largeTmp.next;
            }
            head = head.next;
        }
        largeTmp.next = null;
        smallTmp.next = largeList.next;
        System.out.println(ListNode.getlist(smallList.next));
        return smallList.next;
    }
}
