class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length-1];
     List<Integer> list = new ArrayList<>();
     Set<Integer> set = new HashSet<>();
     for(int ele : nums) set.add(ele);
     for(int i=min;i<max;i++){
        if(!set.contains(i)) list.add(i);
     }
           return list;
    }
}