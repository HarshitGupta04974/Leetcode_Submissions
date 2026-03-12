class Solution {
    private static boolean tab(int target,int nums[])
    {
        int n=nums.length;
        boolean dp[][]=new boolean [n][target+1];
        for(int i=0;i<n;i++)
        {
            dp[i][0]=true;
        }
        if(nums[0]<=target) dp[0][nums[0]]=true;

        for(int i=1;i<n;i++)
        {
            for(int j=1;j<=target;j++)
            {
                boolean notpick=dp[i-1][j];
                boolean pick=false;
                if(j>=nums[i])
                {
                    pick=dp[i-1][j-nums[i]];
                }
                dp[i][j]=(pick|notpick);
            }
        }
        return dp[n-1][target];
    }
    public boolean canPartition(int[] nums) {
        int target=0;
        for(int i=0;i<nums.length;i++)
        {
            target+=nums[i];
        }
        if(target%2!=0) return false;
        return tab(target/2,nums);
    }
}