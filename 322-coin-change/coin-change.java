class Solution {
    private static int fun(int ind,int coins[],int sum,int dp[][])
    {
        if(ind==0)
        {
            if(sum%coins[ind]==0) return sum/coins[ind];
            return (int)1e9;
        }
        if(dp[ind][sum]!=-1) return dp[ind][sum];
        int pick=(int)1e9,npick=0;
        npick=fun(ind-1,coins,sum,dp);
        if(coins[ind]<=sum)
        {
            pick=1+fun(ind,coins,sum-coins[ind],dp);
        }
        return dp[ind][sum]=Math.min(pick,npick);
    }
    private static int tab(int coins[],int amount){
     int n=coins.length;
     int dp[][]=new int[n][amount+1];
     for(int t=0;t<=amount;t++)
     {
        if(t%coins[0]==0)
        {
            dp[0][t]=t/coins[0];
        }
        else{
            dp[0][t]=(int)1e9;
        }
     }
     for(int i=1;i<n;i++)
     {
        for(int t=0;t<=amount;t++)
        {
            int npick=0+dp[i-1][t];
            int pick=(int)1e9;
            if(coins[i]<=t)
            {
                pick=1+dp[i][t-coins[i]];
            }
            dp[i][t]=Math.min(pick,npick);
        }

     }  
     return dp[n-1][amount]; 
    }
    public int coinChange(int[] coins, int amount) {
    //  int n=coins.length;
    //  int dp[][]=new int[n][amount+1];
    // for(int row[]:dp) Arrays.fill(row,-1);
    int ans= tab(coins,amount);
    return ans==(int)1e9?-1:ans;   
    }
}