class Solution {
    public int minimumPushes(String word) {
      HashMap<Integer,Integer> mpp=new HashMap<>();
      int c=2;
      for(int i=0;i<word.length();i++)
      {
        char ch=word.charAt(i);
        if(c>9)
        {
            c=2;
        }
        mpp.put(c,mpp.getOrDefault(c,0)+1);
        c++;
      }  
      int ans=0;
      for(Map.Entry<Integer,Integer> st:mpp.entrySet())
      {
        int n=st.getValue();
        ans=ans+((n*(n+1))/2);
      }
      return ans;
    }
}