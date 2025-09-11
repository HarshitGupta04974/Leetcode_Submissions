class Solution {

    public String sortVowels(String s) {
        List<Character> l=new ArrayList<>();
         String vowel="aeiouAEIOU";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(vowel.indexOf(c)!=-1){
                l.add(c);
            }
        }
        Collections.sort(l);
        StringBuilder sb = new StringBuilder();
        int vowelIndex = 0;

        for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (vowel.indexOf(c) != -1) {
            sb.append(l.get(vowelIndex));
            vowelIndex++;
        } else {
            sb.append(c);
        }
        }
        return sb.toString();
        }
}