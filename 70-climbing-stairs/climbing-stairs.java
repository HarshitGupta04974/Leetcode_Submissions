class Solution {
    // private static int help(int n)
    // {   if(n<0)
    //     {
    //         return 0;
    //     }
    //     if(n==0)
    //     {
    //         return 1;
    //     }
    //     return help(n-1)+help(n-2);
    // }
    private static int help_dp(int n,int dp[])
    {
        if(n==0) return 1;
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=help_dp(n-1,dp)+help_dp(n-2,dp);
    }
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return help_dp(n,dp);
    }
}