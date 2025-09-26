class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        int n=nums.length;
        for(int i=n-1;i>=2;i--){
            int j=0,k=i-1;
            while(j<k){
                if(nums[j]+nums[k]>nums[i]){
                    count+=(k-j);
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return count;
    }
}