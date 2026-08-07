class Solution {
    private static int func(int ind,int amount,int []coins,int dp[][])
    {
        if(ind==0)
        {
            if(amount%coins[ind]==0) return 1;
            return 0;
        }
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int pick=0,npick=0;
        npick=func(ind-1,amount,coins,dp);
        if(coins[ind]<=amount)
        {
            pick=func(ind,amount-coins[ind],coins,dp);
        }
        return dp[ind][amount]=(pick+npick);
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int rows[]:dp)
        {
            Arrays.fill(rows,-1);
        }
        return func(n-1,amount,coins,dp);
    }
}