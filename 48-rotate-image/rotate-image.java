class Solution {
    private static void transponse(int [][]matrix)
    {   int n=matrix.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int t=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
        }

    }
    private static void reverse(int [][]matrix)
    {   int n=matrix.length;
        for(int i=0;i<n;i++)
        {
            int l=0;
            int h=n-1;
            while(l<h)
            {
                int t=matrix[i][l];
                matrix[i][l]=matrix[i][h];
                matrix[i][h]=t;
                l++;
                h--;
            }
        }
    }
    public void rotate(int[][] matrix) {
         transponse(matrix);
         reverse(matrix);
    }
}