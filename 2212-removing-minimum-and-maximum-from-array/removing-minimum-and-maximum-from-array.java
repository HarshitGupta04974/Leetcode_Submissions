class Solution {
    public int minimumDeletions(int[] nums) {
        if(nums.length==1)
        {
            return 1;
        }
        int maxi=Integer.MIN_VALUE;
        int mini=Integer.MAX_VALUE;
        int maxInd=-1;
        int minInd=-1;
        int n=nums.length;
        for(int i=0;i<nums.length;i++)
        {
            if(maxi<nums[i])
            {
                maxi=nums[i];
                maxInd=i;
            }
            if(nums[i]<mini)
            {
                mini=nums[i];
                minInd=i;
            }
        }
        int sum=0;
      
        if(minInd>maxInd)
        {
            int temp=minInd;
            minInd=maxInd;
            maxInd=temp;
        }
        int front=maxInd+1;
        int back=n-minInd;
        int both=(minInd+1)+(n-maxInd);
        return Math.min(front,Math.min(back,both));
    }
}