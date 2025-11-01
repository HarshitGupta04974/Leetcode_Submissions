class Solution {
    public int[] nse(int []arr){
    int n=arr.length;
     int ans[]=new int[n];
     Deque<Integer> st=new LinkedList<>();
     for(int i=n-1;i>=0;i--){
        while(!st.isEmpty()&&arr[st.peek()]>=arr[i]) 
         st.pop();
        
        ans[i]=st.isEmpty()?n:st.peek();
        st.push(i);
     }
     return ans;
    }
    public int[] pse(int []arr){
        int n=arr.length;
     int ans[]=new int[n];
     Deque<Integer> st=new LinkedList<>();
     
     for(int i=0;i<n;i++){
        while(!st.isEmpty()&&arr[st.peek()]>arr[i]) 
         st.pop();
        
        ans[i]=st.isEmpty()?-1:st.peek();
        st.push(i);
     }
     return ans;
    }
    public int sumSubarrayMins(int[] arr) {
        int []n=nse(arr);
        int []p=pse(arr);
        int total=0;
        int mod = (int)1e9 + 7;
        for(int i=0;i<arr.length;i++){
            int left=i-p[i];
            int right=n[i]-i;
            long freq = left * right * 1L;
            int val = (int)((freq * arr[i]) % mod);
            total = (total + val) % mod;
        }
        return total;
    }
}