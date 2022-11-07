package oneDailyQuestion.Solution0025.java;


import org.w3c.dom.ls.LSException;

/**
 * 25. K 个一组翻转链表
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5))))),2));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        while (true){
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    System.out.println(ListNode.getlist(hair.next));
                    return hair.next;
                }
            }
            ListNode cur = pre.next, tmp;
            for (int i = 0; i < k - 1; i++) {
                tmp = cur.next;
                cur.next = tmp.next;
                tmp.next = pre.next;
                pre.next = tmp;
            }
            pre = cur;
        }
    }
}
