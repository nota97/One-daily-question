package oneDailyQuestion.Solution0002.java;


import java.util.ArrayList;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public List<Integer> getlist(ListNode node){
        List<Integer> lst= new ArrayList<>();
        while(node != null){
            lst.add(node.val);
            node = node.next;
        }
        System.out.println(lst);
        return lst;
    }
}

