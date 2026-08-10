class Solution {
    private static boolean help(int n,Boolean dp[])
    {
        if(n==0)
        {
            return false;
        }
        if(dp[n]!=null) return dp[n];
        for(int x=1;x*x<=n;x++)
        {
            if(!help(n-x*x,dp))
            {
                return dp[n]=true;
            }
        }
        return dp[n]=false;
    }
    private static boolean tab(int n)
    {
        Boolean dp[]=new Boolean[n+1];
        dp[0]=false;
        for(int i=1;i<=n;i++)
        {
            dp[i]=false;
            for(int x=1;x*x<=i;x++)
            {
                if(!dp[i-x*x])
                {
                     dp[i]=true;
                     break;
                }
            }
        }
        return dp[n];
    }
    public boolean winnerSquareGame(int n) {
        // Boolean dp[]=new Boolean[n+1];
        // return help(n,dp);
        return tab(n);
    }
}