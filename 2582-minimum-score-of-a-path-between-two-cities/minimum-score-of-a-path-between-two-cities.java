class Solution {
    private static void dfs(int node,ArrayList<ArrayList<int[]>>adj,int ans[],boolean vis[])
    {
        vis[node]=true;
        for(int i[]:adj.get(node))
        {
            ans[0]=Math.min(ans[0],i[1]);
            if(!vis[i[0]])
            {
                dfs(i[0],adj,ans,vis);
            }
        }
    }

    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n+1;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++)
        {
            int u=roads[i][0];
            int v=roads[i][1];
            int wt=roads[i][2];
            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }
        boolean vis[]=new boolean[n+1];
        int ans[]=new int[]{Integer.MAX_VALUE};
        dfs(1,adj,ans,vis);
        return ans[0];
    }
}