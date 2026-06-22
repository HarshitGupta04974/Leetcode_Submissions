class Solution {
    public int maxNumberOfBalloons(String text) {
        int b=0,a=0,l=0,o=0,n=0;
        for(int i=0;i<text.length();i++)
        {
            char ch=text.charAt(i);
            if(ch=='b') b++;
            else if(ch=='a') a++;
            else if(ch=='l') l++;
            else if(ch=='o') o++;
            else if(ch=='n') n++;
        }
        int count=0;
        while(b>=1&&a>=1&&l>=2&&o>=2&&n>=1)
        {
            count++;
            b--;
            a--;
            l-=2;
            o-=2;
            n--;
        }
        return count;
    }
}