class Solution {
    private static int memo(int ind,int nums[],int dp[])
    {
        if(ind ==0) return nums[0];
        if(ind <0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int pick=nums[ind]+memo(ind-2,nums,dp);
        int n_pick=0+memo(ind-1,nums,dp);
        return dp[ind]=Math.max(n_pick,pick);
        
    }
    public int rob(int[] nums) 
    {
        int n=nums.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return memo(nums.length-1,nums,dp);
    }
}