class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n=grid.size();
        int dist[][]=new int[n][n];
        Queue<int []> q=new LinkedList<>();
        for(int rows[]:dist)
        {
            Arrays.fill(rows,Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid.get(i).get(j)==1)
                {
                    dist[i][j]=0;
                    q.offer(new int[]{i,j});

                }
            }
        }
        int dx[]={1,0,-1,0};
        int dy[]={0,1,0,-1};
        while(!q.isEmpty())
        {
            int temp[]=q.poll();
            int r=temp[0];
            int c=temp[1];
            for(int i=0;i<4;i++)
            {
                int nr=r+dx[i];
                int nc=c+dy[i];
            if(nr>=0&&nr<n&&nc>=0&&nc<n&&dist[nr][nc]==Integer.MAX_VALUE)
            {
                dist[nr][nc]=dist[r][c]+1;
                q.offer(new int[]{nr,nc});
            }
            }
        }
        boolean vis[][]=new boolean[n][n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(b[0]-a[0]));
        pq.offer(new int[]{dist[0][0],0,0});
        while(!pq.isEmpty())
        {
            int temp[]=pq.poll();
            int safe=temp[0];
            int r=temp[1];
            int c=temp[2];
            if(vis[r][c]) continue;
            
            vis[r][c]=true;
            if(r==n-1&&c==n-1)
            {
                return safe;
            }
            for(int i=0;i<4;i++)
            {
                int nr=r+dx[i];
                int nc=c+dy[i];
                 if(nr>=0&&nr<n&&nc>=0&&nc<n&&!vis[nr][nc])
                 {
                    int newSafe=Math.min(safe,dist[nr][nc]);
                    pq.offer(new int[]{newSafe,nr,nc});
                 }
            }
        }
        return -1;
    }
}