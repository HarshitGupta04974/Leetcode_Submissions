class Solution {
    private static int help(int[][] grid,int i,int j,int dp[][])
    {
        if(i<0||j<0) return Integer.MAX_VALUE;
        if(i==0&&j==0) return grid[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=grid[i][j]+Math.min(help(grid,i-1,j,dp),help(grid,i,j-1,dp));
        
    }
    private static int tab(int [][]grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0&&j==0){
                    dp[i][j]=grid[i][j];
                }
                else{
                int up=Integer.MAX_VALUE,left=Integer.MAX_VALUE;
                if(i>0)
                {
                    up=dp[i-1][j];
                }
                if(j>0)
                {
                    left=dp[i][j-1];
                }
                dp[i][j]=grid[i][j]+Math.min(up,left);
                }
            }
        }
        return dp[n-1][m-1];

    }
    private static int space(int [][]grid)
    {       
        int n=grid.length;
        int m=grid[0].length;
        int prev[]=new int[n];
        for(int i=0;i<n;i++)
        {
            int cur[]=new int[m];
            for(int j=0;j<m;j++)
            {
                if(i==0&&j==0) cur[j]=grid[i][j];
                else{
                int up=grid[i][j];
                if(i>0) up+=prev[j];
                else up=Integer.MAX_VALUE;

                int left=grid[i][j];
                if(j>0) left+=cur[j-1];
                else left=Integer.MAX_VALUE;

                cur[j]=Math.min(left,up);
                }
            }
            prev=cur;
        }
        return prev[m-1];
    }
    public int minPathSum(int[][] grid) {
        // int n=grid.length;
        // int m=grid[0].length;
        // int dp[][]=new int[n+1][m+1];
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<m;j++)
        //     {
        //         dp[i][j]=-1;
        //     }
        // }
        // return help(grid,n-1,m-1,dp);
        // return tab(grid);
        return space(grid);
        
    }
}