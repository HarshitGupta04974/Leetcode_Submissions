class Solution {
    private static void dfs(int node,int[][] adj,boolean visited[]){
        visited[node]=true;
        for(int i=0;i<adj.length;i++){
            if(adj[node][i]==1&&!visited[i]){
                dfs(i,adj,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
   
        int n=isConnected.length;
        boolean visited[]=new boolean[n];
        int ckt=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                ckt++;
                dfs(i,isConnected,visited);
            }
        }
        return ckt;
    }
}