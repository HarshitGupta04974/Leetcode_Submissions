class Solution {
    public int maxProduct(int n) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        while(n!=0)
        {
            pq.offer(n%10);
            while(pq.size()>2)
            {
                pq.poll();
            }
            n=n/10;
        }
        int a=pq.poll();
        int b=pq.poll();
        return a*b;
    }
}