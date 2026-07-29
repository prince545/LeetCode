class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
         Map<Integer,Integer> map = new HashMap<>();
         for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
         }
         for(int ele : nums) {
            if(map.get(ele)==1) return ele;
         }
         return -1;
        
    }
}