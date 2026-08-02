class Solution {
    private static int func(int i,int j,int nums[],int dp[][])
    {
        if(i==j)
        {
            return nums[i];
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int takeLeft=nums[i]-func(i+1,j,nums,dp);
        int takeRight=nums[j]-func(i,j-1,nums,dp);
        return dp[i][j]=Math.max(takeLeft,takeRight);
    }
    private static int tab(int[]piles)
    {  
        int n =piles.length;
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j)
                dp[i][j]=piles[i];
            }
        }
        for(int i =n-1;i>=0;i--)
        {
            for(int j=i+1;j<n;j++)
            {
                int takeLeft=piles[i]-dp[i+1][j];
                int takeRight=piles[j]-dp[i][j-1];
                dp[i][j]=Math.max(takeLeft,takeRight);
            }
        }
        return dp[0][n-1];

    }
    public boolean stoneGame(int[] piles) {
        // int n =piles.length;
        // int dp[][]=new int[n][n];
        // for(int rows[]:dp)
        // {
        //     Arrays.fill(rows,-1);
        // }
        // return func(0,n-1,piles,dp)>0;
        return tab(piles)>0;
    }
}