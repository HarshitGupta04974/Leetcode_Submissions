class Solution {
    private static int help(int num)
    {
        int digits=(int)Math.log10(num)+1;
        num%=(int)Math.pow(10,digits-1);
        int lastDigit=num%10;
        return num*10+(lastDigit+1);
    }
    public List<Integer> sequentialDigits(int low, int high) {
        int lD=(int)Math.log10(low)+1;
        int hD=(int)Math.log10(high)+1;
        List<Integer> ans=new ArrayList<>();
        for(int i=lD;i<=hD;i++)
        {
            int cur=0;
            for(int j=1;j<=i;j++)
            {
                cur=cur*10+j;
            }
            for(int k=1;k<=10-i;k++)
            {
                if(cur>=low&&cur<=high)
                {
                    ans.add(cur);
                }
                cur=help(cur);
            }
        }
    return ans;
    }
}