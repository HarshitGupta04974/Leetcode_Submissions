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
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n+1];
        for(int rows[]:dp) Arrays.fill(rows,-1);
        return func(0,-1,nums,dp);       
    }
}