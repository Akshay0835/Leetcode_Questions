class Solution {

    static void solve(int index, int i, int nums[], List<List<Integer>> ans) {

        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < nums.length; j++) {
                list.add(nums[j]);
            }

            ans.add(list);
            return;
        }

        if (i == nums.length) {
            return;
        }
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
        solve(index + 1, index + 1, nums, ans);
        temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
        solve(index, i + 1, nums, ans);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, 0, nums, ans);
        return ans;
    }
}