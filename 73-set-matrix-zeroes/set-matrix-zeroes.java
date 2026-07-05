class Solution {
    public void setZeroes(int[][] matrix) {
        //mark the 0s
        int fC=-1;
        int fR=-1;
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==0)
                {
                    if(i==0) fR=1;
                    if(j==0) fC=1;
                    
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
            //making rows 0
            for(int i=0;i<n;i++)
            {   
                if(i==0)
                {
                    continue;
                }
                else if(matrix[i][0]==0)
                {
                    for(int j=0;j<m;j++)
                    {
                        matrix[i][j]=0;
                    }
                }
            }
            // making col 0
            for(int j=1;j<m;j++)
            {   
                if(matrix[0][j]==0)
                {
                    for(int i=1;i<n;i++)
                    {
                        matrix[i][j]=0;
                    }
                }
            }
            //first row condtion
            if(fC==1)
            {
                for(int i=0;i<n;i++)
                {
                    matrix[i][0]=0;
                }
            }
            if(fR==1)
            {
                for(int j=0;j<m;j++)
                {
                    matrix[0][j]=0;
                }
            }
    }
}