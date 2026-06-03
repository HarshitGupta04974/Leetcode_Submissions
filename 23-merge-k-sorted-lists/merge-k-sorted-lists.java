// public class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//       ListNode(int val) { this.val = val; }
//       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//   }
 
 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
     PriorityQueue<ListNode> heap=new PriorityQueue<>((a,b)->(a.val-b.val));
     for(ListNode l:lists)
     {
        if(l!=null){
            heap.offer(l);
        }
            
     }
     ListNode dummy=new ListNode(Integer.MIN_VALUE);
     ListNode current=dummy;
     while(!heap.isEmpty())
     {
        ListNode smallest=heap.poll();
        current.next=smallest;
        current=current.next;
        if(smallest.next!=null)
        {
            heap.offer(smallest.next);
        }
     }
     return dummy.next;
}
}