class Solution {
    private static long gcd(long a,long b)
    {
        while(b!=0)
        {
            long t=a%b;
            a=b;
            b=t;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int n=nums.length;
        long prefixGcd[]=new long[n];
        long maxi=Long.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            maxi=Math.max(nums[i],maxi);
            prefixGcd[i]=gcd(maxi,nums[i]);
        }
        Arrays.sort(prefixGcd);
        int l=0,r=n-1;
        long sum=0;
        while(l<r)
        {
            sum+=gcd(prefixGcd[l],prefixGcd[r]);
            l++;
            r--;
        }
        return sum;
    }
}