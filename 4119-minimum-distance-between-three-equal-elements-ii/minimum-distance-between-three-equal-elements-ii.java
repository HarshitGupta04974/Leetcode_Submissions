class Solution {
    public int minimumDistance(int[] nums) {
        int n=nums.length;
        int arr[][]=new int[n+1][2];
        for(int i=0;i<=n;i++)
        {
            arr[i][0]=-1;
            arr[i][1]=-1;
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            int idx=nums[i];
            int first=arr[idx][0];
            int second=arr[idx][1];
            if(first!=-1)
            {
                    int dist=2*(i-first);
                    ans=Math.min(ans,dist);
            }
            
            arr[idx][0]=second;
            arr[idx][1]=i;
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}