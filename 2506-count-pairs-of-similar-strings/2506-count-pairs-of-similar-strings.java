class Solution {
    public int similarPairs(String[] words) {
        int res = 0;
        int n = words.length;
        for(int i=0;i<n;i++){
            Set<Character> set1 = new HashSet<>();
            for(char ch : words[i].toCharArray()){
                set1.add(ch);
            }
            for(int j= i+1;j<n;j++){
                            Set<Character> set2 = new HashSet<>();
                            for(char ch : words[j].toCharArray()){
                                set2.add(ch);
                            }

            if(set1.equals(set2)) res++;

            }
        }
return res;
    }
}