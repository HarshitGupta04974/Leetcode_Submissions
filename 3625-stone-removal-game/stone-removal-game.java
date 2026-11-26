class Solution {
    public boolean canAliceWin(int n) {
       if(n<10) return false;
       int temp=10;
       boolean aliceTurn=true;
        while(n>0&&temp>0)
        {
            if(n<temp)
            {
                break;
            }
            else if(n>=temp)
            {
                n-=temp;
                aliceTurn=!aliceTurn;
            }
            temp-=1;
        }
        return !aliceTurn;
    }
}