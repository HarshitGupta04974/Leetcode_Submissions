class Solution {
    public int maxDistance(int[] colors) {
        int dist=0;
        int n=colors.length;
      for(int i=0;i<n;i++)
      {
        for(int j=0;j<n;j++)
        {
            if(colors[i]!=colors[j])
            {
                dist=Math.max(dist,Math.abs(j-i));
            }
        }
      }
        return dist;
    }
}