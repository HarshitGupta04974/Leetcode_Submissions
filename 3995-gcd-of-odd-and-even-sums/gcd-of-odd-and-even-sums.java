class Solution {
    private int gcd(int a,int b)
    {
        while(b!=0)
        {
            int t=a%b;
            a=b;
            b=t;
        }
        return a;
    }
    public int gcdOfOddEvenSums(int n) {
        int os=n*n;
        int es=n*(n+1);
        return gcd(os,es);
    }
}