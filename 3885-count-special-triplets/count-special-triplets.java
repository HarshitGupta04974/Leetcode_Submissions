class Solution {
    public int specialTriplets(int[] nums) {
        int MOD=1000000007;
        int n=nums.length;
        HashMap<Integer,Long> rmpp=new HashMap<>();
        for(int i:nums){
            rmpp.put(i,rmpp.getOrDefault(i,0L)+1);
        }
        HashMap<Integer,Long> lmpp=new HashMap<>();
        long ans=0;
        for(int i=0;i<n;i++){
            rmpp.put(nums[i],rmpp.get(nums[i])-1);
            int target=nums[i]*2;
            long R=rmpp.getOrDefault(target,0L);
            long L=lmpp.getOrDefault(target,0L);
            ans=(ans+(L*R)%MOD)%MOD;
            lmpp.put(nums[i],lmpp.getOrDefault(nums[i],0L)+1);
        }
        return (int)ans;
    }
}