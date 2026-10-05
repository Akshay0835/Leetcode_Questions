class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += cardPoints[i];
        }

        if (k == n) {
            return totalSum;
        }

        int windowSize = n - k;

        int windowSum = 0;

        for (int i = 0; i < windowSize; i++) {
            windowSum += cardPoints[i];
        }

        int minSum = windowSum;

        int left = 0;
        int right = windowSize;

        while (right < n) {
            windowSum = windowSum - cardPoints[left] + cardPoints[right];

            minSum = Math.min(minSum, windowSum);

            left++;
            right++;
        }

        return totalSum - minSum;
    }
}