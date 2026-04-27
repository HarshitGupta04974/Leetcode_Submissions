class Solution {
   static int dir[][][]={
        {},
        {{0,-1},{0,1}},
        {{1,0},{-1,0}},
        {{0,-1},{1,0}},
        {{0,1},{1,0}},
        {{0,-1},{-1,0}},
        {{0,1},{-1,0}}
    };
    public boolean hasValidPath(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,0});
        vis[0][0]=true;
        while(!q.isEmpty())
        {
            int temp[]=q.poll();
            int x=temp[0];
            int y=temp[1];
            if(x==n-1&&y==m-1) return true;
            int type=grid[x][y];
            for(int row[]:dir[type])
            {
                int dx=x+row[0];
                int dy=y+row[1];
                if(dx>=n||dx<0||dy>=m||dy<0)continue;
                int nextType=grid[dx][dy];
                if(!vis[dx][dy]&&isConnected(row,nextType))
                {
                    vis[dx][dy]=true;
                    q.offer(new int[]{dx,dy});
                }
            }
        }
        return false;
    }
    private static boolean isConnected(int d[],int nextType)
    {
        int rx=-d[0];
        int ry=-d[1];
        for(int row[]:dir[nextType])
        {
            if(row[0]==rx&&row[1]==ry) return true;
        }
        return false;
    }
}