class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {

        int[] arr = new int[nums.length + 1];

        int ans = 0;
        int left = 0;
        int right = 0;
        int count = 0;

        while (right < nums.length) {
            if (arr[nums[right++]]++ == 0) {
                k--;
            }
             if (k < 0) {
                --arr[nums[left++]];
                k++;
                count = 0;
            }

            if (k == 0) {
                while (arr[nums[left]] > 1) {
                    --arr[nums[left++]];
                    count++;
                }
                ans += (count + 1);
            }
        }
        return ans;
    }
}