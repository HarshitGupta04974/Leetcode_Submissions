class Solution {
    private static int gcd(int a,int b)
    {
        while(b!=0)
        {
            int t=a%b;
            a=b;
            b=t;
        }
        return a;
    }
    public int findGCD(int[] nums) {
        int min=Arrays.stream(nums).min().getAsInt();
        int max=Arrays.stream(nums).max().getAsInt();
        return gcd(min,max);
    }
}