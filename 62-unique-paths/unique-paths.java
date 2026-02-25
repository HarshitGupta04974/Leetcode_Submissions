class Solution {
    // private static int help(int x,int y,int m,int n)
    // {
    //     if(x>=m||y>=n)
    //     {
    //         return 0;
    //     }
    //     if(x==m-1&&y==n-1)
    //     {
    //         return 1;
    //     }
    //     // only down
    //     int down=0,right=0;
    //     if(x+1<m)
    //     {
    //         down=help(x+1,y,m,n);
    //     }
    //     if(y+1<n)
    //     {
    //         right=help(x,y+1,m,n);
    //     }
    //     return (down+right);
    // }

    private static int dpS(int x,int y,int m,int n,int dp[][])
    {
        if(x>=m||y>=n)
        {
            return 0;
        }
        if(x==m-1&&y==n-1)
        {
            return 1;
        }
        int down=0,right=0;
        // only down
        if(dp[x][y]!=-1) return dp[x][y];
        if(x+1<m)
        {
            down=dpS(x+1,y,m,n,dp);
        }
        if(y+1<n)
        {
            right=dpS(x,y+1,m,n,dp);
        }
        return dp[x][y]=down+right;
    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                dp[i][j]=-1;
            }
        }
        return dpS(0,0,m,n,dp);
    }
}