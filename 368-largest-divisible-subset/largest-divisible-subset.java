class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
    List<Integer> ans=new ArrayList<>();
    Arrays.sort(nums);
    int n=nums.length;
    int dp[]=new int[n];
    Arrays.fill(dp,1);
    int hash[]=new int[n];
    int maxi=1;
    int lastInd=0;
    for(int i=0;i<n;i++)
    {
        hash[i]=i;
        for(int j=0;j<i;j++)
        {
            if(nums[i]%nums[j]==0&&
            1+dp[j]>dp[i])
            {
                dp[i]=1+dp[j];
                hash[i]=j;
            }
        }
        if(dp[i]>maxi)
        {
            maxi=dp[i];
            lastInd=i;
        }
    }  
    ans.add(nums[lastInd]);
    while(hash[lastInd]!=lastInd)
    {  lastInd=hash[lastInd];
        ans.add(nums[lastInd]);
    }      
    Collections.reverse(ans);
    return ans;
    }
}