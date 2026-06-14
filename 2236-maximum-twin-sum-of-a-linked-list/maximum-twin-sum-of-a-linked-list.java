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
    // static ListNode l;
    // private static void func(ListNode temp,int sum[])
    // {
    //     if(temp==null)
    //     {
    //         return;
    //     }
    //     func(temp.next,sum);
    //     sum[0]=Math.max(sum[0],l.val+temp.val);
    //     l=l.next;
    //     return;}
    
    private static ListNode findmid(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private static ListNode reverse(ListNode head)
    {   ListNode prev=null;
        ListNode temp=head;
        while(temp!=null)
        {
            ListNode front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
            
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode temp=head;
        ListNode mid=findmid(temp);
        ListNode shead=reverse(mid);
        int sum=0;
        while(shead!=null)
        {
            sum=Math.max(sum,temp.val+shead.val);
            temp=temp.next;
            shead=shead.next;
        }
        return sum;       
    }
}