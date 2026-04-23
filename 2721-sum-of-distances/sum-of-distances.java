class Solution {
    public long[] distance(int[] nums) {
        int n=nums.length;
        long[] ans=new long[n];
        Map<Integer,List<Integer>> mpp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            mpp.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }
        for(List<Integer> ls:mpp.values())
        {
            int size=ls.size();
            long prefix[]=new long[size];
            prefix[0]=ls.get(0);
            for(int i=1;i<size;i++)
            {
                prefix[i]=prefix[i-1]+ls.get(i);
            }
            for(int k=0;k<size;k++)
            {   int idx=ls.get(k);
                long left=0;
                if(k>0)
                {
                    left=(long)idx*k-prefix[k-1];
                }
                long right=0;
                if(k<size-1)
                {
                    right=(prefix[size-1]-prefix[k])-(long)idx*(size-k-1);
                }
                ans[idx]=left+right;
            }
        }
        return ans;
    }
}