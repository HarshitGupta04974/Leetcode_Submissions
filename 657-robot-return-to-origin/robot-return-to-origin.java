class Solution {
    public boolean judgeCircle(String moves) {
        int x=0,y=0;
        int n=moves.length();
        for(int i=0;i<n;i++)
        {
            char ch=moves.charAt(i);
            if(ch=='U')
            {
                y=y-1;
            }
            else if(ch=='D')
            {
                y=y+1;
            }
            else if(ch=='R')
            {
                x=x+1;
            }
            else if(ch=='L')
            {
                x=x-1;
            }
        }
        if(x==0&&y==0) return true;
        return false;
    }
}