class Solution {
    private static void dfs(int row,int col,char mat[][],boolean visi[][],int dx[],int[] dy){
        visi[row][col]=true;
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+dx[i];
            int ncol=col+dy[i];
        if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&!visi[nrow][ncol]&&mat[nrow][ncol]=='O'){
            dfs(nrow,ncol,mat,visi,dx,dy);
        }
        }
    }
    public void solve(char[][] board) {
        int []dx={-1,0,1,0};
        int []dy={0,1,0,-1};
        int n=board.length;
        int m=board[0].length;
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<m;i++){
            if(!visited[0][i]&&board[0][i]=='O'){
                dfs(0,i,board,visited,dx,dy);
            }
            if(!visited[n-1][i]&&board[n-1][i]=='O'){
                dfs(n-1,i,board,visited,dx,dy);
            }
        }
        for(int i=0;i<n;i++){
            if(!visited[i][0]&&board[i][0]=='O'){
                dfs(i,0,board,visited,dx,dy);
            }
            if(!visited[i][m-1]&&board[i][m-1]=='O'){
                dfs(i,m-1,board,visited,dx,dy);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]&&board[i][j]=='O') board[i][j]='X';
            }
        }

    }
}