class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans=new String[m];
        for(int i=0;i<m-1;i++)
        {
            StringBuilder st=new StringBuilder(".");
            for(int j=1;j<n;j++)
            {
                st.append("#");
            }
            ans[i]=st.toString();
        }
        ans[m-1]=".".repeat(n);
        return ans;
    }
}