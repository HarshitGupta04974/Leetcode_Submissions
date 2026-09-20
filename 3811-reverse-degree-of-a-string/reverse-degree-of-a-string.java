class Solution {
    public int reverseDegree(String s) {
        int hash[]=new int[26];
        int val=26;
        for(int i=0;i<26;i++)
        {
            hash[i]=val--;
        }
        int product=1;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            product+=hash[ch-'a']*(i+1);
        }
        return product-1;
    }
}