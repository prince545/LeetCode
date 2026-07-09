class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i=0,j=nums.length-1;
        int[] ans = {-1,-1};
        while (i <= j) {
    if (nums[i] == target && nums[j] == target) {
        ans[0] = i;
        ans[1] = j;
        break;
    }

    if (nums[i] != target) i++;
    if (nums[j] != target) j--;
}
        return ans;
    }
}