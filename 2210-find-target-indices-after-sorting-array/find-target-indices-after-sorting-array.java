class Solution {
    //optimal
    private static List<Integer> help(int[] nums, int target)
    {
        List<Integer> ls=new ArrayList<>();
        int count=0,smaller=0;
        for(int i:nums)
        {
            if(i<target)
            {
                smaller++;
            }
            else if(i==target){
                count++;
            }
        }
        for(int j=smaller;j<smaller+count;j++)
        {
            ls.add(j);
        }
        return ls;
    }
    //brute
    public List<Integer> targetIndices(int[] nums, int target) {
        // Arrays.sort(nums);
        // List<Integer> ls=new ArrayList<>();
        // for(int i=0;i<nums.length;i++)
        // {
        //     if(nums[i]==target) ls.add(i);
        // }
        // return ls;
        return help(nums,target);
    }
}