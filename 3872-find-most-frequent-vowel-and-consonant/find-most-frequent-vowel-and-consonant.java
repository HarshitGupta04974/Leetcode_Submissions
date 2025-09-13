class Solution {
    public int maxFreqSum(String s) {
        int ferq[]=new int[26];
        for(int i=0;i<s.length();i++){
           char ch=s.charAt(i);
            ferq[ch-'a']++;
        }
        String vowels="aeiou";
        int max_vowels=0;
        for(char c:vowels.toCharArray()){
            int f=ferq[c-'a'];
            max_vowels=Math.max(max_vowels,f);
        }
        int  max_consonants=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i); 
            if(vowels.indexOf(ch)==-1){
                int fr=ferq[ch-'a'];
                max_consonants=Math.max(max_consonants,fr);
            }

        }
        return (max_consonants+max_vowels);
    }
}