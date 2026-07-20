class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
HashMap<Character,Integer> amap = new HashMap<>();
HashMap<Character,Integer> bmap = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(amap.containsKey(ch)) {
                            int freq = amap.get(ch);

                amap.put(ch,freq+1);
            }
            else amap.put(ch,1);
        }
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(bmap.containsKey(ch)) {
                            int freq = bmap.get(ch);

                bmap.put(ch,freq+1);
            }
            else bmap.put(ch,1);
        }
        for(char ch : amap.keySet()){
            if(!bmap.containsKey(ch)) return false;
            else {
if (!bmap.get(ch).equals(amap.get(ch))) return false;            }
        }
return true;
    }
}