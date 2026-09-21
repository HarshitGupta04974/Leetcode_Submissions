class Solution {
    private static int help(int ind,int []coins,int amount,int dp[][])
    {
        if(ind==0)
        {
            if(amount%coins[ind]==0) return amount/coins[ind];
            return (int)1e9;
        }
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int npick=0,pick=(int)1e9;
        npick=help(ind-1,coins,amount,dp);
        if(coins[ind]<=amount)
        {
            pick=1+help(ind,coins,amount-coins[ind],dp);
        }
        return dp[ind][amount]=Math.min(pick,npick);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int rows[]:dp)
        {
            Arrays.fill(rows,-1);
        }
       int ans= help(coins.length-1,coins,amount,dp);
        return ans==(int)1e9?-1:ans;
    }
}