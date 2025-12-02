class Pair implements Comparable<Pair>{
    int el;
    int freq;
    Pair(int el,int freq){
        this.el=el;
        this.freq=freq;
    }
    public int compareTo(Pair p){
        if(p.freq==this.freq) return this.el-p.el;
        return this.freq-p.freq;
    }

}
class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int arr[]=new int[n-k+1];
        for(int i=0;i<=n-k;i++){
            HashMap<Integer,Integer> mpp=new HashMap<>();
            for(int j=i;j<=i+k-1;j++){
                mpp.put(nums[j],mpp.getOrDefault(nums[j],0)+1);
            }
            PriorityQueue<Pair> pq=new PriorityQueue<>();
            for(Map.Entry<Integer,Integer> st:mpp.entrySet()){
                pq.offer(new Pair(st.getKey(),st.getValue()));
                if(pq.size()>x) pq.poll();
            }
            int s=0;
            while(pq.size()>0){
                Pair p=pq.poll();
                s+=p.freq*p.el;
            }
            arr[i]=s;
        }
        return arr;
    }
}