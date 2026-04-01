class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n=positions.length;
        int robots[][]=new int[n][4];
        for(int i=0;i<n;i++)
        {
            robots[i][0]=positions[i];
            robots[i][1]=healths[i];
            robots[i][2]=(directions.charAt(i)=='R')?1:-1;
            robots[i][3]=i;
        }
        Arrays.sort(robots,(a,b)->(a[0]-b[0]));
        Stack<int []> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            int cur[]=robots[i];
            while(!st.isEmpty()&&st.peek()[2]==1&&cur[2]==-1)
            {
                int el[]=st.pop();
                if(el[1]>cur[1])
                {
                    el[1]=el[1]-1;
                    st.push(el);
                    cur=null;
                    break;
                }
                else if(el[1]<cur[1])
                {
                    cur[1]-=1;
                }
                else if(el[1]==cur[1])
                {
                    cur=null;
                    break;
                }
            }
            if(cur!=null) st.push(cur);
        }
        List<Integer> ans=new ArrayList<>();
        int res[]=new int[n];
        Arrays.fill(res,-1);
        while(!st.isEmpty())
        {
            int el[]=st.pop();
            res[el[3]]=el[1];
        }
        for(int i:res)
        {
            if(i!=-1) ans.add(i);
        }
        return ans;

    }
}