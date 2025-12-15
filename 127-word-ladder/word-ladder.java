class Pair{
    String fs;
    int sn;
    Pair(String fs,int sn){
        this.fs=fs;
        this.sn=sn;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        Set<String> st=new HashSet<>(wordList);
        st.remove(beginWord);
        while(!q.isEmpty()){
            String str=q.peek().fs;
            int steps=q.peek().sn;
            q.poll();
            if(str.equals(endWord)==true) return steps;
            for(int i=0;i<str.length();i++){
                for(char ch='a';ch<='z';ch++){
                   StringBuilder sb=new StringBuilder(str);
                   sb.setCharAt(i,ch);
                    String s=sb.toString();
                    if(st.contains(s)){
                        st.remove(s);
                        q.offer(new Pair(s,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}