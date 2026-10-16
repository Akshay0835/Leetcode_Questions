class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        if (goal == 0) {
            int count = 0;
            int zeros = 0;

            for (int num : nums) {
                if (num == 0) {
                    zeros++;
                    count += zeros;
                } else {
                    zeros = 0;
                }
            }

            return count;
        }

        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;
        int zeros = 0;

        while (right < nums.length) {
            sum += nums[right];

            while (sum > goal) {
                sum -= nums[left];
                left++;
                zeros = 0;
            }

            if (sum == goal) {
                while (left < right && nums[left] == 0) {
                    zeros++;
                    left++;
                }

                count += zeros + 1;
            }

            right++;
        }

        return count;
    }
}