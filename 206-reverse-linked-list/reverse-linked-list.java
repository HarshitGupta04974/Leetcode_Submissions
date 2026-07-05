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
    
    //recusrive
    private static ListNode rev(ListNode temp){
        //base_case
       if(temp==null||temp.next==null)
       {
        return temp;
       }
       ListNode newH=rev(temp.next);
       ListNode front=temp.next;
       front.next=temp;
       temp.next=null;
       return newH;
    }
    public ListNode reverseList(ListNode head) {
        return rev(head);
    }
}