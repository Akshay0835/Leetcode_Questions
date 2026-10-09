class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    public int atMost(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int c = 0;
        int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        while (right < nums.length) {

            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            if (map.get(nums[right]) == 1) {
                c++;
            }

            while (c > k) {
                map.put(nums[left], map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                    c--;
                }

                left++;
            }

            ans += right - left + 1;

            right++;
        }

        return ans;
    }
}