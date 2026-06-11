class Solution {
    private static final long MOD=1_000_000_007L;
    private int maxdepth=0;
    public int assignEdgeWeights(int[][] edges) {
        int n=edges.length+1;
        ArrayList<Integer>[] graph=new ArrayList[n+1];
        for(int i=0;i<=n;i++)
        {
            graph[i]=new ArrayList<>();
        }
        for(int i[]:edges)
        {
            graph[i[0]].add(i[1]);
            graph[i[1]].add(i[0]);

        }
        dfs(1,0,0,graph);
        if(maxdepth==0)
        {
            return 0;
        }
        return (int)pow(2,maxdepth-1);

    }
    private  void dfs(int node,int parent,int depth,ArrayList<Integer>[] graph)
    {
        maxdepth=Math.max(depth,maxdepth);
        for(int nei:graph[node])
        {
            if(nei!=parent)
            {
                dfs(nei,node,depth+1,graph);
            }
        }
    }
    private static long pow(long base,long expo)
    {
        long res=1;
        while(expo>0)
        {
            if((expo&1)==1)
            {
                res=(res*base)%MOD;
            }
            base=(base*base)%MOD;
            expo>>=1;
        }
        return res;
    }
}