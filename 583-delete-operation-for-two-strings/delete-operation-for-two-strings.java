class Solution {
    private static int func(int i,int j,String s1,String s2,int dp[][])
    {
        if(i<0||j<0)
        {
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j))
        {
            return dp[i][j]= 1+func(i-1,j-1,s1,s2,dp);
        }
        return dp[i][j]=Math.max(func(i-1,j,s1,s2,dp),func(i,j-1,s1,s2,dp));
    }
    public int minDistance(String word1, String word2) {
        // if(word1.equalsIgnoreCase(word2)) return 0;
        int n1=word1.length(),n2=word2.length();
        int dp[][]=new int[n1+1][n2+1];
        for(int rows[]:dp) Arrays.fill(rows,-1);
        int lcs=func(n1-1,n2-1,word1,word2,dp);
            return n1+n2-2*lcs;
        }
}