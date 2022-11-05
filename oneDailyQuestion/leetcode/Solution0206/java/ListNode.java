package oneDailyQuestion.Solution0206.java;


import java.util.ArrayList;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static List<Integer> getlist(ListNode node){
        List<Integer> lst= new ArrayList<>();
        while(node!= null){
            lst.add(node.val);
            node = node.next;
        }
        return lst;
    }
}

