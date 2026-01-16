class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> st=new LinkedList<>();
        int maxa=0;
        int n=heights.length;
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty()&&heights[st.peek()]>heights[i])
            {
                int ind=st.pop();
                int nse=i;
                int pse=st.isEmpty()?-1:st.peek();
                int area=heights[ind]*(nse-pse-1);
                maxa=Math.max(area,maxa);
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            int ind=st.pop();
            int nse=n;
            int pse=st.isEmpty()?-1:st.peek();
            int area=heights[ind]*(nse-pse-1);
            maxa=Math.max(area,maxa);
        }
        return maxa;
    }
}