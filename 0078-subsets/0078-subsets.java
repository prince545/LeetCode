

class Solution {

    public static void fun(ArrayList<Integer> list, int[] nums, int idx, List<List<Integer>> ans) {

        if(idx == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        // include
        list.add(nums[idx]);
        fun(list, nums, idx+1, ans);

        // backtrack
        list.remove(list.size()-1);

        // exclude
        fun(list, nums, idx+1, ans);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        fun(new ArrayList<Integer>(), nums, 0, ans);
        return ans;
    }
}
