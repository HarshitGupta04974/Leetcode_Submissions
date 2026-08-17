class Solution {
    private static int func(int l,int r,int prefix[],int dp[][])
    {
        if(l==r) return 0;
        int ans=0;
        if(dp[l][r]!=-1) return dp[l][r];
        for(int i=l;i<=r;i++)
        {   int lsum=prefix[i+1]-prefix[l];
            int rsum=prefix[r+1]-prefix[i+1];
            if(lsum<rsum)
            {
                ans= Math.max(ans,lsum+func(l,i,prefix,dp));
            }
            else if(rsum<lsum)
            {
                ans=Math.max(ans,rsum+func(i+1,r,prefix,dp));
            }
            else{
                ans=Math.max(ans,lsum+Math.max(func(l,i,prefix,dp),func(i+1,r,prefix,dp)));
            }

        }
         return dp[l][r]=ans;
    }
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        int prefix[]=new int[n+1];
        int dp[][]=new int[n+1][n+1];
        for(int rows[]:dp)
        {
            Arrays.fill(rows,-1);
        }
        for(int i=0;i<n;i++)
        {
            prefix[i+1]=prefix[i]+stoneValue[i];
        }
        return func(0,n-1,prefix,dp);
    }
}