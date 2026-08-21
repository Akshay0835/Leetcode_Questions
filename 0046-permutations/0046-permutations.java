class Solution {
    static void solve(int index, int nums[], List<List<Integer>> ans, List<Integer> list) {

        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (index == nums.length) {
            return;
        }

        if (!list.contains(nums[index])) {
            list.add(nums[index]);

            solve(0, nums, ans, list);

            list.remove(list.size() - 1);
        }

        solve(index + 1, nums, ans, list);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        solve(0, nums, ans, list);

        return ans;
    }
}