class Solution {
    static int MOD=1000000007;
    private static int gcd(int a,int b)
    {
        while(b!=0)
        {
            int t=a%b;
            a=b;
            b=t;
        }
        return a;
    }
    private static int fun(int ind,int gcd1,int gcd2,int nums[],int dp[][][])
    {
        if(ind==nums.length)
        {
            return (gcd1!=0&&gcd1==gcd2)?1:0;
        }
        if(dp[ind][gcd1][gcd2]!=-1) return dp[ind][gcd1][gcd2]; 
        int x=nums[ind];
        int p1=fun(ind+1,gcd1==0?x:gcd(gcd1,x),gcd2,nums,dp)%MOD;
        int p2=fun(ind+1,gcd1,gcd2==0?x:gcd(gcd2,x),nums,dp)%MOD;
        int ig=fun(ind+1,gcd1,gcd2,nums,dp)%MOD;
        return dp[ind][gcd1][gcd2]=(((p1+p2)%MOD)+ig)%MOD;
    }
    public int subsequencePairCount(int[] nums) {
        int n=nums.length;
        int m=Integer.MIN_VALUE;
        for(int i:nums)
        {
            m=Math.max(i,m);
        }
        int dp[][][]=new int[n+1][m+1][m+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                for(int k=0;k<=m;k++)
                {
                    dp[i][j][k]=-1;
                }
            }
        }
        return fun(0,0,0,nums,dp);
    }
}