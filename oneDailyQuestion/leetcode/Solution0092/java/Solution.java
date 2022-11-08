package oneDailyQuestion.Solution0092.java;


/**
 * 92. 反转链表 II
 * https://leetcode.cn/problems/reverse-linked-list-ii/
 * curr：指向待反转区域的第一个节点 left；
 * next：永远指向 curr 的下一个节点，循环过程中，curr 变化以后 next 会变化；
 * pre：永远指向待反转区域的第一个节点 left 的前一个节点，在循环过程中不变。
 */
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
