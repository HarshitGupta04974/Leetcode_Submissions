class Solution {
    private static int func(int i,int j,int grid[][],int dp[][])
    {
        if(i<0||j<0)  return (int)1e9;
        if(i==0&&j==0)
        {
            return grid[0][0];
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int up,right;
        up=grid[i][j]+func(i-1,j,grid,dp);
        right=grid[i][j]+func(i,j-1,grid,dp);
        return dp[i][j]=Math.min(up,right);
    }
    
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][]=new int[n][m];
        for(int rows[]:dp)
        {
            Arrays.fill(rows,-1);
        }
        return func(n-1,m-1,grid,dp);
    }
}