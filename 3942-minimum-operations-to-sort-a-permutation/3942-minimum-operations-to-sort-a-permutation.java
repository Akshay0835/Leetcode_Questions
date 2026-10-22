class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int p = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                p = i;
                break;
            }
        }

        boolean ascending = true;
        boolean descending = true;

        for (int i = 0; i < n; i++) {
            if (nums[(p + i) % n] != i) {
                ascending = false;
            }
            if (nums[(p - i + n) % n] != i) {
                descending = false;
            }
        }

        int ans = Integer.MAX_VALUE;

        if (ascending) {
            ans = Math.min(ans, Math.min(p, n - p + 2));
        }
        if (descending) {
            int cost3 = 1 + (n - 1 - p);
            int cost4 = (p + 1) % n + 1;
            ans = Math.min(ans, Math.min(cost3, cost4));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}