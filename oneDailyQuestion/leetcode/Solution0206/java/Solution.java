package oneDailyQuestion.Solution0206.java;


import java.util.List;

/**
 * 206. 反转链表
 * https://leetcode.cn/problems/reverse-linked-list/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(reverseList1(new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5)))))));
    }


    /**
     * 迭代
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode tmp = null;
        while (cur != null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        System.out.println(ListNode.getlist(pre));
        return pre;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head){
        if (head == null || head.next ==null){
            return head;
        }
        //递归至链表末，cur头节点始终是5
        ListNode cur = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        System.out.println(ListNode.getlist(cur));
        return cur;
    }

}
