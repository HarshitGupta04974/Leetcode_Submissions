class Solution {
    private static int digiSum(int n)
    {
        int temp=n;
        int sum=0;
        while(temp!=0)
        {
            int d=temp%10;
            sum+=d;
            temp=temp/10;
        }
        return sum;
    }
    public int minElement(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=digiSum(nums[i]);
        }
        int mini=Integer.MAX_VALUE;
        for(int i:arr)
        {
            mini=Math.min(mini,i);
        }
        return mini;
    }
}