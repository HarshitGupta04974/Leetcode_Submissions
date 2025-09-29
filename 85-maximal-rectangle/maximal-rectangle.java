class Solution {
    public static int largehist(int arr[]){
        Deque<Integer> st=new LinkedList<>();
        int maxA=0;
        int n=arr.length;
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty()&&arr[st.peek()]>arr[i]){
                int el=st.pop();
                int nse=i;
                int pse=st.isEmpty()?-1:st.peek();
                int aera=arr[el]*(nse-pse-1);
                maxA=Math.max(maxA,aera);
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
                int el=st.pop();
                int nse=n;
                int pse=st.isEmpty()?-1:st.peek();
                int aera=arr[el]*(nse-pse-1);
                maxA=Math.max(maxA,aera);
        }
       return maxA;
    }
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int presum[][]=new int[n][m];
     
        for(int j=0;j<m;j++){
            int s=0;
            for(int i=0;i<n;i++)
            {
               int val = matrix[i][j] - '0';  
                if(val == 0){
                    s = 0;  
                } else {
                    s += val;
                }
                presum[i][j]=s;
            }
        }
        int maxi=0;
        for(int i=0;i<n;i++){
          maxi=Math.max(maxi,largehist(presum[i]));
        }
        return maxi;
    }
}