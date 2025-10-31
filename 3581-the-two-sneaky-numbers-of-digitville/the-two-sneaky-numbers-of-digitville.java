class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        int ans[]=new int[2];
        int ind=0;
        for (int i=0;i<nums.length;i++) mpp.put(nums[i],mpp.getOrDefault(nums[i],0)+1);
        
        for(Map.Entry<Integer,Integer> st:mpp.entrySet()){
            if(st.getValue()==2) ans[ind++]=st.getKey();
        }
        return ans;
    }
}