class Solution {
    private static boolean isPalindrome(int i,int j,String s)
    {
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    private static int func(int i,String s,int n,int dp[])
    {
        if(i==n) return 0;
        int mini=Integer.MAX_VALUE;
        if(dp[i]!=-1) return dp[i];
        for(int j=i;j<n;j++)
        {
            if(isPalindrome(i,j,s))
            {
                int cost=1+func(j+1,s,n,dp);
                mini=Math.min(mini,cost);
            }
        }
        return dp[i]=mini;
    }
    private static int tab(String s)
    {
        int n=s.length();
        int dp[]=new int[n+1];
        for(int i=n-1;i>=0;i--)
        {   int mini=Integer.MAX_VALUE;
            for(int j=i;j<n;j++)
            {
                if(isPalindrome(i,j,s))
                {
                    int cost=1+dp[j+1];
                    mini=Math.min(mini,cost);
                }   
            }
             dp[i]=mini;
        }
        return dp[0]-1;
    }
    public int minCut(String s) {
        // int n=s.length();
        // int dp[]=new int[n];
        // Arrays.fill(dp,-1);
        // return func(0,s,n,dp)-1;
        return tab(s);
    }
}