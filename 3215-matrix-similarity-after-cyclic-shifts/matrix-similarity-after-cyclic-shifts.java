class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n=mat.length;
        int m=mat[0].length;
        k=k%m;
   
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int indexMapped;
                if(i%2==0)
                {
                    indexMapped=(j+k)%m;
                }
                else{
                    indexMapped=(j-k+m)%m;
                }
                if(mat[i][j]!=mat[i][indexMapped])
                {
                    return false;
                }
            }
        }
        return true;
    }
}