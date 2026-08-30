class Solution {
    public int minimumDeletions(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int n = nums.length;

        int max = nums[0];
        int min = nums[0];
        int indexmax = 0;
        int indexmin = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                indexmax = i;
            }

            if (nums[i] < min) {
                min = nums[i];
                indexmin = i;
            }
        }
        int left = Math.max(indexmin, indexmax) + 1;
        int right = n - Math.min(indexmin, indexmax);
        int mixed1 = indexmin + 1 + (n - indexmax);
        int mixed2 = indexmax + 1 + (n - indexmin);

        return Math.min(
            Math.min(left, right),
            Math.min(mixed1, mixed2)
        );
    }
}