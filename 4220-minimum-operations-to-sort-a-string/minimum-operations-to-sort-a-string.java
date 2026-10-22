class Solution {
    private static boolean isSorted(String s)
    {
        for(int i=0;i<s.length()-1;i++)
        {
            char ch=s.charAt(i);
            char ch1=s.charAt(i+1);
            if(ch>ch1) return false;
        }
        return true;
    }
    public int minOperations(String s) {
        int n=s.length();
        if(isSorted(s)) return 0;
        if(n==2) return -1;
        char min=(char)s.chars().min().getAsInt();
        char max=(char)s.chars().max().getAsInt();
        char first=s.charAt(0);
        char last=s.charAt(n-1);
        if(first==min||last==max) return 1;
        for(int i=1;i<n-1;i++)
        {   char temp=s.charAt(i);
            if(temp==min||temp==max) return 2;
        }
        return 3;
    }
}