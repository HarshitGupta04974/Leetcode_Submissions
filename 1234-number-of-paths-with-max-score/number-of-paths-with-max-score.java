class Solution {
     static int MOD = 1_000_000_007;
    private static int[]func(int i,int j,char grid[][],int dp[][][])
    {
        if(i>=grid.length||j>=grid.length) return new int[]{Integer.MIN_VALUE,0};
        if(grid[i][j]=='X') return new int[]{Integer.MIN_VALUE,0};
        if(grid[i][j]=='S')
        {
            return new int[]{0,1};
        }
        if(dp[i][j][0]!=-1&&dp[i][j][1]!=-1)
        {
            return new int[]{dp[i][j][0],dp[i][j][1]};
        }
        int down[]=func(i,j+1,grid,dp);
        int right[]=func(i+1,j,grid,dp);
        int dig[]=func(i+1,j+1,grid,dp);
        int maxi=Math.max(down[0],Math.max(right[0],dig[0]));
        if(maxi==Integer.MIN_VALUE)
        {
            return new int[]{Integer.MIN_VALUE,0};
        }
        int ways=0;
        if(maxi==down[0])
        {
            ways=(ways+down[1])%MOD;
        }
        if(maxi==right[0])
        {
            ways=(ways+right[1])%MOD;
        }
        if(maxi==dig[0]){
            ways=(ways+dig[1])%MOD;
        }
         int temp=0;
        if(grid[i][j]!='E')
        {
            temp=grid[i][j]-'0';
            
        }
        dp[i][j][0]=maxi+temp;
        dp[i][j][1]=ways;
        return new int[]{dp[i][j][0],dp[i][j][1]};
    }
    private static int[] tab(char grid[][])
    {
        int n=grid.length;
        int dp[][][]=new int[n][n][2];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j][0]=Integer.MIN_VALUE;
                dp[i][j][1]=0;
            }

        }
        dp[n-1][n-1][0]=0;
        dp[n-1][n-1][1]=1;
        for(int i=n-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                if(grid[i][j]=='S'||grid[i][j]=='X') continue;
               int maxi=Integer.MIN_VALUE;
               int ways=0;
               if(i+1<n)
               {
                maxi=Math.max(maxi,dp[i+1][j][0]);
               }
               if(j+1<n)
               {
                maxi=Math.max(maxi,dp[i][j+1][0]);
               }
               if(i+1<n&&j+1<n)
               {
                maxi=Math.max(maxi,dp[i+1][j+1][0]);
               }
               if(maxi==Integer.MIN_VALUE) continue;

               if(i+1<n&&dp[i+1][j][0]==maxi)
               {
                ways=(ways+dp[i+1][j][1])%MOD;
               }
               if(j+1<n&&dp[i][j+1][0]==maxi)
               {
                ways=(ways+dp[i][j+1][1])%MOD;
               }
                if(i+1<n&&j+1<n&&dp[i+1][j+1][0]==maxi)
                {
                    ways=(ways+dp[i+1][j+1][1])%MOD;
                }
                int value = (grid[i][j] == 'E') ? 0 : grid[i][j] - '0';

                 dp[i][j][0] = maxi + value;
                 dp[i][j][1] = ways;
            }
        }
        return new int[]{ Math.max(0, dp[0][0][0]),dp[0][0][1]};

    }
    public int[] pathsWithMaxScore(List<String> board) {
        int n=board.size();
        char grid[][]=new char[n][n];
        // int dp[][][]=new int[n][n][2];
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<n;j++)
        //     {
        //         dp[i][j][0]=Integer.MIN_VALUE;
        //         dp[i][j][1]=0;
        //     }
        // }
        for(int i=0;i<n;i++)
        {
            
                grid[i]=board.get(i).toCharArray();
            
        }
        // int ans[]=func(0,0,grid,dp);
        // if(ans[0]==Integer.MIN_VALUE)
        // {
        //     ans[0]=0;
        // }
        // return ans;
        return tab(grid);
    }
}