class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;

        while(l<=r)
        {
            int mid=(l+r)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            //left half is sorted
            if(nums[l]<=nums[mid])
            {
                //ans is in this half
                if(nums[l]<=target&&nums[mid]>target)
                {
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            //right half is sorted
            else{
                //ans is in this half
                if(nums[mid]<target&&nums[r]>=target)
                {
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}