class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int []> pq=new PriorityQueue<>((a,b)->(a[0]-b[0]));
        int n=heights.length;
        int m=heights[0].length;
        int diff[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                diff[i][j]=(int)1e9;
            }
        }
        diff[0][0]=0;
        pq.offer(new int[]{0,0,0});
        int dx[]={-1,0,1,0};
        int dy[]={0,-1,0,1};
        while(!pq.isEmpty())
        {
            
            int temp[]=pq.poll();
            int dist=temp[0];
            int x=temp[1];
            int y=temp[2];
            if(x==n-1&&y==m-1) return dist;

            for(int i=0;i<4;i++)
            {
                int newr=x+dx[i];
                int newc=y+dy[i];
                if(newr>=0 && newr<n && newc>=0 && newc<m)
                {
                    int neweffort=Math.max(Math.abs(heights[x][y]-heights[newr][newc]),dist);
                    if(neweffort<diff[newr][newc])
                    {
                        diff[newr][newc]=neweffort;
                        pq.add(new int[]{neweffort,newr,newc});
                    }
                }
            }
        }
        return 0;
    }
}