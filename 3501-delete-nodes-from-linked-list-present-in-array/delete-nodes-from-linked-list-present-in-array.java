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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> st=new HashSet<>();
        for(int i:nums) st.add(i);

        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=head,prev=dummy;
        while(cur!=null){
            if(st.contains(cur.val)){
                prev.next=cur.next;
            }
            else{
                prev=cur;
            }
            cur=cur.next;
        }
        return dummy.next;
    }
}