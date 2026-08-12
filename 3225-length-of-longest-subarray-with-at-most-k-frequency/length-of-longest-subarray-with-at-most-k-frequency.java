class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        int n=nums.length;
        int l=0,r=0;
        int maxi=0;
        while(r<n)
        {   mpp.put(nums[r],mpp.getOrDefault(nums[r],0)+1);
            while(mpp.get(nums[r])>k)
            {   
                mpp.put(nums[l],mpp.getOrDefault(nums[l],0)-1);
                l++;
            }
            maxi=Math.max(maxi,r-l+1);
            r++;
        }
        return maxi;

    }
}