class Solution {
    private static int help(int[][] grid,int i,int j,int dp[][])
    {
        if(i<0||j<0) return Integer.MAX_VALUE;
        if(i==0&&j==0) return grid[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=grid[i][j]+Math.min(help(grid,i-1,j,dp),help(grid,i,j-1,dp));
        
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dp[i][j]=-1;
            }
        }
        return help(grid,n-1,m-1,dp);
        
    }
}