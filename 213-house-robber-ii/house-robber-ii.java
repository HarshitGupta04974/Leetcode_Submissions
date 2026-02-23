class Solution {
    private static int help(int nums[])
    {
        int n=nums.length;
        int prev=nums[0];
        int prev2=0;
        for(int i=1;i<n;i++)
        {
           int take=nums[i];
           if(i>1) take+=prev2;
            
            int nottake=0+prev;
            int cur=Math.max(nottake,take);
            prev2=prev;
            prev=cur;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int n1[]=new int[n];
        int n2[]=new int[n];
        for(int i=0;i<n;i++)
        {
            if(i!=0) n1[i]=nums[i];
            if(i!=n-1) n2[i]=nums[i];
        }
        return Math.max(help(n1),help(n2));
    }
}