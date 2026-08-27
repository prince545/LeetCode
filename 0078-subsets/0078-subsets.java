

class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int m = 1<<n;
                List<List<Integer>> ans = new ArrayList<>();
                for(int i=0;i<m;i++){
                            List<Integer> dum = new ArrayList<>();
                            for(int j=0;j<n;j++){
                                if((i>>j)%2==1) dum.add(nums[j]);
                            }
                            ans.add(dum);

                }

        return ans;
    }
}
