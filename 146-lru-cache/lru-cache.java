class Node
{
    int key,val;
    Node next,back;
    Node(int key,int val)
    {
        this.key=key;
        this.val=val;
    }
}
class LRUCache {
    int cap;
    HashMap<Integer,Node> mpp=new HashMap<>();
    Node head,tail;
    public LRUCache(int capacity) {
        this.cap=capacity;
        mpp=new HashMap<>();
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.back=head;
    }
    void insert(Node n)
    {
        Node temp=head.next;
        head.next=n;
        n.next=temp;
        temp.back=n;
        n.back=head;
    }
    void delete(Node n)
    {
     n.back.next=n.next;
     n.next.back=n.back;

    }
    public int get(int key) {
        if(!mpp.containsKey(key))
        {
            return -1;
        }
        Node n=mpp.get(key);
        int val=n.val;
        delete(n);
        insert(n);
        return val;
    }
    
    public void put(int key, int value) {
        if(mpp.containsKey(key))
        {   Node n=mpp.get(key);
            n.val=value;
            delete(n);
            insert(n);
        }
        else
        {
            if(mpp.size()==cap)
            {
                Node del=tail.back;
                mpp.remove(del.key);
                delete(del);
            }
            Node n=new Node(key,value);
            mpp.put(key,n);
            insert(n);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */