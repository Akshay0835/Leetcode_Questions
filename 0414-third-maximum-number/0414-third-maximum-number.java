class Solution {
    public int thirdMax(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
            }
        }

        if (list.size() < 3) {
            return Collections.max(list);
        }

        int ans = 0;

        for (int i = 0; i < 3; i++) {
            ans = Collections.max(list);
            list.remove(Integer.valueOf(ans));
        }

        return ans;
    }
}