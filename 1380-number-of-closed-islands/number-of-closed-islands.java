class Solution {
    private static boolean bfs(int x,int y,int grid[][],int dir[][])
    {
        Queue<int[]>q =new LinkedList<>();
        boolean flag=true;
        q.offer(new int[]{x,y});
        grid[x][y]=1;
        int n=grid.length;
        int m=grid[0].length;
        while(!q.isEmpty())
        {
            int temp[]=q.poll();
            int r=temp[0],c=temp[1];
            if(r==n-1||r==0||c==0||c==m-1)
            {
                flag=false;
            }
            for(int i[]:dir)
            {
                int nr=r+i[0];
                int nc=c+i[1];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]==0)
                {   
                    grid[nr][nc]=1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return flag;
    }

    public int closedIsland(int[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    if (bfs(i, j, grid, dir)) {
                        count++;
                    }

                }
            }   
        }
        return count;
    }
}