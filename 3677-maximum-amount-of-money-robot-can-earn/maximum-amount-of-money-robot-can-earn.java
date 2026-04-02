class Solution {
    private static int fun(int i, int j, int[][] coins, int neutralize, int[][][] dp) {
        if (i < 0 || j < 0) return (int) -1e9;

        if (i == 0 && j == 0) {
            if (coins[i][j] >= 0) return coins[i][j];
            else return (neutralize > 0) ? 0 : coins[i][j];
        }

        if (dp[i][j][neutralize] != Integer.MIN_VALUE)
            return dp[i][j][neutralize];

        
        int prevSameNeutral = Math.max(
            fun(i - 1, j, coins, neutralize, dp),
            fun(i, j - 1, coins, neutralize, dp)
        );

        int ans;

        if (coins[i][j] >= 0) {
                       ans = coins[i][j] + prevSameNeutral;
        } else {
                       int take = coins[i][j] + prevSameNeutral;

           
            int skip = (int) -1e9;
            if (neutralize > 0) {
                int prevReducedNeutral = Math.max(
                    fun(i - 1, j, coins, neutralize - 1, dp),
                    fun(i, j - 1, coins, neutralize - 1, dp)
                );
                skip = prevReducedNeutral;
            }

            ans = Math.max(take, skip);
        }

        return dp[i][j][neutralize] = ans;
    }

    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;

        int[][][] dp = new int[n][m][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        return fun(n - 1, m - 1, coins, 2, dp);
    }
}