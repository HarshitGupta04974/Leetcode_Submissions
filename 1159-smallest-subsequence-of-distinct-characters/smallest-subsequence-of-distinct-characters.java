class Solution {
    public String smallestSubsequence(String s) {
        StringBuilder st=new StringBuilder();
        int hash[]=new int[26];
        boolean used[]=new boolean[26];
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            hash[ch-'a']++;
        }
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            hash[ch-'a']--;
            if(used[ch-'a'])
            {
                continue;
            }
            while(st.length()>0&&st.charAt(st.length()-1)>ch&&hash[st.charAt(st.length()-1)-'a']>0)
            {
                char temp=st.charAt(st.length()-1);
                st.deleteCharAt(st.length()-1);
                used[temp-'a']=false;
            }
            st.append(ch);
            used[ch-'a']=true;
        }
        return st.toString();
    }
}