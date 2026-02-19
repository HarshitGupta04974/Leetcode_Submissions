class Solution {
    // memoization
    // private static int fib_dp(int n,int dp[])
    // {
    //     if(n<=1) return n;
    //     if(dp[n]!=-1) return dp[n];
    //     return dp[n]=fib_dp(n-1,dp)+fib_dp(n-2,dp);
    // }
    private static int fib_tab(int n)
    {   if(n<=1) return n;
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public int fib(int n) {
       
        // Arrays.fill(dp,-1);
        // return fib_dp(n,dp);

        return fib_tab(n);
    }
}