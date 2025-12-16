class Solution {
    private static void help(int nums[],List<List<Integer>> ans,List<Integer> ds,boolean used[]){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]||i>0&&nums[i]==nums[i-1]&&!used[i-1]){
                    continue;
            }
            used[i]=true;
            ds.add(nums[i]);
            help(nums,ans,ds,used);
            used[i]=false;
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<>();
        help(nums,ans,new ArrayList<>(),new boolean[nums.length]);
        return ans;
    }
}