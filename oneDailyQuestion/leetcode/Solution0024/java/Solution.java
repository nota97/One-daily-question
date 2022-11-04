package oneDailyQuestion.Solution0024.java;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(swapPairs(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))))));
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode pre = ans;
        while (pre.next != null && pre.next.next != null){
            ListNode node1 = pre.next;
            ListNode node2 = pre.next.next;
            pre.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            pre = node1;
        }
        System.out.println(ListNode.getlist(ans));
        return ans.next;
    }
}
