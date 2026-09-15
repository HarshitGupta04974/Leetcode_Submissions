class Solution {
    private static void merge(int nums[],int left,int mid,int right)
    {
        int i=left;
        int j=mid+1;
        ArrayList<Integer> ls=new ArrayList<>();
        while(i<=mid&&j<=right)
        {
            if(nums[i]<=nums[j])
            {
                ls.add(nums[i]);
                i++;
            }
            else {
                ls.add(nums[j]);
                j++;
            }
        }
        while(i<=mid)
        {
            ls.add(nums[i]);
            i++;
        }
        while(j<=right)
        {
            ls.add(nums[j]);
            j++;
        }
        for(int k=0;k<ls.size();k++)
        {
            nums[left+k]=ls.get(k);
        }
    }
    private static void mergeSort(int nums[],int left,int right)
    {
        if(left>=right) return;
        int mid=(left+right)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
}