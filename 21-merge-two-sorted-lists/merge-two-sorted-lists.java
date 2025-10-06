/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(-1);
        ListNode temp1=list1;
        ListNode temp2=list2;
        if(temp1==null){
            return list2;
        }
        if(temp2==null){
            return list1;
        }
        ListNode t=dummy;
        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                 t.next=temp1;
                 t=t.next;
                temp1=temp1.next;
            }
            else{
                t.next=temp2;
                t=t.next;
                temp2=temp2.next;
            }
        }
        while(temp1!=null){
            t.next=temp1;
            t=t.next;
            temp1=temp1.next;
        }
        while(temp2!=null){
            t.next=temp2;
            t=t.next;
            temp2=temp2.next;
        }
        return dummy.next;
    }
}