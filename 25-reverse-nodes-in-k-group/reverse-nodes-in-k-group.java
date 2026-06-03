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
    public ListNode rev(ListNode head)
    {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null)
        {
            ListNode front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
    public static ListNode findkthnode(ListNode head,int k)
    {   ListNode temp=head;
        k-=1;
        while(temp!=null && k>0)
        {
            k--;
            temp=temp.next;
        }
        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null)
        {
            ListNode kth=findkthnode(temp,k);
            if(kth==null)
            {
                if(prev!=null)prev.next=temp;
                break;
            }
            ListNode nextn=kth.next;
            kth.next=null;
            rev(temp);
            if(temp==head) head=kth;
            else prev.next=kth;

            prev=temp;
            temp=nextn;
        }
        return  head;
        
    }
}