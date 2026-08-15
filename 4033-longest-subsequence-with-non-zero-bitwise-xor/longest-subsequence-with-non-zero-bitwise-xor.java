class Solution {
    // private static int func(int ind,int xor,int len,int nums[])
    // {
    //     if(ind<0)
    //     {
    //        return xor==0?0:len;
    //     }
    //     int npick=0,pick=0;
    //     npick=0+func(ind-1,xor,len,nums);
    //     pick=func(ind-1,xor^nums[ind],len+1,nums);
    //     return Math.max(npick,pick);
    // }
    public int longestSubsequence(int[] nums) {
        // int dp[][][]=new int[n][]
        // return func(n-1,0,0,nums);
        int n=nums.length;
        int totXor=Arrays.stream(nums).reduce(0,(a,b)->a^b);
        if(totXor!=0) return n;
        boolean hasNonZeros=Arrays.stream(nums).anyMatch(x->x!=0);
        return hasNonZeros?n-1:0;
    }
}