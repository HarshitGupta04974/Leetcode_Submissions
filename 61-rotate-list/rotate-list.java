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
    private static ListNode findKthNode(ListNode head,int k)
    {   ListNode temp=head;
        while(temp!=null)
        {
            if(k==0) return  temp;
            k--;
            temp=temp.next;
        }
        return temp;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int len=1;
        ListNode tail=head;
        while(tail.next!=null)
        {
            len++;
            tail=tail.next;
        }
        k=k%len;
        if(k==0) return head;
        tail.next=head;
        ListNode kth=findKthNode(head,len-k-1);
        ListNode newH=kth.next;
        kth.next=null;
        return newH;
    }
}