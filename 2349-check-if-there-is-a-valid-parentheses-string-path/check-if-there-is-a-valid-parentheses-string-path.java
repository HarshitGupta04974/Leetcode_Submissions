class Solution {
    private static boolean func(int row,int col,char[][]grid,int balance,Boolean dp[][][])
    {
        if(row<0||col<0) return false;
       if(grid[row][col]=='(') balance-=1;
       else balance+=1;
       if(row==0&&col==0)
       {
        return balance==0;
       }
       if(balance<0) return false;
       if(dp[row][col][balance]!=null) return dp[row][col][balance];
       boolean up=func(row-1,col,grid,balance,dp);
       boolean left=func(row,col-1,grid,balance,dp);
       return dp[row][col][balance]=up||left;
    }
    public boolean hasValidPath(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Boolean dp[][][]=new Boolean[m][n][m+n+1];
        return func(m-1,n-1,grid,0,dp);
    }
}