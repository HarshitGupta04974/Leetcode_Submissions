class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> st=new HashSet<>();
        String arr[]=text.split(" ");
        for(char ch:brokenLetters.toCharArray()){
            st.add(ch);
        }
        int count=0;
        
        for(String word:arr){
            Boolean flag=true;
            for(char c:word.toCharArray()){
                if(st.contains(c)){
                    flag=false;
                    break;
                }
            }
            if(flag) count++;
        }
        return count;
    }
    
}