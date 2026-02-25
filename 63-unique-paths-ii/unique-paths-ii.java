class Solution {
    // private static int help(int[][] arr,int m,int n)
    // {
    //     if(m==0&&n==0)
    //     {
    //         return 1;
    //     }
    //     if(m<0||n<0) return 0;
    //     if(arr[m][n]==1) return 0;
    //     int up=0, left=0;
    //     up=help(arr,m-1,n);
    //     left=help(arr,m,n-1);
    //     return up+left;
    // }
        private static int dpS(int[][] arr,int m,int n,int dp[][])
    {
        if(m<0||n<0) return 0;
        if(arr[m][n]==1) return 0;
        if(m==0&&n==0)
        {
            return 1;
        }
        if(dp[m][n]!=-1) return dp[m][n];
        int up=0, left=0;
        up=dpS(arr,m-1,n,dp);
        left=dpS(arr,m,n-1,dp);
        return dp[m][n]=up+left;
    }
    public int uniquePathsWithObstacles(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;
        if(m==1&&n==1&&arr[m-1][n-1]==1) return 0;
        if(m==1&&n==1&&arr[m-1][n-1]==0) return 1;
        // return help(obstacleGrid,m-1,n-1);
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j]=-1;
            }
        }
        return dpS(arr,m-1,n-1,dp);

    }

}