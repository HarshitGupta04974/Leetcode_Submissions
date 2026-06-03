/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public void insertnode(Node head)
    {
        Node temp=head;
        while(temp!=null)
        {
            Node newn=new Node(temp.val);
            newn.next=temp.next;
            temp.next=newn;
            temp=newn.next;
        }
    }
    public void randomconnect(Node head)
    {
        Node temp=head;
        while(temp!=null)
        {  Node copy=temp.next;
            if(temp.random!=null)
            {
               copy.random=temp.random.next;
            }
            else{
                copy.random=null;
            }
            temp=temp.next.next;
        }
    }
    public Node getdeepcopy(Node head)
    {
        Node dummy=new Node(-1);
        Node res=dummy;
        Node temp=head;
        while(temp!=null)
        {
            Node copy=temp.next;
            res.next=copy;
            res=copy;
            temp.next=temp.next.next;
            temp=temp.next;
        }
        return dummy.next;
    }
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        insertnode(head);
        randomconnect(head);
        return getdeepcopy(head);         
    }
}