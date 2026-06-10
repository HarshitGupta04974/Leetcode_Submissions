class Solution {
    private static int func(int i,int j,ArrayList<Integer> arr,int dp[][])
    {
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int maxi=Integer.MIN_VALUE;
        for(int ind=i;ind<=j;ind++)
        {
            int cost=arr.get(i-1)*arr.get(ind)*arr.get(j+1)+func(i,ind-1,arr,dp)+func(ind+1,j,arr,dp);
            maxi=Math.max(maxi,cost);
        }
        return dp[i][j]=maxi;
    }
    public int maxCoins(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i:nums) arr.add(i);

        arr.add(0,1);
        arr.add(1);
        int dp[][]=new int[n+2][n+2];
        for(int rows[]:dp) Arrays.fill(rows,-1);
        return func(1,n,arr,dp);
    }
}