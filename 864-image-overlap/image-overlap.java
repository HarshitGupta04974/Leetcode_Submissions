class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<int[]> p1=new ArrayList<>();
        List<int[]> p2=new ArrayList<>();
        int n=img1.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(img1[i][j]==1)
                {
                    p1.add(new int[]{i,j});
                }
                if(img2[i][j]==1)
                {
                    p2.add(new int[]{i,j});
                }
            }
        }
        HashMap<String,Integer> mpp=new HashMap<>();
        int ans=0;
        for(int i[]:p1)
        {
            for(int j[]:p2)
            {
                int dx=i[0]-j[0];
                int dy=i[1]-j[1];
                int count=mpp.getOrDefault(dx+","+dy,0)+1;
                mpp.put(dx+","+dy,count);
                ans=Math.max(ans,count);
            }
        }
        return ans;
    }
}