class Solution {
    private static int func(int ind,int prev,int nums[],int dp[][])
    {
        if(ind==nums.length)
        {
            return 0;
        }
        if(dp[ind][prev+1]!=-1) return dp[ind][prev+1];
        int len=0;
        len=0+func(ind+1,prev,nums,dp);
        if(prev==-1||nums[ind]>nums[prev])
        {
            len=Math.max(len,1+func(ind+1,ind,nums,dp));
        }
        return dp[ind][prev+1]=len;
    }
    private static int tab(int nums[])
    {
        int n=nums.length;
        int dp[][]=new int[n+1][n+1];
        for(int ind=n-1;ind>=0;ind--)
        {
            for(int prev=ind-1;prev>=-1;prev--)
            {
                int len=0;
                len=0+dp[ind+1][prev+1];
                if(prev==-1||nums[ind]>nums[prev])
                {
                    len=Math.max(len,1+dp[ind+1][ind+1]);
                }
                 dp[ind][prev+1]=len;
            }
        }
        return dp[0][0];
    }
    public int lengthOfLIS(int[] nums) {
        // int n=nums.length;
        // int dp[][]=new int[n][n+1];
        // for(int rows[]:dp) Arrays.fill(rows,-1);
        // return func(0,-1,nums,dp); 
        return tab(nums);       
    }
}