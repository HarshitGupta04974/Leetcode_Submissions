class Solution {
    private static final int mod=1_000_000_007;;
    private static int func(int n,int k,int start,int dp[][])
    {
        if(k==0)
        {
            return 1;
        }
        if(start>=n-1)
        {
            return 0;
        }
        if(dp[start][k]!=-1) return dp[start][k];
        int ans=0;
        ans+=func(n,k,start+1,dp);
        for(int end=start+1;end<n;end++)
        {
            ans+=func(n,k-1,end,dp);
            ans%=mod;
        }
        return dp[start][k]=ans;
    }
    private static int tab(int n,int k)
    {
        int dp[][]=new int[n][k+1];
        for(int start=0;start<n;start++)
        {
            dp[start][0]=1;
        }
        for(int seg=1;seg<=k;seg++)
        {
            int suffix=0;
            for(int start=n-1;start>=0;start--)
            {
                dp[start][seg]=(start+1<n?dp[start+1][seg]:0)+suffix;
                dp[start][seg]%=mod;
                suffix+=dp[start][seg-1];
                suffix%=mod;
            }
        }
        return dp[0][k];
    }
    public int numberOfSets(int n, int k) {
        // int dp[][]=new int[n][k+1];
        // for(int rows[]:dp)
        // {
        //     Arrays.fill(rows,-1);
        // }
        // return func(n,k,0,dp);
        return tab(n,k);
    }
}