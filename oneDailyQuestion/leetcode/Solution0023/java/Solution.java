package oneDailyQuestion.Solution0023.java;


/**
 * 23. 合并K个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(mergeKLists(new ListNode[]{new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))}));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) {
            return null;
        }
        while (k > 1) {
            int index = 0;
            for (int i = 0; i < k; i += 2) {
                if (i == k - 1) {
                    lists[index] = lists[i];
                } else {
                    lists[index] = mergeTwoLists(lists[i], lists[i + 1]);
                }
                index++;
            }
            k = index;
        }
        System.out.println(ListNode.getlist(lists[0]));
        return lists[0];
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(0);
        ListNode pre = ans;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
                pre = pre.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
                pre = pre.next;
            }
        }
        pre.next = list1 == null ? list2 : list1;
        return ans.next;
    }
}
