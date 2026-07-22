class Pair implements Comparable<Pair>{
    int freq;
    int ele;
    Pair(int ele,int freq){
        this.freq = freq;
        this.ele = ele;
    }
    public int compareTo(Pair a){
        if(this.freq==a.freq) return this.ele-a.ele;
        return this.freq-a.freq;
    }

}
class Solution {
 public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int ele : nums){
        map.put(ele,map.getOrDefault(ele,0)+1);
    }
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    for(int ele : map.keySet()){
        int freq = map.get(ele);
        pq.add(new Pair(ele,freq));
        if(pq.size()>k) pq.remove();

    }
    List<Integer> ans = new ArrayList<>();
    while(pq.size()>0){
        Pair top = pq.remove();
        ans.add(top.ele);
    }
   
int[] res = new int[ans.size()];
for (int i = 0; i < ans.size(); i++) {
    res[i] = ans.get(i);
}

return res;    
}
}