class Solution {
    private static void dfs(int node,List<List<Integer>> ls,boolean sus[])
    {
        if(sus[node]) return;
        sus[node]=true;
        for(Integer i:ls.get(node))
        {
            dfs(i,ls,sus);
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int edge[]:invocations)
        {
            adj.get(edge[0]).add(edge[1]);
        }
        boolean sus[]=new boolean[n];
        dfs(k,adj,sus);
        List<Integer> ans=new ArrayList<>();
        for(int edge[]:invocations)
        {
            int u=edge[0];
            int v=edge[1];
            if(!sus[u]&&sus[v])
            {
                for(int i=0;i<n;i++) ans.add(i);

                return ans;
            }
        }
        for(int i=0;i<n;i++)
        {
            if(!sus[i]) ans.add(i);
        }
        return ans;
    }
}