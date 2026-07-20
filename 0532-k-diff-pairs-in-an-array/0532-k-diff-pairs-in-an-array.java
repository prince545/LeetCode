class Solution {
    public int findPairs(int[] nums, int k) {
        int count=0;
        if(k==0){
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int ele: nums) map.put(ele, map.getOrDefault(ele,0)+1);
            for(int ele: map.keySet()) if(map.get(ele)>=2) count++;
            return count;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int ele: nums) set.add(ele);
        for(int ele: set){
            if(set.contains(ele+k)) count++;
        }
        return count;
    }
}