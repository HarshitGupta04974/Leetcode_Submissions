class Solution {
    private boolean dfs(char[][]grid,boolean vis[][],int r,int c,int pr,int pc)
    {
        vis[r][c]=true;
        int n=grid.length;
        int m=grid[0].length;
        int dx[]={0,1,0,-1};
        int dy[]={1,0,-1,0};
        for(int i=0;i<4;i++)
        {
            int newr=r+dx[i];
            int newc=c+dy[i];
            if(newr<0||newr>=n||newc<0||newc>=m) continue;
            if(grid[newr][newc]!=grid[r][c]) continue;
            if(vis[newr][newc]&&newr!=pr&&newc!=pc) return true;
            if(!vis[newr][newc])
            {
                if(dfs(grid,vis,newr,newc,r,c)) return true;
            }
        }
        return false;
    }
    public boolean containsCycle(char[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!vis[i][j])
                {
                    if(dfs(grid,vis,i,j,-1,-1)) return true;
                }
            }
        }    
        return false;
    }
}