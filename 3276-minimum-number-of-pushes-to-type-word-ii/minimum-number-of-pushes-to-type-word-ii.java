class Solution {
    public int minimumPushes(String word) {
        int freq[]=new int[26];
        for(int i=0;i<word.length();i++)
        {   char ch=word.charAt(i);
            freq[ch-'a']++;
        }
        Arrays.sort(freq);
        int slots[]=new int[8];
        int ind=0;
        int pushes=0;
        for(int i=25;i>=0;i--)
        {
            if(freq[i]==0)
            {
                break;
            }
            slots[ind]++;
            pushes+=freq[i]*slots[ind];
            ind=(ind+1)%8;

        }
        return pushes;
    }
}