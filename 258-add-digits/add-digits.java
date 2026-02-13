class Solution {
    private static int addD(StringBuilder st,int i)
    {
        if(i>=st.length()) return 0;
        int  d=st.charAt(i)-'0';
        return d+addD(st,i+1);
    }
    private static int solve(int num){
        StringBuilder st=new StringBuilder(String.valueOf(num));
        if(st.length()==1)
        {
            return (st.charAt(0)-'0');
        }
        int curr=addD(st,0);
        return solve(curr);

    }
    public int addDigits(int num) {
        return solve(num);
    }
}