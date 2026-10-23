class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int total = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < weights.length; i++) {
            total += weights[i];
            max = Math.max(max, weights[i]);
        }

        int low = max;
        int high = total;

        while (low < high) {
            int mid = low + (high - low) / 2;

            int d = cal(weights, mid);

            if (d <= days) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public int cal(int[] weights, int capacity) {
        int days = 1;
        int sum = 0;

        for (int i = 0; i < weights.length; i++) {
            if (sum + weights[i] > capacity) {
                days++;
                sum = weights[i];
            } else {
                sum += weights[i];
            }
        }

        return days;
    }
}