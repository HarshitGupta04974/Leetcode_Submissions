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
    private static int tab(int m,int n)
    {
        int dp[][]=new int[m+1][n+1];
        dp[m][n]=1;
        dp[m-1][n]=1;
        dp[m][n-1]=1;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {   if(i==0&&j==0) dp[0][0]=1;
                else{
                int down=0,right=0;
                if(i>0)down=dp[i-1][j];
                if(j>0)right=dp[i][j-1];

                dp[i][j]=down+right;
                }
                
            }
        }
        return dp[m-1][n-1];
    }
    public int uniquePaths(int m, int n) {
        // int dp[][]=new int[m+1][n+1];
        // for(int i=0;i<=m;i++)
        // {
        //     for(int j=0;j<=n;j++)
        //     {
        //         dp[i][j]=-1;
        //     }
        // }
        // return dpS(0,0,m,n,dp);
        return tab(m,n);
    }
}