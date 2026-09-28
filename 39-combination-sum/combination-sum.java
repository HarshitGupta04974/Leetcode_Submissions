class Solution {
    private static void help(int ind,List<List<Integer>> ans,List<Integer> ds,int target,int[]candidates)
    {
        if(ind==candidates.length)
        {
            return;
        }
        if(target==0)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(candidates[ind]<=target)
        {
            ds.add(candidates[ind]);
            help(ind,ans,ds,target-candidates[ind],candidates);
            ds.remove(ds.size()-1);
        }
        help(ind+1,ans,ds,target,candidates);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new  ArrayList<>();
        help(0,ans,new ArrayList<>(),target,candidates);;
        return ans;
    }
}