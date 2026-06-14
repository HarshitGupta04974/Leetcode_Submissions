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
    static ListNode l;
    private static void func(ListNode temp,int sum[])
    {
        if(temp==null)
        {
            return;
        }
        func(temp.next,sum);
        sum[0]=Math.max(sum[0],l.val+temp.val);
        l=l.next;
        return;
    }
    public int pairSum(ListNode head) {
        l=head;
        ListNode temp=head;
        int sum[]=new int[1];
        sum[0]=Integer.MIN_VALUE;
        func(temp,sum);
        return sum[0];
    }
}