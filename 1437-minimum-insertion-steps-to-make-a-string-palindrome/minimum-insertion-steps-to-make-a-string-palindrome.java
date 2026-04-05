class Solution {
    private static int func(int i,int j,String s1,String s2,int dp[][])
    {
        if(i<0||j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j))
        {
            return 1+func(i-1,j-1,s1,s2,dp);
        }
        return dp[i][j]=Math.max(func(i-1,j,s1,s2,dp),func(i,j-1,s1,s2,dp));
    }
    private static int tab(String s1,String s2)
    {   int n=s1.length();
        int dp[][]=new int[n+1][n+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
            {
                dp[i][j]= 1+dp[i-1][j-1];
            }
            else{
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
            
            }
        }
        return dp[n][n];
    }
    public int minInsertions(String s) {
        int n=s.length();
        String s1=new StringBuilder(s).reverse().toString();
        // int dp[][]=new int[n][n];
        // for(int rows[]:dp) Arrays.fill(rows,-1);
        return n-tab(s,s1);
    }
}