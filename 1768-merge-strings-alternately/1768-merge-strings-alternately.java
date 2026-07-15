class Solution {
    public String mergeAlternately(String word1, String word2) {
        int a = 0;
        int b = 0;
        StringBuilder str = new StringBuilder();
        while(a<word1.length() && b<word2.length()){
            str.append(word1.charAt(a));
                        str.append(word2.charAt(b));

a++;
b++;
        }
        while(a<word1.length()){
                        str.append(word1.charAt(a));
                        a++;


        }
          while(b<word2.length()){
                        str.append(word2.charAt(b));
                        b++;


        }
        return str.toString();
    }
}