class Solution {
    private static void transpose(int mat[][])
    {
        for(int i=0;i<mat.length;i++)
        {
            for(int j=i;j<mat[0].length;j++)
            {
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
    }
    private static void rev(int mat[][])
    {   int n=mat.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n/2;j++)
            {
                int temp=mat[i][j];
                mat[i][j]=mat[i][n-j-1];
                mat[i][n-j-1]=temp;
            }
        }
    }
    private boolean check(int[][] mat, int[][] target)
    {   int n=mat.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]!=target[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        int n=mat.length;
        int copy[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                copy[i][j]=mat[i][j];
            }
        }
        while(true)
        {
            transpose(mat);
            rev(mat);
            if(check(mat,target))
            {
                return true;
            }
            if(check(mat,copy))
            {
                break;
            }
        }
        return false;
    }
}