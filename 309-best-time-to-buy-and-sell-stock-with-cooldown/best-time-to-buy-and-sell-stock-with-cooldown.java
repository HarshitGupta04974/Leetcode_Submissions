class Solution {
    private static int func(int ind,int prices[],int buy,int dp[][])
    {
        if(ind>=prices.length)
        {
            return 0;
        }
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        if(buy==1)
        {   
            return dp[ind][buy]=Math.max(-prices[ind]+func(ind+1,prices,0,dp),0+func(ind+1,prices,1,dp));

        }
        else{
            return dp[ind][buy]=Math.max(prices[ind]+func(ind+2,prices,1,dp),0+func(ind+1,prices,0,dp));
        }
    }
    private static int tab(int prices[])
    {
        int n=prices.length;
        int dp[][]=new int[n+2][2];
        for(int i=n-1;i>=0;i--)
        {
            for(int k=0;k<=1;k++)
            {
                if(k==1)
                {
                    dp[i][k]=Math.max(-prices[i]+dp[i+1][0],0+dp[i+1][1]);
                }
                else{
                    dp[i][k]=Math.max(prices[i]+dp[i+2][1],0+dp[i+1][0]);
                }
            }
        }
        return dp[0][1];
    }
    public int maxProfit(int[] prices) {
        
        // int n=prices.length;
        // int dp[][]=new int[n][2];
        // for(int rows[]:dp)
        // {
        //     Arrays.fill(rows,-1);
        // }
        // return func(0,prices,1,dp);
        return tab(prices);
    }
}