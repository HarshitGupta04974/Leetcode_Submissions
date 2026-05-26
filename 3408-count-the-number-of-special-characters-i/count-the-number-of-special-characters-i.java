class Solution {
    public int numberOfSpecialChars(String word) {
       HashMap<Character,Integer> mpp=new HashMap<>();
       int n=word.length();
       int ans=0;
       for(int i=0;i<n;i++)
       {
        char ch=word.charAt(i);
        mpp.put(ch,mpp.getOrDefault(ch,0)+1);
       } 
       for(int i=0;i<n;i++)
       {
        char ch=word.charAt(i);
        if(Character.isUpperCase(ch)) continue;
        if(mpp.containsKey(Character.toUpperCase(ch)))
        {
           
            ans++;
            mpp.remove(Character.toUpperCase(ch));
        }
       }
       return ans;
    }
}