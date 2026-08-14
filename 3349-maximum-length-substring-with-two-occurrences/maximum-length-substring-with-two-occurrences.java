class Solution {
    public int maximumLengthSubstring(String s) {
        int hash[]=new int[26];
        int n=s.length();
        int l=0,r=0;
        int maxi=Integer.MIN_VALUE;
        while(r<n)
        {   char ch=s.charAt(r);
            hash[ch-'a']++;
            while(hash[ch-'a']>2)
            {   hash[s.charAt(l)-'a']--;
                l++;
            }
            maxi=Math.max(maxi,r-l+1);
            r++;
        }
        return maxi;
    }
}