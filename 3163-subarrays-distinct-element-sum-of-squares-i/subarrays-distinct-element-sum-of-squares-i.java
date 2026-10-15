class Solution {
    public int sumCounts(List<Integer> nums) {
       int n=nums.size(),total=0;
       for(int i=0;i<n;i++)
       {
        HashSet<Integer> st=new HashSet<>();
        for(int j=i;j<n;j++)
        {
            st.add(nums.get(j));
            int d=st.size();
            total+=d*d;
        }
       }
       return total;
    }
}