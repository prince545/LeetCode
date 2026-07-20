class Solution {
    public List<Integer> findMissingElements(int[] nums) {
       Arrays.sort(nums);
       int min  =nums[0];
       int max = nums[nums.length-1];
    boolean[] present = new boolean[max+1];

       for(int num : nums){
    
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