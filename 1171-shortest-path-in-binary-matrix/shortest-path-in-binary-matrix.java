class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1||grid[n-1][n-1]==1) return -1;
        Queue<int []> q=new LinkedList<>();
        q.offer(new int[]{0,0});
        int dx[]={+1,0,-1,0,1,-1,+1,-1};
        int dy[]={0,-1,0,+1,1,-1,-1,+1};
        int dist[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=1;
        while(!q.isEmpty())
        {
            int temp[]=q.poll();
            int x=temp[0];
            int y=temp[1];
           
            if(x==n-1&&y==n-1)
            {
                return dist[x][y];
            }
            for(int i=0;i<8;i++)
            {
                for(int j=0;j<8;j++)
                {
                    int newr=x+dx[i];
                    int newc=y+dy[i];
        if(newr<n&&newr>=0&&newc<n&&newc>=0&&dist[newr][newc]==Integer.MAX_VALUE&&grid[newr][newc]==0)
                    {
                        q.offer(new int[]{newr,newc});
                        dist[newr][newc]=Math.min(dist[x][y]+1,dist[newr][newc]);
                    }
                }
            }
        }
        return -1;
    }
}