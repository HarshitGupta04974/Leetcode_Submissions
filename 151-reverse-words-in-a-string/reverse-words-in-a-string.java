class Solution {
    public String reverseWords(String s) {
        StringBuilder st=new StringBuilder();
        int i=s.length()-1;
        while(i>=0)
        {
            while(i>=0&&s.charAt(i)==' ') i--;

            int end=i;
            while(i>=0&&s.charAt(i)!=' ') i--;

            st.append(s,i+1,end+1);

            while(i>=0&&s.charAt(i)==' ') i--;
            if(i>=0)
            {
                st.append(' ');
            }
        }
        return st.toString();
    }
}