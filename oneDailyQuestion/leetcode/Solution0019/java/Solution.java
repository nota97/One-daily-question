package oneDailyQuestion.Solution0019.java;


/**
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(removeNthFromEnd(new ListNode(1,
                        new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),
                1));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        //快慢指针
        ListNode p = pre, q = pre;
        System.out.println(ListNode.getlist(pre));
        for (int i = 0; i < n+1 ; i++) {
            q = q.next;
        }
        while (q.next != null) {
            q = q.next;
            p = p.next;
        }
        p.next = p.next.next;
        System.out.println(ListNode.getlist(pre.next));
        return pre.next;
    }
}
