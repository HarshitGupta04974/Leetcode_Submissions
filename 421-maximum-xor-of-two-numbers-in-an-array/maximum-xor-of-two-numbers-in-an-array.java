class Node
{
    Node links[]=new Node[2];
    boolean containsKey(int bit)
    {
        return (links[bit]!=null);
    }
    Node get(int bit)
    {
        return (links[bit]);
    }
    void put(int bit,Node node)
    {
        links[bit]=node;
    }
}
class Trie{
    Node root;
    Trie()
    {
        root=new Node();
    }
    void insert(int num)
    {
        Node temp=root;
        for(int i=31;i>=0;i--)
        {
            int set=(num>>i)&1;
            if(!temp.containsKey(set))
            {
                temp.put(set,new Node());
            }
            temp=temp.get(set);
        }
    }
    int getMax(int num)
    {
        Node temp=root;
        int max=0;
        for(int i=31;i>=0;i--)
        {
            int bit=(num>>i)&1;
            if(temp.containsKey(1-bit))
            {
                max=max|1<<i;
                temp=temp.get(1-bit);
            }
            else{
                temp=temp.get(bit);
            }
        }
        return max;
    }

}
class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie t=new Trie();
        int ans=Integer.MIN_VALUE;
        for(int i:nums)
        {
            t.insert(i);
        }
        for(int i:nums)
        {
            ans=Math.max(t.getMax(i),ans);
        }
        return ans;
    }
}