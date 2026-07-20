class Solution {
    public List<Integer> findMissingElements(int[] nums) {
       boolean[] present = new boolean[101];
       int min  = 101 ;
       int max = 0;
       for(int num : nums){
        min = Math.min(min,num);
        max = Math.max(max,num);
        present[num] = true;
       }
       List<Integer> list = new ArrayList<>();
       for(int i=min;i<=max;i++){
        if(!present[i]){
            list.add(i);
        }
       }
       return list;
    }
}