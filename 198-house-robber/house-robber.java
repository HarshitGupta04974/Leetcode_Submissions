class Solution {
    // private static int memo(int ind,int nums[],int dp[])
    // {
    //     if(ind ==0) return nums[0];
    //     if(ind <0) return 0;
    //     if(dp[ind]!=-1) return dp[ind];
    //     int pick=nums[ind]+memo(ind-2,nums,dp);
    //     int n_pick=0+memo(ind-1,nums,dp);
    //     return dp[ind]=Math.max(n_pick,pick);
        
    // }
    // private static int tab(int nums[])
    // {
    //     int n=nums.length;
    //     int dp[]=new int[n+1];
    //     Arrays.fill(dp,-1);
    //     dp[0]=nums[0];
    //     for(int i=1;i<n;i++)
    //     {
    //         int take=nums[i];
    //         if(i>1)
    //         {
    //             take+=dp[i-2];
    //         }
    //         int n_take=0+dp[i-1];
    //         dp[i]=Math.max(take,n_take);
    //     }
    //     return dp[n-1];
    // }
    public int rob(int[] nums) 
    {
        // int dp[]=new int[n+1];
        // Arrays.fill(dp,-1);
        // return memo(nums.length-1,nums,dp);
        // return tab(nums);

        // space optimized

        int n=nums.length;
        int prev=nums[0];
        int prev2=0;
        for(int i=1;i<n;i++)
        {
            int cur=0;
            int take=nums[i]+prev2;
            int n_take=0+prev;
            cur=Math.max(take,n_take);
            prev2=prev;
            prev=cur;
        }
        return prev;
    }
}