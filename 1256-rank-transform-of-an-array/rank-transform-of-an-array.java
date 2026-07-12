class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        int temp[]=arr.clone();
        int n=arr.length;
        Arrays.sort(temp);
        int rank=1;
        for(int i=0;i<n;i++)
        {
            if(!mpp.containsKey(temp[i]))
            {
                mpp.put(temp[i],rank++);
            }
        }
        
        int ans[]=new int[n];
        for(int i=0;i<n;i++)
        {
            ans[i]=mpp.get(arr[i]);
        }
        return ans;
    }
}