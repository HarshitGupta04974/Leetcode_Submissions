class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return dfs(0,0,obstacleGrid, dp);

    }
private static int dfs(int i, int j, int[][] obstacleGrid, int[][] dp){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(i>=m || j>=n ||obstacleGrid[i][j]==1){
            return 0;
        }
        if(i==m-1&&j==n-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        dp[i][j]=dfs(i+1, j, obstacleGrid, dp) + dfs(i, j+1, obstacleGrid, dp);
        return dp[i][j];

}
}