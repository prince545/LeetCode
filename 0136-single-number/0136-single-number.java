class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
         Set<Integer> set = new HashSet<>();
         int i=0;
         while(i<nums.length){
            if(set.contains(nums[i])) {
                set.remove(nums[i]);
            
            }
            else set.add(nums[i]);
            i++;
         }
        return set.iterator().next();
    }
}