class Solution {
    public int countPaths(int n, int[][] roads) 
    {
        ArrayList<ArrayList<int []>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i[]:roads)
        {
            adj.get(i[0]).add(new int[]{i[1],i[2]});
            adj.get(i[1]).add(new int[]{i[0],i[2]});
        }
        PriorityQueue<long[]> pq =new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        long dist[]=new long[n];
        int ways[]=new int[n];

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;    
        pq.offer(new long[]{0, 0});
        ways[0]=1;
        int mod=(int)(1e9+7);
        while(!pq.isEmpty())
        {
            long temp[]=pq.poll();
            long wt=temp[0];
            int node=(int)temp[1];
  
            for(int[] it:adj.get(node))
            {
                int adjN=it[0];
                long adjWt=it[1];
                if(wt+adjWt<dist[adjN])
                {
                    dist[adjN]=wt+adjWt;
                    pq.offer(new long[]{dist[adjN],adjN});
                    ways[adjN]=ways[node];
                }
                else if(wt+adjWt==dist[adjN])
                {
                    ways[adjN]=(ways[adjN]+ways[node])%mod;
                }
            }
        }
        return ways[n-1];
    }
}