package oneDailyQuestion.Solution0002.java;

/**
 * 2. 两数相加
 * https://leetcode.cn/problems/add-two-numbers/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(addTwoNumbers(new ListNode(2, new ListNode(4,new ListNode(3)))
                ,new ListNode(5,new ListNode(6,new ListNode(4)))));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode cur = node;
        int ans = 0, carry = 0;
        while(l1!=null || l2!=null){
            //判断l1,l2是否为null，是则赋值为0，否则获取val值
            int n1 = l1 != null? l1.val: 0;
            int n2 = l2 != null? l2.val: 0;
            ans = n1 + n2 + carry ;
            carry = ans / 10;
            ans = ans % 10;
            cur.next = new ListNode(ans);
            cur = cur.next;
            System.out.println(ans);
            node.getlist(node);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry==1){
            cur.next=new ListNode(carry);
        }

        return node.next;
    }
}
