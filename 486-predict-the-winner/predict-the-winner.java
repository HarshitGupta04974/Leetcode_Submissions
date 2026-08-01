class Solution {
    private static int func(int i,int j,int nums[],int dp[][])
    {
        if(i==j) return nums[i];
        if(dp[i][j]!=-1) return dp[i][j];
        int takeleft=nums[i]-func(i+1,j,nums,dp);
        int takeright=nums[j]-func(i,j-1,nums,dp);
        return dp[i][j]=Math.max(takeleft,takeright);
    }
    public boolean predictTheWinner(int[] nums) {
        int n =nums.length;
        int dp[][]=new int[n][n];
        for(int rows[]:dp)
        {
            Arrays.fill(rows,-1);
        }
        return func(0,nums.length-1,nums,dp)>=0;
    }
}