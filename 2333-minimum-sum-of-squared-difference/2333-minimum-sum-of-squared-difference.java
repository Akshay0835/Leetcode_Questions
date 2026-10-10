class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        long k = (long) k1 + k2;

        long[] diff = new long[nums1.length];
        long high = 0;

        for (int i = 0; i < nums1.length; i++) {
            diff[i] = Math.abs((long) nums1[i] - nums2[i]);
            high = Math.max(high, diff[i]);
        }

        long low = 0;

        while (low < high) {
            long mid = low + (high - low) / 2;
            long operations = 0;

            for (long d : diff) {
                if (d > mid) {
                    operations += d - mid;
                }
                if (operations > k) {
                    break;
                }
            }

            if (operations <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        long x = low;

        long used = 0;
        for (int i = 0; i < diff.length; i++) {
            if (diff[i] > x) {
                used += diff[i] - x;
                diff[i] = x;
            }
        }

        long remaining = k - used;

        // Only meaningful if x > 0; otherwise all diffs are already 0
        if (x > 0) {
            for (int i = 0; i < diff.length && remaining > 0; i++) {
                if (diff[i] == x) {
                    diff[i]--;
                    remaining--;
                }
            }
        }

        long ans = 0;
        for (long d : diff) {
            ans += d * d;
        }

        return ans;
    }
}