class Solution {
    private static int mod = (int) 1e9 + 7;

    private static int func(int i, int j, int grid[][], int dir,int dp[][][]) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j][dir] != -1) {
            return dp[i][j][dir];
        }
        if (grid[i][j] == 1) { 
            //entered mirror from the left will go up
            if (dir == 1) {
                return dp[i][j][dir]= func(i - 1, j, grid, 2,dp);
            }
            // entered mirror from down will go left
            else {
                return dp[i][j][dir]= func(i, j - 1, grid, 1,dp);
            }
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        int left = func(i, j - 1, grid, 1,dp) % mod;
        int up = func(i - 1, j, grid, 2,dp) % mod;
        return dp[i][j][dir]=(left + up) % mod;
    }

    public int uniquePaths(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][][]=new int[m][n][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return func(m-1,n-1,grid,0,dp);       
    }
}