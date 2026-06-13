class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans=new StringBuilder();
        char hash[]=new char[26];
        for(char c='z';c>='a';c--)
        {
            hash['z'-c]=c;
        }
        for(int i=0;i<words.length;i++)
        {   String st=words[i];
            int val=0;
            for(int j=0;j<st.length();j++)
            {   char ch=st.charAt(j);
                val+=(weights[ch-'a']);
            }
            ans.append(hash[val%26]);
        }
        return ans.toString();
    }
}