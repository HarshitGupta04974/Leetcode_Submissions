class Solution {
    // memoization
    // private static int fib_dp(int n,int dp[])
    // {
    //     if(n<=1) return n;
    //     if(dp[n]!=-1) return dp[n];
    //     return dp[n]=fib_dp(n-1,dp)+fib_dp(n-2,dp);
    // }
    // private static int fib_tab(int n)
    // {   if(n<=1) return n;
    //     int dp[]=new int[n+1];
    //     dp[0]=0;
    //     dp[1]=1;
    //     for(int i=2;i<=n;i++)
    //     {
    //         dp[i]=dp[i-1]+dp[i-2];
    //     }
    //     return dp[n];
    // }
    public int fib(int n) {
        if(n<=1) return n;
       int prev2=0;
       int prev1=1;
       for(int i=2;i<=n;i++)
       {
        int cur=prev2+prev1;
        prev2=prev1;
        prev1=cur;
       }
       return prev1;
    }
}