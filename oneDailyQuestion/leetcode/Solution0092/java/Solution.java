package oneDailyQuestion.Solution0092.java;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5))))),2, 4);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode ans = new ListNode(0, head);
        ListNode pre = ans;

        for (int i = 0; i < left-1; i++) {
            pre = pre.next;
        }
        // 记录待反转的第一个节点left
        ListNode cur = pre.next;
        // 记录待反转的下一个节点
        ListNode nex = null;
        for (int i = 0; i < right - left; i++) {
            nex = cur.next;
            cur.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;

        }
        System.out.println(ListNode.getlist(ans.next));
        return ans.next;
    }
}
