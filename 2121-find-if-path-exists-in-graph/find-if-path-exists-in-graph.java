class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] i:edges){
           adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        boolean visited[]=new boolean[n];
        dfs(source,visited,adj);
        return visited[destination];
    }
    private static void dfs(int src,boolean []visited,ArrayList<ArrayList<Integer>> adj){
        visited[src]=true;
        ArrayList<Integer> l=adj.get(src);
        for(int i:l){
            if(!visited[i]){
                dfs(i,visited,adj);
            }
        }
    }
}